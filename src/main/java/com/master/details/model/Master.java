package com.master.details.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;

public class Master {
    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";
    @Id
    private int masterNo;
    private String masterDate;

    public int getMasterNo() {
        return masterNo;
    }

    public void setMasterNo(int masterNo) {
        this.masterNo = masterNo;
    }

    private String black;
    private String customerName;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    private int seq;


    public String getMasterDate() {
        return masterDate;
    }

    public void setMasterDate(String masterDate) {
        this.masterDate = masterDate;
    }

    public String getBlack() {
        return black;
    }

    public void setBlack(String black) {
        this.black = black;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
