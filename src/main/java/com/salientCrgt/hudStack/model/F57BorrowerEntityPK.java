package com.salientCrgt.hudStack.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the F57_BORROWER database table.
 * 
 */
@Embeddable
public class F57BorrowerEntityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="TX_SSN")
	private String txSsn;

	@Column(name="TX_SSN_TAXID_IND")
	private String txSsnTaxidInd;

	@Column(name="TX_CASE_NO")
	private String txCaseNo;

	@Column(name="TX_AGENCY_CODE")
	private String txAgencyCode;

	@Column(name="TX_CASE_CODE")
	private String txCaseCode;

	public F57BorrowerEntityPK() {
	}
	public String getTxSsn() {
		return this.txSsn;
	}
	public void setTxSsn(String txSsn) {
		this.txSsn = txSsn;
	}
	public String getTxSsnTaxidInd() {
		return this.txSsnTaxidInd;
	}
	public void setTxSsnTaxidInd(String txSsnTaxidInd) {
		this.txSsnTaxidInd = txSsnTaxidInd;
	}
	public String getTxCaseNo() {
		return this.txCaseNo;
	}
	public void setTxCaseNo(String txCaseNo) {
		this.txCaseNo = txCaseNo;
	}
	public String getTxAgencyCode() {
		return this.txAgencyCode;
	}
	public void setTxAgencyCode(String txAgencyCode) {
		this.txAgencyCode = txAgencyCode;
	}
	public String getTxCaseCode() {
		return this.txCaseCode;
	}
	public void setTxCaseCode(String txCaseCode) {
		this.txCaseCode = txCaseCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof F57BorrowerEntityPK)) {
			return false;
		}
		F57BorrowerEntityPK castOther = (F57BorrowerEntityPK)other;
		return 
			this.txSsn.equals(castOther.txSsn)
			&& this.txSsnTaxidInd.equals(castOther.txSsnTaxidInd)
			&& this.txCaseNo.equals(castOther.txCaseNo)
			&& this.txAgencyCode.equals(castOther.txAgencyCode)
			&& this.txCaseCode.equals(castOther.txCaseCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.txSsn.hashCode();
		hash = hash * prime + this.txSsnTaxidInd.hashCode();
		hash = hash * prime + this.txCaseNo.hashCode();
		hash = hash * prime + this.txAgencyCode.hashCode();
		hash = hash * prime + this.txCaseCode.hashCode();
		
		return hash;
	}
}