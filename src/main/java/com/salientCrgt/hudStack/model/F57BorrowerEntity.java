package com.salientCrgt.hudStack.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the F57_BORROWER database table.
 * 
 */
@Entity
@Table(name = "F57_BORROWER")
@NamedQueries({ 
	@NamedQuery(name = "F57BorrowerEntity.findAll", query = "SELECT f FROM F57BorrowerEntity f"),
	@NamedQuery(name = "F57BorrowerEntity.findBySsn", query = "SELECT f FROM F57BorrowerEntity f WHERE f.id.txSsn = :ssn"),
	@NamedQuery(name = "F57BorrowerEntity.findBySsnAgency", query = "SELECT f FROM F57BorrowerEntity f WHERE f.id.txSsn = :ssn AND f.id.txAgencyCode = :code")
})

public class F57BorrowerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private F57BorrowerEntityPK id;

	@Column(name = "TX_SUSPEND_CODE")
	private String txSuspendCode;

	// bi-directional many-to-one association to F57AgencyEntity
	@ManyToOne
	@JoinColumn(name = "TX_AGENCY_CODE", insertable = false, updatable = false)
	private F57AgencyEntity f57Agency;

	// bi-directional many-to-one association to F57RefCaseCode
	@ManyToOne
	@JoinColumn(name = "TX_CASE_CODE", insertable = false, updatable = false)
	private F57RefCaseCodeEntity f57RefCaseCodeEntity;

	// bi-directional many-to-one association to F57SuspendEntity
	@OneToMany(mappedBy = "f57Borrower")
	private List<F57SuspendEntity> f57Suspends;

	public F57BorrowerEntity() {
	}

	public F57BorrowerEntityPK getId() {
		return this.id;
	}

	public void setId(F57BorrowerEntityPK id) {
		this.id = id;
	}

	public String getTxSuspendCode() {
		return this.txSuspendCode;
	}

	public void setTxSuspendCode(String txSuspendCode) {
		this.txSuspendCode = txSuspendCode;
	}

	public F57AgencyEntity getF57Agency() {
		return this.f57Agency;
	}

	public void setF57Agency(F57AgencyEntity f57Agency) {
		this.f57Agency = f57Agency;
	}

	public List<F57SuspendEntity> getF57Suspends() {
		return this.f57Suspends;
	}

	public void setF57Suspends(List<F57SuspendEntity> f57Suspends) {
		this.f57Suspends = f57Suspends;
	}

	public F57RefCaseCodeEntity getF57RefCaseCodeEntity() {
		return f57RefCaseCodeEntity;
	}

	public void setF57RefCaseCodeEntity(F57RefCaseCodeEntity f57RefCaseCodeEntity) {
		this.f57RefCaseCodeEntity = f57RefCaseCodeEntity;
	}

	public F57SuspendEntity addF57Suspend(F57SuspendEntity f57Suspend) {
		getF57Suspends().add(f57Suspend);
		f57Suspend.setF57Borrower(this);

		return f57Suspend;
	}

	public F57SuspendEntity removeF57Suspend(F57SuspendEntity f57Suspend) {
		getF57Suspends().remove(f57Suspend);
		f57Suspend.setF57Borrower(null);

		return f57Suspend;
	}

}