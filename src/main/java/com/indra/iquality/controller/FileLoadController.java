package com.indra.iquality.controller;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.indra.iquality.singleton.Environment;

@Controller
@RequestMapping("/carga")
public class FileLoadController {

	/** The Constant logger. */
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(FileLoadController.class);

	/** The Constant reference to the environment. */
	private final static Environment environment = Environment.getInstance();

	private final static String ACCEPTED_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	/** The Constant pointing to the view of all the executions. */
	private static final String VIEW_LOAD = "cargar-ficheros";

	@RequestMapping(method = RequestMethod.GET)
	private String loadFiles(Model model) {

		logger.info("[loadFiles] : INIT");
		// Hacer cosas
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
			mpf = request.getFile(iterator.next());
			// do something with the file.....
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

			logger.info("[handleFileUpload] : " + mpf.getOriginalFilename());
			logger.info("[handleFileUpload] : " + mpf.getSize());
		}
		logger.info("[handleFileUpload] : RETURN");
		JSONObject item = new JSONObject();
		item.put("name", mpf.getOriginalFilename());
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(item);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("files", jsonArray);
		return jsonObject;
	}

}
