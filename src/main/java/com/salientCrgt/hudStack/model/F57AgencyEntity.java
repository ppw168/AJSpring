package com.salientCrgt.hudStack.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the F57_AGENCY database table.
 *
 */
@Entity
@Table(name = "F57_AGENCY")
@NamedQuery(name = "F57AgencyEntity.findAll", query = "SELECT f FROM F57AgencyEntity f ORDER BY f.txName")
public class F57AgencyEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TX_AGENCY_CODE")
    private String txAgencyCode;

    @Column(name = "NU_AVG_BAL")
    private BigDecimal nuAvgBal;

    @Column(name = "NU_AVG_LOAN")
    private BigDecimal nuAvgLoan;

    @Column(name = "NU_AVG_LOSS")
    private BigDecimal nuAvgLoss;

    @Column(name = "NU_HITS")
    private BigDecimal nuHits;

    @Column(name = "NU_POC_DIGITS")
    private BigDecimal nuPocDigits;

    @Column(name = "NU_SSNS_LOADED")
    private BigDecimal nuSsnsLoaded;

    @Column(name = "NU_SUPPRESS_CTR")
    private BigDecimal nuSuppressCtr;

    @Column(name = "NU_TX_BATCH")
    private BigDecimal nuTxBatch;

    @Column(name = "NU_TX_ELECT")
    private BigDecimal nuTxElect;

    @Column(name = "NU_TX_SCREEN")
    private BigDecimal nuTxScreen;

    @Column(name = "NU_TX_TIP")
    private BigDecimal nuTxTip;

    @Column(name = "NU_USERS_LOADED")
    private BigDecimal nuUsersLoaded;

    @Column(name = "TX_AUDIT_TAPE")
    private String txAuditTape;

    @Column(name = "TX_CONTACT")
    private String txContact;

    @Column(name = "TX_NAME")
    private String txName;

    @Column(name = "TX_PHONE")
    private String txPhone;

    // bi-directional many-to-one association to F57BorrowerEntity
    @OneToMany(mappedBy = "f57Agency")
    @JsonIgnore
    private List<F57BorrowerEntity> f57Borrowers;

    // bi-directional many-to-one association to F57SuspendEntity
    @OneToMany(mappedBy = "f57Agency")
    @JsonIgnore
    private List<F57SuspendEntity> f57Suspends;

    public F57AgencyEntity() {}

    public F57BorrowerEntity addF57Borrower(
            final F57BorrowerEntity f57Borrower) {
        this.getF57Borrowers().add(f57Borrower);
        f57Borrower.setF57Agency(this);

        return f57Borrower;
    }

    public F57SuspendEntity addF57Suspend(final F57SuspendEntity f57Suspend) {
        this.getF57Suspends().add(f57Suspend);
        f57Suspend.setF57Agency(this);

        return f57Suspend;
    }

    public List<F57BorrowerEntity> getF57Borrowers() {
        return this.f57Borrowers;
    }

    public List<F57SuspendEntity> getF57Suspends() {
        return this.f57Suspends;
    }

    public BigDecimal getNuAvgBal() {
        return this.nuAvgBal;
    }

    public BigDecimal getNuAvgLoan() {
        return this.nuAvgLoan;
    }

    public BigDecimal getNuAvgLoss() {
        return this.nuAvgLoss;
    }

    public BigDecimal getNuHits() {
        return this.nuHits;
    }

    public BigDecimal getNuPocDigits() {
        return this.nuPocDigits;
    }

    public BigDecimal getNuSsnsLoaded() {
        return this.nuSsnsLoaded;
    }

    public BigDecimal getNuSuppressCtr() {
        return this.nuSuppressCtr;
    }

    public BigDecimal getNuTxBatch() {
        return this.nuTxBatch;
    }

    public BigDecimal getNuTxElect() {
        return this.nuTxElect;
    }

    public BigDecimal getNuTxScreen() {
        return this.nuTxScreen;
    }

    public BigDecimal getNuTxTip() {
        return this.nuTxTip;
    }

    public BigDecimal getNuUsersLoaded() {
        return this.nuUsersLoaded;
    }

    public String getTxAgencyCode() {
        return this.txAgencyCode;
    }

    public String getTxAuditTape() {
        return this.txAuditTape;
    }

    public String getTxContact() {
        return this.txContact;
    }

    public String getTxName() {
        return this.txName;
    }

    public String getTxPhone() {
        return this.txPhone;
    }

    public F57BorrowerEntity removeF57Borrower(
            final F57BorrowerEntity f57Borrower) {
        this.getF57Borrowers().remove(f57Borrower);
        f57Borrower.setF57Agency(null);

        return f57Borrower;
    }

    public F57SuspendEntity removeF57Suspend(
            final F57SuspendEntity f57Suspend) {
        this.getF57Suspends().remove(f57Suspend);
        f57Suspend.setF57Agency(null);

        return f57Suspend;
    }

    public void setF57Borrowers(final List<F57BorrowerEntity> f57Borrowers) {
        this.f57Borrowers = f57Borrowers;
    }

    public void setF57Suspends(final List<F57SuspendEntity> f57Suspends) {
        this.f57Suspends = f57Suspends;
    }

    public void setNuAvgBal(final BigDecimal nuAvgBal) {
        this.nuAvgBal = nuAvgBal;
    }

    public void setNuAvgLoan(final BigDecimal nuAvgLoan) {
        this.nuAvgLoan = nuAvgLoan;
    }

    public void setNuAvgLoss(final BigDecimal nuAvgLoss) {
        this.nuAvgLoss = nuAvgLoss;
    }

    public void setNuHits(final BigDecimal nuHits) {
        this.nuHits = nuHits;
    }

    public void setNuPocDigits(final BigDecimal nuPocDigits) {
        this.nuPocDigits = nuPocDigits;
    }

    public void setNuSsnsLoaded(final BigDecimal nuSsnsLoaded) {
        this.nuSsnsLoaded = nuSsnsLoaded;
    }

    public void setNuSuppressCtr(final BigDecimal nuSuppressCtr) {
        this.nuSuppressCtr = nuSuppressCtr;
    }

    public void setNuTxBatch(final BigDecimal nuTxBatch) {
        this.nuTxBatch = nuTxBatch;
    }

    public void setNuTxElect(final BigDecimal nuTxElect) {
        this.nuTxElect = nuTxElect;
    }

    public void setNuTxScreen(final BigDecimal nuTxScreen) {
        this.nuTxScreen = nuTxScreen;
    }

    public void setNuTxTip(final BigDecimal nuTxTip) {
        this.nuTxTip = nuTxTip;
    }

    public void setNuUsersLoaded(final BigDecimal nuUsersLoaded) {
        this.nuUsersLoaded = nuUsersLoaded;
    }

    public void setTxAgencyCode(final String txAgencyCode) {
        this.txAgencyCode = txAgencyCode;
    }

    public void setTxAuditTape(final String txAuditTape) {
        this.txAuditTape = txAuditTape;
    }

    public void setTxContact(final String txContact) {
        this.txContact = txContact;
    }

    public void setTxName(final String txName) {
        this.txName = txName;
    }

    public void setTxPhone(final String txPhone) {
        this.txPhone = txPhone;
    }

}
