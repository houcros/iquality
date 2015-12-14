/*
 * 
 */
package com.indra.iquality.model;

import com.google.common.base.Objects;

// TODO: Auto-generated Javadoc
/**
 * The Class CertificacionDeNegocio. Represents a business certification that
 * must be satisfied for the system to be in a valid status.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.1, 09/12/15
 * 
 */
public class BusinessCertificate extends Certificate {

	/** The name of the certification. */
	private String indicador;

	/**
	 * Gets the name of the certification.
	 *
	 * @return the name of the certification
	 */
	public String getIndicador() {
		return indicador;
	}

	/**
	 * Sets the name of the certification.
	 *
	 * @param indicador
	 *            the new name of the certification
	 */
	public void setIndicador(String indicador) {
		this.indicador = indicador;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(fecha, seccion, subseccion, entidad, certificacion, deCertificacion, indicador, estado,
				idMetrica, idMes);
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
			return Objects.equal(fecha, other.fecha) && Objects.equal(seccion, other.seccion)
					&& Objects.equal(subseccion, other.subseccion) && Objects.equal(entidad, other.entidad)
					&& Objects.equal(deCertificacion, other.deCertificacion)
					&& Objects.equal(certificacion, other.certificacion) && Objects.equal(indicador, other.indicador)
					&& Objects.equal(estado, other.estado) && Objects.equal(idMetrica, other.idMetrica)
					&& Objects.equal(idMes, other.idMes);
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
		return "ValidacionTecnica [fecha=" + fecha + ", seccion=" + seccion + ", subseccion=" + subseccion
				+ ", entidad=" + entidad + ", certificacion=" + deCertificacion + ", indicador=" + indicador
				+ ", estado=" + estado + "]";
	}

}
