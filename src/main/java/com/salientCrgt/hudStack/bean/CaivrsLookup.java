package com.salientCrgt.hudStack.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CaivrsLookup implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private ArrayList<CaivrsBorrower> caivrsBorrowerList = new ArrayList<CaivrsBorrower>();
	private String lenderID;
	private String agencyCode;

	@XmlElement
	public ArrayList<CaivrsBorrower> getCaivrsBorrowerList() {
		return caivrsBorrowerList;
	}

	public void setCaivrsBorrowerList(ArrayList<CaivrsBorrower> bl) {
		this.caivrsBorrowerList = bl;
	}

	@XmlElement
	public String getLenderID() {
		return lenderID;
	}

	public void setLenderID(String lenderID) {
		this.lenderID = lenderID;
	}

	@XmlElement
	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}

}
