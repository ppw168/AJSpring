package com.salientCrgt.hudStack.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the F57_REF_CASE_CODE database table.
 * 
 */
@Entity
@Table(name="F57_REF_CASE_CODE")
@NamedQuery(name="F57RefCaseCodeEntity.findAll", query="SELECT f FROM F57RefCaseCodeEntity f")
public class F57RefCaseCodeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TX_CASE_CODE")
	private String txCaseCode;

	@Column(name="TX_DESCRIPTION")
	private String txDescription;

	//bi-directional many-to-one association to F57BorrowerEntity
	@OneToMany(mappedBy="f57RefCaseCodeEntity")
	private List<F57BorrowerEntity> f57Borrowers;
	
	public F57RefCaseCodeEntity() {
	}

	public String getTxCaseCode() {
		return this.txCaseCode;
	}

	public void setTxCaseCode(String txCaseCode) {
		this.txCaseCode = txCaseCode;
	}

	public String getTxDescription() {
		return this.txDescription;
	}

	public void setTxDescription(String txDescription) {
		this.txDescription = txDescription;
	}

}