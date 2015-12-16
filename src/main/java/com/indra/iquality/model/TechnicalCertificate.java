/*
 * 
 */
package com.indra.iquality.model;

import com.google.common.base.Objects;

/**
 * The Class TechnicalCertificate. Represents a technical certificate.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 16-dic-2015
 * 
 *          The Class TechnicalCertificate.
 */
public class TechnicalCertificate extends Certificate {

	/** The number of registers. */
	private int numberOfRegisters;

	/**
	 * Gets the number of registers.
	 *
	 * @return the number of registers
	 */
	public int getNumberOfRegisters() {
		return numberOfRegisters;
	}

	/**
	 * Sets the number of registers.
	 *
	 * @param numRegistros
	 *            the new number of registers
	 */
	public void setNumberOfRegisters(int numRegistros) {
		this.numberOfRegisters = numRegistros;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(date, section, subsection, entity, certificate, certificateDescription,
				numberOfRegisters, status);
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
			final TechnicalCertificate other = (TechnicalCertificate) obj;
			return Objects.equal(date, other.date) && Objects.equal(section, other.section)
					&& Objects.equal(subsection, other.subsection) && Objects.equal(entity, other.entity)
					&& Objects.equal(certificate, other.certificate)
					&& Objects.equal(certificateDescription, other.certificateDescription)
					&& numberOfRegisters == other.numberOfRegisters && Objects.equal(status, other.status);
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
		return "ValidacionTecnica [numRegistros=" + numberOfRegisters + ", idMetrica=" + metric + ", idMes=" + month
				+ ", fecha=" + date + ", seccion=" + section + ", subseccion=" + subsection + ", entidad=" + entity
				+ ", certificacion=" + certificate + ", deCertificacion=" + certificateDescription + ", estado="
				+ status + "]";
	}
}
