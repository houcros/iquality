/*
 * 
 */
package com.indra.iquality.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The Class DictionaryController. Handles the requests to display the
 * dictionary of concepts. See {@link APIController} if you don't see some
 * methods related to the dictionary of concepts that you might have expected to
 * find here.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 14-dic-2015
 * 
 *          The Class DictionaryController.
 */
@Controller
@RequestMapping("/diccionario")
public class DictionaryController {

	/** The Constant logger. */
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(DictionaryController.class);

	/** The Constant pointing to the dictionary of concepts. */
	private static final String VIEW_DICTIONARY = "diccionario";

	/**
	 * Handles a GET request to display the dictionary of concepts.
	 *
	 * @param model
	 *            the model to pass data to the view
	 * @return the view to display
	 */
	@RequestMapping(method = RequestMethod.GET)
	private String showDictionary(ModelMap model) {
		logger.info("[showDictionary] : INIT");
		logger.info("[showDictionary] : RETURN");
		return VIEW_DICTIONARY;
	}
}
