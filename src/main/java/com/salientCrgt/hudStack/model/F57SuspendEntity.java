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
@Table(name = "F57_SUSPEND")
@NamedQuery(name = "F57SuspendEntity.findAll", query = "SELECT f FROM F57SuspendEntity f")
public class F57SuspendEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private F57SuspendEntityPK id;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_CREATED")
    private Date dtCreated;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_EXPIRE")
    private Date dtExpire;

    @Column(name = "NU_REASON_CODE")
    private BigDecimal nuReasonCode;

    @Column(name = "NU_REPAY_AMOUNT")
    private BigDecimal nuRepayAmount;

    @Column(name = "NU_REPAY_CODE")
    private BigDecimal nuRepayCode;

    @Column(name = "TX_CALLER_PHONE")
    private String txCallerPhone;

    @Column(name = "TX_USER_ID")
    private String txUserId;

    @Column(name = "TX_WEB_ID")
    private String txWebId;

    // bi-directional many-to-one association to F57AgencyEntity
    @ManyToOne
    @JoinColumn(name = "TX_AGENCY_CODE", insertable = false, updatable = false)
    private F57AgencyEntity f57Agency;

    // bi-directional many-to-one association to F57BorrowerEntity
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "TX_AGENCY_CODE", referencedColumnName = "TX_AGENCY_CODE", insertable = false, updatable = false),
            @JoinColumn(name = "TX_CASE_CODE", referencedColumnName = "TX_CASE_CODE", insertable = false, updatable = false),
            @JoinColumn(name = "TX_CASE_NO", referencedColumnName = "TX_CASE_NO", insertable = false, updatable = false),
            @JoinColumn(name = "TX_SSN", referencedColumnName = "TX_SSN", insertable = false, updatable = false),
            @JoinColumn(name = "TX_SSN_TAXID_IND", referencedColumnName = "TX_SSN_TAXID_IND", insertable = false, updatable = false) })
    private F57BorrowerEntity f57Borrower;

    public F57SuspendEntity() {}

    public Date getDtCreated() {
        return this.dtCreated;
    }

    public Date getDtExpire() {
        return this.dtExpire;
    }

    public F57AgencyEntity getF57Agency() {
        return this.f57Agency;
    }

    public F57BorrowerEntity getF57Borrower() {
        return this.f57Borrower;
    }

    public F57SuspendEntityPK getId() {
        return this.id;
    }

    public BigDecimal getNuReasonCode() {
        return this.nuReasonCode;
    }

    public BigDecimal getNuRepayAmount() {
        return this.nuRepayAmount;
    }

    public BigDecimal getNuRepayCode() {
        return this.nuRepayCode;
    }

    public String getTxCallerPhone() {
        return this.txCallerPhone;
    }

    public String getTxUserId() {
        return this.txUserId;
    }

    public String getTxWebId() {
        return this.txWebId;
    }

    public void setDtCreated(final Date dtCreated) {
        this.dtCreated = dtCreated;
    }

    public void setDtExpire(final Date dtExpire) {
        this.dtExpire = dtExpire;
    }

    public void setF57Agency(final F57AgencyEntity f57Agency) {
        this.f57Agency = f57Agency;
    }

    public void setF57Borrower(final F57BorrowerEntity f57Borrower) {
        this.f57Borrower = f57Borrower;
    }

    public void setId(final F57SuspendEntityPK id) {
        this.id = id;
    }

    public void setNuReasonCode(final BigDecimal nuReasonCode) {
        this.nuReasonCode = nuReasonCode;
    }

    public void setNuRepayAmount(final BigDecimal nuRepayAmount) {
        this.nuRepayAmount = nuRepayAmount;
    }

    public void setNuRepayCode(final BigDecimal nuRepayCode) {
        this.nuRepayCode = nuRepayCode;
    }

    public void setTxCallerPhone(final String txCallerPhone) {
        this.txCallerPhone = txCallerPhone;
    }

    public void setTxUserId(final String txUserId) {
        this.txUserId = txUserId;
    }

    public void setTxWebId(final String txWebId) {
        this.txWebId = txWebId;
    }

}
