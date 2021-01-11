package com.example.movieapp;

public class Phim {
    private String Poster;
    private String Name;
    private String TheLoai;
    private float Diem;
    private int Tuoi;
    private String Trailer;

    public Phim(String poster, String name, String theLoai, float diem, int tuoi , String trailer) {
        Poster = poster;
        Name = name;
        TheLoai = theLoai;
        Diem = diem;
        Tuoi = tuoi;
        Trailer =trailer;
    }

    public Phim() {
        Poster = "";
        Name = "";
        TheLoai = "";
        Diem = 0;
        Tuoi = 0;
        Trailer="";
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
}
