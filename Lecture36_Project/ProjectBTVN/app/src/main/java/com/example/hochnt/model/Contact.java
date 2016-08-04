package com.example.hochnt.model;

import java.io.Serializable;

/**
 * Created by hochnt on 2016/08/03.
 */
public class Contact implements Serializable {
    private String name;
    private String sdt;
    private boolean isCanSend;

    public boolean isCanSend() {
        return isCanSend;
    }

    public void setCanSend(boolean canSend) {
        isCanSend = canSend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Contact(String name, String sdt, boolean isCanSend) {
        this.name = name;
        this.sdt = sdt;
        this.isCanSend = isCanSend;
    }

    public Contact() {
    }
}
