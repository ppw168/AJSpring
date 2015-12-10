package com.salientCrgt.hudStack.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the F57_SUSPEND database table.
 * 
 */
@Embeddable
public class F57SuspendEntityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="TX_SSN", insertable=false, updatable=false)
	private String txSsn;

	@Column(name="TX_CASE_NO", insertable=false, updatable=false)
	private String txCaseNo;

	@Column(name="TX_AGENCY_CODE", insertable=false, updatable=false)
	private String txAgencyCode;

	@Column(name="TX_CASE_CODE", insertable=false, updatable=false)
	private String txCaseCode;

	@Column(name="TX_SSN_TAXID_IND", insertable=false, updatable=false)
	private String txSsnTaxidInd;

	public F57SuspendEntityPK() {
	}
	public String getTxSsn() {
		return this.txSsn;
	}
	public void setTxSsn(String txSsn) {
		this.txSsn = txSsn;
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
	public String getTxSsnTaxidInd() {
		return this.txSsnTaxidInd;
	}
	public void setTxSsnTaxidInd(String txSsnTaxidInd) {
		this.txSsnTaxidInd = txSsnTaxidInd;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof F57SuspendEntityPK)) {
			return false;
		}
		F57SuspendEntityPK castOther = (F57SuspendEntityPK)other;
		return 
			this.txSsn.equals(castOther.txSsn)
			&& this.txCaseNo.equals(castOther.txCaseNo)
			&& this.txAgencyCode.equals(castOther.txAgencyCode)
			&& this.txCaseCode.equals(castOther.txCaseCode)
			&& this.txSsnTaxidInd.equals(castOther.txSsnTaxidInd);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.txSsn.hashCode();
		hash = hash * prime + this.txCaseNo.hashCode();
		hash = hash * prime + this.txAgencyCode.hashCode();
		hash = hash * prime + this.txCaseCode.hashCode();
		hash = hash * prime + this.txSsnTaxidInd.hashCode();
		
		return hash;
	}
}