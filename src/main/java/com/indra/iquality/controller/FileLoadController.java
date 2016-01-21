package com.indra.iquality.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.indra.iquality.dao.FileLoadDAO;
import com.indra.iquality.singleton.Environment;

@Controller
@RequestMapping("/carga")
public class FileLoadController {

	/** The Constant logger. */
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(FileLoadController.class);

	/** The Constant reference to the environment. */
	private final static Environment environment = Environment.getInstance();

	private final static String ACCEPTED_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	private final static String FILES_PATH = "C:/Users/inlucero/Documents/workspace-sts-3.7.0.RELEASE/iQuality/src/main/resources";

	/** The Constant pointing to the view of all the executions. */
	private static final String VIEW_LOAD = "cargar-ficheros";

	@RequestMapping(method = RequestMethod.GET)
	private String loadFiles(Model model) {

		logger.info("[loadFiles] : INIT");

		// Abro el contexto para crear un DAO
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		FileLoadDAO fileLoadDAO = ctx.getBean("fileLoadDAOJDBCTemplate", FileLoadDAO.class);
		ctx.close();

		// Obtengo todos las tablas
		List<String> allTables = null;
		try {
			allTables = fileLoadDAO.getAllTables(environment.getSystem(), environment.getCurrentSoftware());
			logger.debug("[loadFiles] : Obtenidas todas las tablas.");
		} catch (Exception e) {
			logger.error("[loadFiles] : Excepción <{}> | Ayuda: {}  \n {}", e.getClass(), e.getMessage(),
					e.getStackTrace());
			return "redirect:/server-error";
		}

		// Paso todos los pases a la vista
		model.addAttribute("allTables", allTables);

		logger.info("[loadFiles] : RETURN");
		return VIEW_LOAD;
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody JSONObject handleFileUpload(MultipartHttpServletRequest request, HttpServletResponse response)
			throws IOException {

		// Sólo debería aceptar tipos xlsx:
		// application/vnd.openxmlformats-officedocument.spreadsheetml.sheet
		// See
		// http://blogs.msdn.com/b/vsofficedeveloper/archive/2008/05/08/office-2007-open-xml-mime-types.aspx
		logger.info("[handleFileUpload] : INIT");

		Iterator<String> iterator = request.getFileNames();
		MultipartFile mpf = null;
		while (iterator.hasNext()) {
			// Obtengo el fichero
			mpf = request.getFile(iterator.next());

			// Retornar un error si el fichero no es un xlsx
			if (!mpf.getContentType().equals(ACCEPTED_TYPE)) {
				logger.info("[handleFileUpload] : RETURN (Error)");
				JSONObject item = new JSONObject();
				item.put("name", mpf.getOriginalFilename());
				JSONArray jsonArray = new JSONArray();
				jsonArray.add(item);
				item.clear();
				item.put("error", "Content-type not supported");
				jsonArray.add(item);
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("files", jsonArray);
				return jsonObject;
			}

			// Abro el contexto para crear un DAO
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
			FileLoadDAO fileLoadDAO = ctx.getBean("fileLoadDAOJDBCTemplate", FileLoadDAO.class);
			ctx.close();

			// Tratar el fichero
			// Primero lo copio a disco en el server
			FileCopyUtils.copy(mpf.getBytes(),
					new FileOutputStream(FILES_PATH + File.separator + mpf.getOriginalFilename()));
			logger.info("[handleFileUpload] : Saved file to disk in the current server directory.");

			try {
				// Lo leo de donde lo acabo de guardar
				Workbook wb = WorkbookFactory.create(new File(FILES_PATH + File.separator + mpf.getOriginalFilename()));
				Sheet sheet1 = wb.getSheetAt(0);
				// Necesario para formatear los diferentes tipos de datos
				DataFormatter formatter = new DataFormatter();

				// Itero sobre las celdas
				for (Row row : sheet1) {
					// Skip the headers
					if (row.getRowNum() == 0)
						continue;
					// Valores de las columnas de una fila
					Object[] columns = new Object[row.getLastCellNum()];

					for (Cell cell : row) {
						String content = null;
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							// content =
							// cell.getRichStringCellValue().getString();
							content = formatter.formatCellValue(cell);
							break;
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(cell)) {
								// content = cell.getDateCellValue().toString();
								content = formatter.formatCellValue(cell);
							} else {
								// content =
								// Double.valueOf(cell.getNumericCellValue()).toString();
								content = formatter.formatCellValue(cell);
							}
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							// content =
							// String.valueOf(cell.getBooleanCellValue());
							content = formatter.formatCellValue(cell);
							break;
						case Cell.CELL_TYPE_FORMULA:
							// content = cell.getCellFormula();
							content = formatter.formatCellValue(cell);
							break;
						default:
							content = "NULL";
						}
						// Acumulo las columnas
						columns[cell.getColumnIndex()] = content;
						logger.info("[handleFileUpload] : Element (" + cell.getRowIndex() + ", " + cell.getColumnIndex()
								+ ") is " + content);
					}

					// Inserto la fila
					fileLoadDAO.saveToTempTable(columns, "tm_ods_fpp_man_inm_terreno_ind",
							Environment.getInstance().getSystem(), Environment.getInstance().getCurrentSoftware());
				}

				// Tratar diferentes excepciones
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			logger.info("[handleFileUpload] : " + mpf.getOriginalFilename());
			logger.info("[handleFileUpload] : " + mpf.getSize());
		}

		// Pongo estos datos para actualizar la vista mediante js
		JSONObject item = new JSONObject();
		item.put("name", mpf.getOriginalFilename());
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(item);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("files", jsonArray);

		// Retorno
		logger.info("[handleFileUpload] : RETURN");
		return jsonObject;
	}

}
