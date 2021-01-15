package com.example.movieapp;

import java.io.Serializable;

public class Ghe implements Serializable {
    private String Hang;
    private  int Cot;
    private double GiaGhe;
    private int TrangThai;
    private int IDGhe;

    public Ghe(String hang, int cot, double giaGhe, int trangThai, int idghe) {
        Hang = hang;
        Cot = cot;
        GiaGhe = giaGhe;
        TrangThai = trangThai;
        IDGhe = idghe;
    }

    public Ghe() {
        Hang = "";
        Cot = 1;
        GiaGhe = 0;
        TrangThai = 1;
        IDGhe = 0;
    }

    public int getIDGhe() {
        return IDGhe;
    }

    public void setIDGhe(int IDGhe) {
        this.IDGhe = IDGhe;
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
