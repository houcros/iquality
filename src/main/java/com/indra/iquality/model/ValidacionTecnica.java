package com.indra.iquality.model;

import com.google.common.base.Objects;
//import org.apache.commons.lang3.builder.EqualsBuilder;
//import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ValidacionTecnica extends Certificacion{

	private int numRegistros;
	
	public int getNumRegistros() {
		return numRegistros;
	}
	public void setNumRegistros(int numRegistros) {
		this.numRegistros = numRegistros;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(fecha, seccion, subseccion, entidad, deCertificacion, numRegistros, estado);
		/*
		 * Con Apache Commons
		return new HashCodeBuilder(31, 33). // two randomly chosen prime numbers
				// if deriving: appendSuper(super.hashCode()).
				append(fecha).
				append(seccion).
				append(subseccion).
				append(entidad).
				append(certificacion).
				append(numRegistros).
				append(estado).
				toHashCode();
		*/
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null) return false;
		if (obj.getClass() == getClass()){
			final ValidacionTecnica other = (ValidacionTecnica) obj;
			return Objects.equal(fecha, other.fecha)
					&& Objects.equal(seccion, other.seccion)
					&& Objects.equal(subseccion, other.subseccion)
					&& Objects.equal(entidad, other.entidad)
					&& Objects.equal(deCertificacion, other.deCertificacion)
					&& numRegistros == other.numRegistros
					&& Objects.equal(estado, other.estado);
		}
		else return false;
		
		/*
		 * Con Apache Commons
		if (obj == this) return true;
		if (obj == null) return false;
		if (obj.getClass() != getClass()) return false;
		return new EqualsBuilder().
				// if deriving: appendSuper(super.equals(obj)).
				append(fecha, other.fecha).
				append(seccion, other.seccion).
				append(subseccion, other.subseccion).
				append(entidad, other.entidad).
				append(certificacion, other.certificacion).
				append(numRegistros, other.numRegistros).
				append(estado, other.estado).
				isEquals();
		 */
	}
	
	@Override
	public String toString() {
		return "ValidacionTecnica [fecha=" + fecha + ", seccion=" + seccion + ", subseccion=" + subseccion
				+ ", entidad=" + entidad + ", certificacion=" + deCertificacion + ", numRegistros=" + numRegistros
				+ ", estado=" + estado + "]";
	}
}
