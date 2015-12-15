/*
 * 
 */
package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.DetailOfValidation;
import com.indra.iquality.model.TechnicalCertificate;

/**
 * The Interface to interact with the persistent representations of technical
 * certificates.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 15-dic-2015
 * 
 *          The Interface TechnicalCertificateDAO.
 */
public interface TechnicalCertificateDAO {

	/**
	 * Gets all the technical certificates of a system with a software version.
	 *
	 * @param sistema
	 *            the system
	 * @param software
	 *            the software version
	 * @return all the technical certificates
	 */
	public List<TechnicalCertificate> getAll(String sistema, int software);

	/**
	 * Gets the details of a technical certification given its metric and month
	 * of execution. Updates the values of the headers and number of columns of
	 * the detailed view. @see #getLastNumCols() and @see #getHeaders().
	 *
	 * @param idMetrica
	 *            the identifier of the metric of the certificate
	 * @param idMes
	 *            the month of execution of the certificate
	 * @param sistema
	 *            the system
	 * @param software
	 *            the software version
	 * @return the details of a technical certification
	 */
	public List<DetailOfValidation> getCertificateDetails(String idMetrica, String idMes, String sistema, int software);

	/**
	 * Gets the number of dimensions of the detailed view of the last
	 * certificate consulted. In other words, the number of columns that the
	 * detailed view should have after the last call to
	 * {@link #getCertificateDetails}. So this method SHOULD NOT be called
	 * before {@link #getCertificateDetails}.
	 *
	 * @return the number of columns of the detailed view
	 */
	public int getLastNumCols();

	/**
	 * Gets the description of the headers of the detailed view of the last
	 * certificate consulted. In other words, the text to display in the columns
	 * that the detailed view should have after the last call to
	 * {@link #getCertificateDetails}. So this method SHOULD NOT be called
	 * before {@link #getCertificateDetails}.
	 *
	 * @return the headers of the columns of the detailed view
	 */
	public List<String> getHeaders();
}
