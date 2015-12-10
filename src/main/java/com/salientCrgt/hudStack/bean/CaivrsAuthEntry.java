package com.salientCrgt.hudStack.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class CaivrsAuthEntry implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String agency;
	
	private String caseNo;
	
	private String caseType;
	
	private String phone;

	@XmlElement
	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	@XmlElement
	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	@XmlElement
	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	@XmlElement
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
