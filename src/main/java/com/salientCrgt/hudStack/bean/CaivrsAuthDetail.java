package com.salientCrgt.hudStack.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.salientCrgt.hudStack.model.F57BorrowerEntity;

public class CaivrsAuthDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ssn;	
	private String authNo;
	private String indicator;
	private String borrowerLabel;
	
	private String status;
	
	// private ArrayList<CaivrsAuthEntry> caivrsAuthEntryList = new ArrayList<CaivrsAuthEntry>();
	private List<F57BorrowerEntity> caivrsBorrowerList = new ArrayList<F57BorrowerEntity>();

	@XmlElement
	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@XmlElement
	public String getAuthNo() {
		return authNo;
	}

	public void setAuthNo(String authNo) {
		this.authNo = authNo;
	}
	
	@XmlElement
	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	@XmlElement
	public String getBorrowerLabel() {
		return borrowerLabel;
	}

	public void setBorrowerLabel(String borrowerLabel) {
		this.borrowerLabel = borrowerLabel;
	}
	
	@XmlElement
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	@XmlElement
//	public ArrayList<CaivrsAuthEntry> getCaivrsAuthEntryList() {
//		return caivrsAuthEntryList;
//	}
//
//	public void setCaivrsAuthEntryList(ArrayList<CaivrsAuthEntry> al) {
//		this.caivrsAuthEntryList = al;
//	}

	@XmlElement
	public List<F57BorrowerEntity> getCaivrsBorrowerList() {
		return caivrsBorrowerList;
	}

	public void setCaivrsBorrowerList(List<F57BorrowerEntity> caivrsBorrowerList) {
		this.caivrsBorrowerList = caivrsBorrowerList;
	}
		
	
}
