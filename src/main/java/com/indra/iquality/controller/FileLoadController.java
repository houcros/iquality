package com.indra.iquality.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.indra.iquality.singleton.Environment;

@Controller
@RequestMapping("/carga")
public class FileLoadController {

	/** The Constant logger. */
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(FileLoadController.class);

	/** The Constant reference to the environment. */
	private final static Environment environment = Environment.getInstance();

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
	public @ResponseBody String handleFileUpload(@RequestParam("files[]") String name,
			@RequestParam("file") MultipartFile file) {

		logger.info("[handleFileUpload] : INIT");

		String ret = null;
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name)));
				stream.write(bytes);
				stream.close();
				ret = "You successfully uploaded " + name + "!";
				logger.info("[handleFileUpload] : " + ret);
				return ret;
			} catch (Exception e) {
				ret = "You failed to upload " + name + " => " + e.getMessage();
				logger.info("[handleFileUpload] : " + ret);
				return ret;
			}
		} else {
			ret = "You failed to upload " + name + " because the file was empty.";
			logger.info("[handleFileUpload] : " + ret);
			return ret;
		}
	}

}
