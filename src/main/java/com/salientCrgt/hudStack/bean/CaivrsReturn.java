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
    public ArrayList<CaivrsAuthDetail> getCaivrsAuthDetailList() {
        return this.caivrsAuthDetailList;
    }

    @XmlElement
    public String getStatus() {
        return this.status;
    }

    public void setCaivrsAuthDetailList(final ArrayList<CaivrsAuthDetail> al) {
        this.caivrsAuthDetailList = al;
    }

    public void setStatus(final String status) {
        this.status = status;
    }
}
