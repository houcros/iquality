/*
 * 
 */
package com.indra.iquality.model;

import com.google.common.base.Objects;

// TODO: Auto-generated Javadoc
/**
 * The Class CertificacionDeNegocio.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.1, 09/12/15
 * 
 *          The Class CertificacionDeNegocio.
 */
public class CertificacionDeNegocio extends Certificacion {

	/** The indicador. */
	private String indicador;

	/**
	 * Gets the indicador.
	 *
	 * @return the indicador
	 */
	public String getIndicador() {
		return indicador;
	}

	/**
	 * Sets the indicador.
	 *
	 * @param indicador
	 *            the new indicador
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
			final CertificacionDeNegocio other = (CertificacionDeNegocio) obj;
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
