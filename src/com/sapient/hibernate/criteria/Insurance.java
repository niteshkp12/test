package com.sapient.hibernate.criteria;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Deepak Kumar
 * 
 *         http://www.roseindia.net Java Class to map to the database insurance
 *         table
 */
@Entity
@Table(name = "INSURANCE")
public class Insurance {
	@Id
	@GeneratedValue
	private long lngInsuranceId;
	private String insuranceName;
	private int investementAmount;
	private Date investementDate;

	public Insurance() {
		super();
	}

	public Insurance(String insuranceName,
			int investementAmount, Date investementDate) {
		super();
		this.insuranceName = insuranceName;
		this.investementAmount = investementAmount;
		this.investementDate = investementDate;
	}

	/**
	 * @return Returns the insuranceName.
	 */
	public String getInsuranceName() {
		return insuranceName;
	}

	/**
	 * @param insuranceName
	 *            The insuranceName to set.
	 */
	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	/**
	 * @return Returns the investementAmount.
	 */
	public int getInvestementAmount() {
		return investementAmount;
	}

	/**
	 * @param investementAmount
	 *            The investementAmount to set.
	 */
	public void setInvestementAmount(int investementAmount) {
		this.investementAmount = investementAmount;
	}

	/**
	 * @return Returns the investementDate.
	 */
	public Date getInvestementDate() {
		return investementDate;
	}

	/**
	 * @param investementDate
	 *            The investementDate to set.
	 */
	public void setInvestementDate(Date investementDate) {
		this.investementDate = investementDate;
	}

	/**
	 * @return Returns the lngInsuranceId.
	 */
	public long getLngInsuranceId() {
		return lngInsuranceId;
	}

	/**
	 * @param lngInsuranceId
	 *            The lngInsuranceId to set.
	 */
	public void setLngInsuranceId(long lngInsuranceId) {
		this.lngInsuranceId = lngInsuranceId;
	}
}
