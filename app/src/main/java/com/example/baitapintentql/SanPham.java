package com.example.baitapintentql;

import java.io.Serializable;

public class SanPham implements Serializable {
    private String tenSp;
    private String maSp;
    private int donGia;

    public SanPham(String tenSp, String maSp, int donGia) {
        this.tenSp = tenSp;
        this.maSp = maSp;
        this.donGia = donGia;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return this.tenSp+" _ "+this.maSp+" _ "+this.donGia;

    }
}
