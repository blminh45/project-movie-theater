package com.example.movieapp;

import android.icu.text.Edits;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.Iterator;

public class Ve implements Serializable {
    private int IDPhim;
    private int IDLichChieu;
    private int IDKhachHang;
    private int IDGhe;
    private double GiaVe;
    private String NgayMua;
    private int TrangThai;

    public Ve(int IDLichChieu, int IDKhachHang, int IDGhe, double giaVe) {
        this.IDLichChieu = IDLichChieu;
        this.IDKhachHang = IDKhachHang;
        this.IDGhe = IDGhe;
        GiaVe = giaVe;
    }

    public Ve(int IDLichChieu, int IDKhachHang, int IDGhe) {
        this.IDLichChieu = IDLichChieu;
        this.IDKhachHang = IDKhachHang;
        this.IDGhe = IDGhe;
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

    public  String packData()
    {
        JSONObject jo=new JSONObject();
        StringBuffer packedData=new StringBuffer();
        try {
            jo.put("lich_chieu", getIDLichChieu());
            jo.put("khach_hang", getIDKhachHang());
            jo.put("ghe", getIDGhe());
            Boolean firstValue=true;
            Iterator it=jo.keys();
            do {
                String key=it.next().toString();
                String value=jo.get(key).toString();
                if(firstValue)
                {
                    firstValue=false;
                }else
                {
                    packedData.append("&");
                }
                try {
                    packedData.append(URLEncoder.encode(key,"UTF-8"));
                    packedData.append("=");
                    packedData.append(URLEncoder.encode(value,"UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }while (it.hasNext());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  packedData.toString();
    }
}
