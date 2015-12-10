package com.salientCrgt.hudStack.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CaivrsReturn implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String status;
	
	private ArrayList<CaivrsAuthDetail> caivrsAuthDetailList = new ArrayList<CaivrsAuthDetail>();

	
	@XmlElement
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@XmlElement
	public ArrayList<CaivrsAuthDetail> getCaivrsAuthDetailList() {
		return caivrsAuthDetailList;
	}

	public void setCaivrsAuthDetailList(ArrayList<CaivrsAuthDetail> al) {
		this.caivrsAuthDetailList = al;
	}
}
