package com.example.movieapp;

import java.io.Serializable;

public class LichChieu implements Serializable {
    private int IDLichChieu;
    private int IDPhim;
    private  int IDRap;
    private int IDChiNhanh;
    private int IDSuatChieu;
    private String TenRap;
    private String TenChiNhanh;
    private String NgayChieu;
    private String GioChieu;
    private String GiaSuatChieu;

    public LichChieu(int IDLichChieu, int IDPhim, int IDRap, int IDChiNhanh, int IDSuatChieu, String tenRap, String tenChiNhanh, String ngayChieu, String gioChieu, String giaSuatChieu) {
        this.IDLichChieu = IDLichChieu;
        this.IDPhim = IDPhim;
        this.IDRap = IDRap;
        this.IDChiNhanh = IDChiNhanh;
        this.IDSuatChieu = IDSuatChieu;
        TenRap = tenRap;
        TenChiNhanh = tenChiNhanh;
        NgayChieu = ngayChieu;
        GioChieu = gioChieu;
        GiaSuatChieu = giaSuatChieu;
    }

    public LichChieu() {
        this.IDLichChieu = 1;
        this.IDPhim = 1;
        this.IDRap = 1;
        this.IDChiNhanh = 1;
        this.IDSuatChieu = 1;
        TenRap = "";
        TenChiNhanh = "";
        NgayChieu = "";
        GioChieu = "";
        GiaSuatChieu = "";
    }

    public int getIDLichChieu() {
        return IDLichChieu;
    }

    public void setIDLichChieu(int IDLichChieu) {
        this.IDLichChieu = IDLichChieu;
    }

    public int getIDPhim() {
        return IDPhim;
    }

    public void setIDPhim(int IDPhim) {
        this.IDPhim = IDPhim;
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

    public int getIDSuatChieu() {
        return IDSuatChieu;
    }

    public void setIDSuatChieu(int IDSuatChieu) {
        this.IDSuatChieu = IDSuatChieu;
    }

    public String getTenRap() {
        return TenRap;
    }

    public void setTenRap(String tenRap) {
        TenRap = tenRap;
    }

    public String getTenChiNhanh() {
        return TenChiNhanh;
    }

    public void setTenChiNhanh(String tenChiNhanh) {
        TenChiNhanh = tenChiNhanh;
    }

    public String getNgayChieu() {
        return NgayChieu;
    }

    public void setNgayChieu(String ngayChieu) {
        NgayChieu = ngayChieu;
    }

    public String getGioChieu() {
        return GioChieu;
    }

    public void setGioChieu(String gioChieu) {
        GioChieu = gioChieu;
    }

    public String getGiaSuatChieu() {
        return GiaSuatChieu;
    }

    public void setGiaSuatChieu(String giaSuatChieu) {
        GiaSuatChieu = giaSuatChieu;
    }
}
