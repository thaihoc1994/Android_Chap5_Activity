package com.example.hochnt.model;

import java.io.Serializable;

/**
 * Created by hochnt on 2016/07/28.
 */
public class SanPham implements Serializable {
    private  int ma;
    private String ten;
    private double donGia;

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

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public SanPham(int ma, String ten, double donGia) {
        this.ma = ma;
        this.ten = ten;
        this.donGia = donGia;
    }

    public SanPham() {
    }

    @Override
    public String toString() {
        return this.ma + "-" + this.ten + "-" + this.donGia;
    }
}
