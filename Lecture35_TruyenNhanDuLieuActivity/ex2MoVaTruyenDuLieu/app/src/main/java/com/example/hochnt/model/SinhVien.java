package com.example.hochnt.model;

import java.io.Serializable;

/**
 * Created by hochnt on 2016/07/28.
 */
public class SinhVien implements Serializable {
    private int ma;
    private String ten;

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public SinhVien(int ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public SinhVien() {
    }

    @Override
    public String toString() {
        return  this.ma + "\n" + this.ten;
    }
}
