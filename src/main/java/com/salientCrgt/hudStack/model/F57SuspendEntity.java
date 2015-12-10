package com.salientCrgt.hudStack.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the F57_SUSPEND database table.
 * 
 */
@Entity
@Table(name="F57_SUSPEND")
@NamedQuery(name="F57SuspendEntity.findAll", query="SELECT f FROM F57SuspendEntity f")
public class F57SuspendEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private F57SuspendEntityPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_CREATED")
	private Date dtCreated;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_EXPIRE")
	private Date dtExpire;

	@Column(name="NU_REASON_CODE")
	private BigDecimal nuReasonCode;

	@Column(name="NU_REPAY_AMOUNT")
	private BigDecimal nuRepayAmount;

	@Column(name="NU_REPAY_CODE")
	private BigDecimal nuRepayCode;

	@Column(name="TX_CALLER_PHONE")
	private String txCallerPhone;

	@Column(name="TX_USER_ID")
	private String txUserId;

	@Column(name="TX_WEB_ID")
	private String txWebId;

	//bi-directional many-to-one association to F57AgencyEntity
	@ManyToOne
	@JoinColumn(name="TX_AGENCY_CODE", insertable = false, updatable = false)
	private F57AgencyEntity f57Agency;

	//bi-directional many-to-one association to F57BorrowerEntity
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="TX_AGENCY_CODE", referencedColumnName="TX_AGENCY_CODE", insertable = false, updatable = false),
		@JoinColumn(name="TX_CASE_CODE", referencedColumnName="TX_CASE_CODE", insertable = false, updatable = false),
		@JoinColumn(name="TX_CASE_NO", referencedColumnName="TX_CASE_NO", insertable = false, updatable = false),
		@JoinColumn(name="TX_SSN", referencedColumnName="TX_SSN", insertable = false, updatable = false),
		@JoinColumn(name="TX_SSN_TAXID_IND", referencedColumnName="TX_SSN_TAXID_IND", insertable = false, updatable = false)
		})
	private F57BorrowerEntity f57Borrower;

	public F57SuspendEntity() {
	}

	public F57SuspendEntityPK getId() {
		return this.id;
	}

	public void setId(F57SuspendEntityPK id) {
		this.id = id;
	}

	public Date getDtCreated() {
		return this.dtCreated;
	}

	public void setDtCreated(Date dtCreated) {
		this.dtCreated = dtCreated;
	}

	public Date getDtExpire() {
		return this.dtExpire;
	}

	public void setDtExpire(Date dtExpire) {
		this.dtExpire = dtExpire;
	}

	public BigDecimal getNuReasonCode() {
		return this.nuReasonCode;
	}

	public void setNuReasonCode(BigDecimal nuReasonCode) {
		this.nuReasonCode = nuReasonCode;
	}

	public BigDecimal getNuRepayAmount() {
		return this.nuRepayAmount;
	}

	public void setNuRepayAmount(BigDecimal nuRepayAmount) {
		this.nuRepayAmount = nuRepayAmount;
	}

	public BigDecimal getNuRepayCode() {
		return this.nuRepayCode;
	}

	public void setNuRepayCode(BigDecimal nuRepayCode) {
		this.nuRepayCode = nuRepayCode;
	}

	public String getTxCallerPhone() {
		return this.txCallerPhone;
	}

	public void setTxCallerPhone(String txCallerPhone) {
		this.txCallerPhone = txCallerPhone;
	}

	public String getTxUserId() {
		return this.txUserId;
	}

	public void setTxUserId(String txUserId) {
		this.txUserId = txUserId;
	}

	public String getTxWebId() {
		return this.txWebId;
	}

	public void setTxWebId(String txWebId) {
		this.txWebId = txWebId;
	}

	public F57AgencyEntity getF57Agency() {
		return this.f57Agency;
	}

	public void setF57Agency(F57AgencyEntity f57Agency) {
		this.f57Agency = f57Agency;
	}

	public F57BorrowerEntity getF57Borrower() {
		return this.f57Borrower;
	}

	public void setF57Borrower(F57BorrowerEntity f57Borrower) {
		this.f57Borrower = f57Borrower;
	}

}