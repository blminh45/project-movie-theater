package com.example.movieapp;

import java.io.Serializable;

public class ChiNhanh implements Serializable {
    private String TenChiNhanh;
    private String DiaChi;
    private String TrangThai;
    private  String Rap;

    public ChiNhanh(String tenChiNhanh, String diaChi, String trangThai ,  String rap) {
        TenChiNhanh = tenChiNhanh;
        DiaChi = diaChi;
        TrangThai = trangThai;
        Rap = rap;
    }
    public ChiNhanh() {
        TenChiNhanh = "";
        DiaChi = "";
        TrangThai = "";
        Rap = "";
    }

    public String getRap() {
        return Rap;
    }

    public void setRap(String rap) {
        Rap = rap;
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
