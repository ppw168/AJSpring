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
        return this.agency;
    }

    @XmlElement
    public String getCaseNo() {
        return this.caseNo;
    }

    @XmlElement
    public String getCaseType() {
        return this.caseType;
    }

    @XmlElement
    public String getPhone() {
        return this.phone;
    }

    public void setAgency(final String agency) {
        this.agency = agency;
    }

    public void setCaseNo(final String caseNo) {
        this.caseNo = caseNo;
    }

    public void setCaseType(final String caseType) {
        this.caseType = caseType;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

}
