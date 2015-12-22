/*
 * 
 */
package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.BusinessCertificate;
import com.indra.iquality.model.BusinessCertificateDetail;
import com.indra.iquality.model.certificate.CertificateCondition;

/**
 * The Interface to interact with the persistent representations of business
 * certificates. See {@link com.indra.iquality.model.BusinessCertificate}.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.1, 09/12/15
 * 
 *          The Interface BusinessCertificateDAO.
 * 
 */
public interface BusinessCertificateDAO {

	/**
	 * Gets all the records of business certifications for a given system and
	 * software version.
	 *
	 * @param sistema
	 *            the current system
	 * @param software
	 *            the current software version
	 * @return all the business certifications for the current system and
	 *         software version
	 */
	public List<BusinessCertificate> getAll(String sistema, int software);

	/**
	 * Gets the headers of the required fields to represent a detailed view of a
	 * {@link com.indra.iquality.model.BusinessCertificate} for a given system
	 * and software version. Headers are dynamic, i.e., their content and amount
	 * may vary for different instances of the
	 * {@link com.indra.iquality.model.BusinessCertificate}.
	 *
	 * @param idMetrica
	 *            the identifier for an instance of
	 *            {@link com.indra.iquality.model.BusinessCertificate}
	 * @param sistema
	 *            the current system
	 * @param software
	 *            the current software version
	 * @return a list of headers for the detailed view
	 */
	public List<String> getDetailHeaders(String idMetrica, String sistema, int software);

	/**
	 * Gets the details for an instance of
	 * {@link com.indra.iquality.model.BusinessCertificate} for a given system
	 * and software version.
	 *
	 * @param idMes
	 *            the month for which we want the details
	 * @param idMetrica
	 *            the identifier for an instance of CertificacionDeNegocio
	 * @param qttHeaders
	 *            the amount of fields the detailed view has; see
	 *            {@link #getDetailHeaders}
	 * @param sistema
	 *            the current system
	 * @param software
	 *            the current software version
	 * @return a list of all the details of a business certification
	 */
	public List<BusinessCertificateDetail> getCertificateDetails(String idMes, String idMetrica, int qttHeaders,
			String sistema, int software);

	public List<CertificateCondition> getCertificateConditions(String sistema, int software);
}
