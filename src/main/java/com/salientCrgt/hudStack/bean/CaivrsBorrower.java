package com.salientCrgt.hudStack.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class CaivrsBorrower implements Serializable {

	private static final long serialVersionUID = 1L;

	private String indicator;
	private String ssn;
	private String ssn1;
	private String ssn2;
	private String ssn3;
	private String borrowerLabel;

	@XmlElement
	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}
	
	@XmlElement
	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getSsn1() {
		return ssn1;
	}

	public void setSsn1(String ssn1) {
		this.ssn1 = ssn1;
	}

	public String getSsn2() {
		return ssn2;
	}

	public void setSsn2(String ssn2) {
		this.ssn2 = ssn2;
	}

	public String getSsn3() {
		return ssn3;
	}

	public void setSsn3(String ssn3) {
		this.ssn3 = ssn3;
	}

	public String getBorrowerLabel() {
		return borrowerLabel;
	}

	public void setBorrowerLabel(String borrowerLabel) {
		this.borrowerLabel = borrowerLabel;
	}
	
	

}
