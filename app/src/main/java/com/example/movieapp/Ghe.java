package com.example.movieapp;

import java.io.Serializable;

public class Ghe implements Serializable {
    private String Hang;
    private  int Cot;
    private double GiaGhe;
    private int TrangThai;

    public Ghe(String hang, int cot, double giaGhe, int trangThai) {
        Hang = hang;
        Cot = cot;
        GiaGhe = giaGhe;
        TrangThai = trangThai;
    }

    public Ghe() {
        Hang = "";
        Cot = 1;
        GiaGhe = 0;
        TrangThai = 1;
    }

    public String getHang() {
        return Hang;
    }

    public void setHang(String hang) {
        Hang = hang;
    }

    public int getCot() {
        return Cot;
    }

    public void setCot(int cot) {
        Cot = cot;
    }

    public double getGiaGhe() {
        return GiaGhe;
    }

    public void setGiaGhe(double giaGhe) {
        GiaGhe = giaGhe;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int trangThai) {
        TrangThai = trangThai;
    }
}
