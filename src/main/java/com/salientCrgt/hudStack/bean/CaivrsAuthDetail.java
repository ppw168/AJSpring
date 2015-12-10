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

    // private ArrayList<CaivrsAuthEntry> caivrsAuthEntryList = new
    // ArrayList<CaivrsAuthEntry>();
    private List<F57BorrowerEntity> caivrsBorrowerList = new ArrayList<F57BorrowerEntity>();

    @XmlElement
    public String getAuthNo() {
        return this.authNo;
    }

    @XmlElement
    public String getBorrowerLabel() {
        return this.borrowerLabel;
    }

    @XmlElement
    public List<F57BorrowerEntity> getCaivrsBorrowerList() {
        return this.caivrsBorrowerList;
    }

    @XmlElement
    public String getIndicator() {
        return this.indicator;
    }

    @XmlElement
    public String getSsn() {
        return this.ssn;
    }

    @XmlElement
    public String getStatus() {
        return this.status;
    }

    public void setAuthNo(final String authNo) {
        this.authNo = authNo;
    }

    public void setBorrowerLabel(final String borrowerLabel) {
        this.borrowerLabel = borrowerLabel;
    }

    public void setCaivrsBorrowerList(
            final List<F57BorrowerEntity> caivrsBorrowerList) {
        this.caivrsBorrowerList = caivrsBorrowerList;
    }

    public void setIndicator(final String indicator) {
        this.indicator = indicator;
    }

    // @XmlElement
    // public ArrayList<CaivrsAuthEntry> getCaivrsAuthEntryList() {
    // return caivrsAuthEntryList;
    // }
    //
    // public void setCaivrsAuthEntryList(ArrayList<CaivrsAuthEntry> al) {
    // this.caivrsAuthEntryList = al;
    // }

    public void setSsn(final String ssn) {
        this.ssn = ssn;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
