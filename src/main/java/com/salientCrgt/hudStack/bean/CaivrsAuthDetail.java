package com.salientCrgt.hudStack.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public class CaivrsAuthDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ssn;	
	private String authNo;
	private String indicator;
	private String borrowerLabel;
	
	private ArrayList<CaivrsAuthEntry> caivrsAuthEntryList = new ArrayList<CaivrsAuthEntry>();

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
	public ArrayList<CaivrsAuthEntry> getCaivrsAuthEntryList() {
		return caivrsAuthEntryList;
	}

	public void setCaivrsAuthEntryList(ArrayList<CaivrsAuthEntry> al) {
		this.caivrsAuthEntryList = al;
	}
		
	
}
