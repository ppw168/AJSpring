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
    public String getAgencyCode() {
        return this.agencyCode;
    }

    @XmlElement
    public ArrayList<CaivrsBorrower> getCaivrsBorrowerList() {
        return this.caivrsBorrowerList;
    }

    @XmlElement
    public String getLenderID() {
        return this.lenderID;
    }

    public void setAgencyCode(final String agencyCode) {
        this.agencyCode = agencyCode;
    }

    public void setCaivrsBorrowerList(final ArrayList<CaivrsBorrower> bl) {
        this.caivrsBorrowerList = bl;
    }

    public void setLenderID(final String lenderID) {
        this.lenderID = lenderID;
    }

}
