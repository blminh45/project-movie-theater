package com.example.movieapp;

import java.io.Serializable;
import java.sql.Date;

public class Ve implements Serializable {
    private int IDPhim;
    private int IDLichChieu;
    private int IDKhachHang;
    private int IDGhe;
    private double GiaVe;
    private String NgayMua;
    private int TrangThai;

    public Ve(int IDPhim, int IDLichChieu, int IDKhachHang, int IDGhe, double giaVe, String ngayMua, int trangThai) {
        this.IDPhim = IDPhim;
        this.IDLichChieu = IDLichChieu;
        this.IDKhachHang = IDKhachHang;
        this.IDGhe = IDGhe;
        GiaVe = giaVe;
        NgayMua = ngayMua;
        TrangThai = trangThai;
    }

    public Ve() {
        this.IDPhim = 1;
        this.IDLichChieu = 1;
        this.IDKhachHang = 1;
        this.IDGhe = 1;
        GiaVe = 0;
        NgayMua = "";
        TrangThai = 1;
    }

    public int getIDPhim() {
        return IDPhim;
    }

    public void setIDPhim(int IDPhim) {
        this.IDPhim = IDPhim;
    }

    public int getIDLichChieu() {
        return IDLichChieu;
    }

    public void setIDLichChieu(int IDLichChieu) {
        this.IDLichChieu = IDLichChieu;
    }

    public int getIDKhachHang() {
        return IDKhachHang;
    }

    public void setIDKhachHang(int IDKhachHang) {
        this.IDKhachHang = IDKhachHang;
    }

    public int getIDGhe() {
        return IDGhe;
    }

    public void setIDGhe(int IDGhe) {
        this.IDGhe = IDGhe;
    }

    public double getGiaVe() {
        return GiaVe;
    }

    public void setGiaVe(double giaVe) {
        GiaVe = giaVe;
    }

    public String getNgayMua() {
        return NgayMua;
    }

    public void setNgayMua(String ngayMua) {
        NgayMua = ngayMua;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int trangThai) {
        TrangThai = trangThai;
    }
}
