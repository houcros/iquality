package com.indra.iquality.model;

import com.google.common.base.Objects;

public class CertificacionDeNegocio extends Certificacion {

	private String indicador;

	public String getIndicador() {
		return indicador;
	}
	public void setIndicador(String indicador) {
		this.indicador = indicador;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(fecha, seccion, subseccion, entidad, certificacion, indicador, estado, idMetrica, idMes);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null) return false;
		if (obj.getClass() == getClass()){
			final CertificacionDeNegocio other = (CertificacionDeNegocio) obj;
			return Objects.equal(fecha, other.fecha)
					&& Objects.equal(seccion, other.seccion)
					&& Objects.equal(subseccion, other.subseccion)
					&& Objects.equal(entidad, other.entidad)
					&& Objects.equal(certificacion, other.certificacion)
					&& Objects.equal(indicador, other.indicador)
					&& Objects.equal(estado, other.estado)
					&& Objects.equal(idMetrica, other.idMetrica)
					&& Objects.equal(idMes, other.idMes);
		}
		else return false;
	}
	
	@Override
	public String toString() {
		return "ValidacionTecnica [fecha=" + fecha + ", seccion=" + seccion + ", subseccion=" + subseccion
				+ ", entidad=" + entidad + ", certificacion=" + certificacion + ", indicador=" + indicador
				+ ", estado=" + estado + "]";
	}
	
}
