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

    public String getBorrowerLabel() {
        return this.borrowerLabel;
    }

    @XmlElement
    public String getIndicator() {
        return this.indicator;
    }

    @XmlElement
    public String getSsn() {
        return this.ssn;
    }

    public String getSsn1() {
        return this.ssn1;
    }

    public String getSsn2() {
        return this.ssn2;
    }

    public String getSsn3() {
        return this.ssn3;
    }

    public void setBorrowerLabel(final String borrowerLabel) {
        this.borrowerLabel = borrowerLabel;
    }

    public void setIndicator(final String indicator) {
        this.indicator = indicator;
    }

    public void setSsn(final String ssn) {
        this.ssn = ssn;
    }

    public void setSsn1(final String ssn1) {
        this.ssn1 = ssn1;
    }

    public void setSsn2(final String ssn2) {
        this.ssn2 = ssn2;
    }

    public void setSsn3(final String ssn3) {
        this.ssn3 = ssn3;
    }

}
