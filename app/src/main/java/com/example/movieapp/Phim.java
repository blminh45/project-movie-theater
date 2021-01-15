package com.example.movieapp;

import java.io.Serializable;

public class Phim implements Serializable {
    private String Poster;
    private String Name;
    private String TheLoai;
    private float Diem;
    private int Tuoi;
    private String Trailer;
    private String Thoiluong;
    private String Khoichieu;
    private String Tomtat;
    private double Gia;
    private int TrangThai;



    public Phim(String poster, String name, String theLoai, float diem, int tuoi, String trailer, String thoiluong, String khoichieu, String tomtat, double gia, int trangthai) {
        Poster = poster;
        Name = name;
        TheLoai = theLoai;
        Diem = diem;
        Tuoi = tuoi;
        Trailer = trailer;
        Thoiluong = thoiluong;
        Khoichieu = khoichieu;
        Tomtat = tomtat;
        Gia = gia;
        TrangThai= trangthai;
    }

    public Phim() {
        Poster = "";
        Name = "";
        TheLoai = "";
        Diem = 0;
        Tuoi = 0;
        Trailer="";
        Thoiluong = "";
        Khoichieu = "";
        Tomtat = "";
        Gia = 0;
        TrangThai = 1;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int trangThai) {
        TrangThai = trangThai;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double gia) {
        Gia = gia;
    }

    public String getPoster() {
        return Poster;
    }

    public String getName() {
        return Name;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public float getDiem() {
        return Diem;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setTheLoai(String theLoai) {
        TheLoai = theLoai;
    }

    public void setDiem(float diem) {
        Diem = diem;
    }

    public void setTuoi(int tuoi) {
        Tuoi = tuoi;
    }

    public String getTrailer() {
        return Trailer;
    }

    public void setTrailer(String trailer) {
        Trailer = trailer;
    }

    public String getThoiluong() {
        return Thoiluong;
    }

    public void setThoiluong(String thoiluong) {
        Thoiluong = thoiluong;
    }

    public String getKhoichieu() {
        return Khoichieu;
    }

    public void setKhoichieu(String khoichieu) {
        Khoichieu = khoichieu;
    }

    public String getTomtat() {
        return Tomtat;
    }

    public void setTomtat(String tomtat) {
        Tomtat = tomtat;
    }
}
