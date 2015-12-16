/*
 * 
 */
package com.indra.iquality.model;

/**
 * The Class DetailOfCertificate. Represents the details of a business
 * certificate.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 16-dic-2015
 * 
 *          The Class DetailOfCertificate.
 */
public class BusinessCertificateDetail {

	/** The maximum number of dimensions that a detail view will have. */
	public static final int MAX_DIMENSIONES = 6;

	/** The date. */
	private String date;

	/** The value of the dimension 1. */
	private String valDimension1;

	/** The value of the dimension 2. */
	private String valDimension2;

	/** The value of the dimension 3. */
	private String valDimension3;

	/** The value of the dimension 4. */
	private String valDimension4;

	/** The value of the dimension 5. */
	private String valDimension5;

	/** The value of the dimension 6. */
	private String valDimension6;

	/** The value of MetricaAct. */
	private String hcValMetricaAct;

	/** The status. */
	private String status;

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date
	 *            the new date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Gets the value of the dimension 1.
	 *
	 * @return the value of the dimension 1
	 */
	public String getValDimension1() {
		return valDimension1;
	}

	/**
	 * Sets the value of the dimension 1.
	 *
	 * @param valDimension1
	 *            the new value of the dimension 1
	 */
	public void setValDimension1(String valDimension1) {
		this.valDimension1 = valDimension1;
	}

	/**
	 * Gets the value of the dimension 2.
	 *
	 * @return the value of the dimension 2
	 */
	public String getValDimension2() {
		return valDimension2;
	}

	/**
	 * Sets the value of the dimension 2.
	 *
	 * @param valDimension2
	 *            the new value of the dimension 2
	 */
	public void setValDimension2(String valDimension2) {
		this.valDimension2 = valDimension2;
	}

	/**
	 * Gets the value of the dimension 3.
	 *
	 * @return the value of the dimension 3
	 */
	public String getValDimension3() {
		return valDimension3;
	}

	/**
	 * Sets the value of the dimension 3.
	 *
	 * @param valDimension3
	 *            the new value of the dimension 3
	 */
	public void setValDimension3(String valDimension3) {
		this.valDimension3 = valDimension3;
	}

	/**
	 * Gets the value of the dimension 4.
	 *
	 * @return the value of the dimension 4
	 */
	public String getValDimension4() {
		return valDimension4;
	}

	/**
	 * Sets the value of the dimension 4.
	 *
	 * @param valDimension4
	 *            the new value of the dimension 4
	 */
	public void setValDimension4(String valDimension4) {
		this.valDimension4 = valDimension4;
	}

	/**
	 * Gets the value of the dimension 5.
	 *
	 * @return the value of the dimension 5
	 */
	public String getValDimension5() {
		return valDimension5;
	}

	/**
	 * Sets the value of the dimension 5.
	 *
	 * @param valDimension5
	 *            the new value of the dimension 5
	 */
	public void setValDimension5(String valDimension5) {
		this.valDimension5 = valDimension5;
	}

	/**
	 * Gets the value of the dimension 6.
	 *
	 * @return the value of the dimension 6
	 */
	public String getValDimension6() {
		return valDimension6;
	}

	/**
	 * Sets the value of the dimension 6.
	 *
	 * @param valDimension6
	 *            the new value of the dimension 6
	 */
	public void setValDimension6(String valDimension6) {
		this.valDimension6 = valDimension6;
	}

	/**
	 * Gets the value of MetricaAct.
	 *
	 * @return the value of MetricaAct
	 */
	public String getHcValMetricaAct() {
		return hcValMetricaAct;
	}

	/**
	 * Sets the value of MetricaAct.
	 *
	 * @param hcValMetricaAct
	 *            the new value of MetricaAct
	 */
	public void setHcValMetricaAct(String hcValMetricaAct) {
		this.hcValMetricaAct = hcValMetricaAct;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DetalleDeCertificacion [fecha=" + date + ", valDimension1=" + valDimension1 + ", valDimension2="
				+ valDimension2 + ", valDimension3=" + valDimension3 + ", valDimension4=" + valDimension4
				+ ", valDimension5=" + valDimension5 + ", valDimension6=" + valDimension6 + ", hcValMetricaAct="
				+ hcValMetricaAct + ", estado=" + status + "]";
	}

}
