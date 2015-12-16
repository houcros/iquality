/*
 * 
 */
package com.indra.iquality.model;

import com.google.common.base.Objects;

/**
 * The Class CertificacionDeNegocio. Represents a business certificate that must
 * be satisfied for the system to be in a valid state.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.1, 09/12/15
 * 
 */
public class BusinessCertificate extends Certificate {

	/** The name of the certificate. */
	private String indicator;

	/**
	 * Gets the name of the certificate.
	 *
	 * @return the name of the certificate
	 */
	public String getIndicator() {
		return indicator;
	}

	/**
	 * Sets the name of the certificate.
	 *
	 * @param indicator
	 *            the new name of the certificate
	 */
	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(date, section, subsection, entity, certificate, certificateDescription, indicator,
				status, metric, month);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (obj.getClass() == getClass()) {
			final BusinessCertificate other = (BusinessCertificate) obj;
			return Objects.equal(date, other.date) && Objects.equal(section, other.section)
					&& Objects.equal(subsection, other.subsection) && Objects.equal(entity, other.entity)
					&& Objects.equal(certificateDescription, other.certificateDescription)
					&& Objects.equal(certificate, other.certificate) && Objects.equal(indicator, other.indicator)
					&& Objects.equal(status, other.status) && Objects.equal(metric, other.metric)
					&& Objects.equal(month, other.month);
		} else
			return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ValidacionTecnica [fecha=" + date + ", seccion=" + section + ", subseccion=" + subsection + ", entidad="
				+ entity + ", certificacion=" + certificateDescription + ", indicador=" + indicator + ", estado="
				+ status + "]";
	}

}
