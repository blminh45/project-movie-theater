package com.example.movieapp;

import java.io.Serializable;

public class ChiNhanh implements Serializable {
    private int IDChiNhanh;
    private String TenChiNhanh;
    private String DiaChi;
    private String TrangThai;

    public ChiNhanh(int id ,String tenChiNhanh, String diaChi, String trangThai) {
        IDChiNhanh = id;
        TenChiNhanh = tenChiNhanh;
        DiaChi = diaChi;
        TrangThai = trangThai;

    }
    public ChiNhanh() {
        IDChiNhanh =0;
        TenChiNhanh = "";
        DiaChi = "";
        TrangThai = "";
    }

    public int getIDChiNhanh() {
        return IDChiNhanh;
    }

    public void setIDChiNhanh(int IDChiNhanh) {
        this.IDChiNhanh = IDChiNhanh;
    }

    public String getTenChiNhanh() {
        return TenChiNhanh;
    }

    public void setTenChiNhanh(String tenChiNhanh) {
        TenChiNhanh = tenChiNhanh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }
}
