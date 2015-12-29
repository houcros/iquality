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
 * The Class BaseController.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 14-dic-2015
 * 
 *          The Class BaseController.
 */
@Controller
public class BaseController {

	/** The Constant pointing to the main page of the application. */
	private static final String VIEW_INDEX = "index";

	/** The Constant pointing to the login view. */
	private static final String VIEW_LOGIN = "login";

	/** The Constant pointing to the registration view. */
	private static final String VIEW_REGISTRATION = "registration";

	/** The Constant pointing to the default view when a page was not found. */
	private static final String VIEW_NOT_FOUND = "404";

	/** The Constant pointing to the default error page. */
	private static final String VIEW_ERROR = "500";

	/** The Constant logger. */
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

	/**
	 * Handles a GET request to display the main page of the application.
	 *
	 * @param model
	 *            the model to pass data to the view
	 * @return the view to display
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	private String showMain(ModelMap model) {
		logger.info("[showMain] : INIT");
		logger.info("[showMain] : RETURN");
		return VIEW_INDEX;
	}

	/**
	 * Handles a GET request to display the login view.
	 *
	 * @param model
	 *            the model to pass data to the view
	 * @return the view to display
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	private String showLogin(ModelMap model) {
		logger.info("[showLogin] : INIT");
		logger.info("[showLogin] : RETURN");
		return VIEW_LOGIN;
	}

	/**
	 * Handles a GET request to display the registration view.
	 *
	 * @param model
	 *            the model to pass data to the view
	 * @return the view to display
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	private String showRegistration(ModelMap model) {
		logger.info("[showRegistration] : INIT");
		logger.info("[showRegistration] : RETURN");
		return VIEW_REGISTRATION;
	}

	/**
	 * Handles a GET request to display the default view when a page was not
	 * found.
	 *
	 * @param model
	 *            the model to pass data to the view
	 * @return the view to display
	 */
	@RequestMapping(value = "/not-found", method = RequestMethod.GET)
	private String notFound(ModelMap model) {
		logger.info("[notFound] : INIT");
		logger.info("[notFound] : RETURN");
		return VIEW_NOT_FOUND;
	}

	/**
	 * Handles a GET request to display the default error page.
	 *
	 * @param model
	 *            the model to pass data to the view
	 * @return the view to display
	 */
	@RequestMapping(value = "/server-error", method = RequestMethod.GET)
	private String serverError(ModelMap model) {
		logger.info("[serverError] : INIT");
		logger.info("[serverError] : RETURN");
		return VIEW_ERROR;
	}

}