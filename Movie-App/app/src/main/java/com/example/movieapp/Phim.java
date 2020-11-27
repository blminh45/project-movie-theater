package com.example.movieapp;

public class Phim {
    private int Poster;
    private String Name;
    private String TheLoai;
    private float Diem;
    private int Tuoi;

    public Phim(int poster, String name, String theLoai, float diem, int tuoi) {
        Poster = poster;
        Name = name;
        TheLoai = theLoai;
        Diem = diem;
        Tuoi = tuoi;
    }

    public int getPoster() {
        return Poster;
    }

    public void setPoster(int poster) {
        Poster = poster;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(String theLoai) {
        TheLoai = theLoai;
    }

    public float getDiem() {
        return Diem;
    }

    public void setDiem(float diem) {
        Diem = diem;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setTuoi(int tuoi) {
        Tuoi = tuoi;
    }
}
