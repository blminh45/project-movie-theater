package com.example.movieapp;

import java.io.Serializable;

public class Rap implements Serializable {
    private  int IDRap;
    private  int IDChiNhanh;
    private  String TenRap;
    private int TrangThai;

    public Rap(int IDRap, int IDChiNhanh, String tenRap, int trangThai) {
        this.IDRap = IDRap;
        this.IDChiNhanh = IDChiNhanh;
        TenRap = tenRap;
        TrangThai = trangThai;
    }
    public Rap() {
        IDRap = 0;
        IDChiNhanh = 0;
        TenRap = "";
        TrangThai = 0;
    }

    public int getIDRap() {
        return IDRap;
    }

    public void setIDRap(int IDRap) {
        this.IDRap = IDRap;
    }

    public int getIDChiNhanh() {
        return IDChiNhanh;
    }

    public void setIDChiNhanh(int IDChiNhanh) {
        this.IDChiNhanh = IDChiNhanh;
    }

    public String getTenRap() {
        return TenRap;
    }

    public void setTenRap(String tenRap) {
        TenRap = tenRap;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int trangThai) {
        TrangThai = trangThai;
    }
}

