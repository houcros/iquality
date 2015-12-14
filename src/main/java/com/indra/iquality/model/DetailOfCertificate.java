package com.indra.iquality.model;

public class DetailOfCertificate {

	public static final int MAX_DIMENSIONES = 6;
	
	private String fecha;
	private String valDimension1;
	private String valDimension2;
	private String valDimension3;
	private String valDimension4;
	private String valDimension5;
	private String valDimension6;
	private String hcValMetricaAct;
	private String estado;
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getValDimension1() {
		return valDimension1;
	}
	public void setValDimension1(String valDimension1) {
		this.valDimension1 = valDimension1;
	}
	public String getValDimension2() {
		return valDimension2;
	}
	public void setValDimension2(String valDimension2) {
		this.valDimension2 = valDimension2;
	}
	public String getValDimension3() {
		return valDimension3;
	}
	public void setValDimension3(String valDimension3) {
		this.valDimension3 = valDimension3;
	}
	public String getValDimension4() {
		return valDimension4;
	}
	public void setValDimension4(String valDimension4) {
		this.valDimension4 = valDimension4;
	}
	public String getValDimension5() {
		return valDimension5;
	}
	public void setValDimension5(String valDimension5) {
		this.valDimension5 = valDimension5;
	}
	public String getValDimension6() {
		return valDimension6;
	}
	public void setValDimension6(String valDimension6) {
		this.valDimension6 = valDimension6;
	}
	public String getHcValMetricaAct() {
		return hcValMetricaAct;
	}
	public void setHcValMetricaAct(String hcValMetricaAct) {
		this.hcValMetricaAct = hcValMetricaAct;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "DetalleDeCertificacion [fecha=" + fecha + ", valDimension1=" + valDimension1 + ", valDimension2="
				+ valDimension2 + ", valDimension3=" + valDimension3 + ", valDimension4=" + valDimension4
				+ ", valDimension5=" + valDimension5 + ", valDimension6=" + valDimension6 + ", hcValMetricaAct="
				+ hcValMetricaAct + ", estado=" + estado + "]";
	}
	
}
