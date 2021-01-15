package com.example.movieapp;

public class KhachHang {
    private String Ten;
    private String Diachi;
    private String Sdt;
    private String Email;
    private String NgaySinh;
    private String Avatar;
    private String Matkhau;

    public KhachHang() {
        this.Ten = "";
        this.Diachi="";
        this.Sdt="";
        this.Email="";
        this.NgaySinh="";
        this.Avatar="";
        this.Matkhau="";
    }

    public KhachHang(String ten, String diachi, String sdt, String ngaySinh, String email, String avatar, String matkhau) {
        Ten = ten;
        Diachi = diachi;
        Sdt = sdt;
        Email = email;
        NgaySinh = ngaySinh;
        Avatar = avatar;
        Matkhau = matkhau;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String diachi) {
        Diachi = diachi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public String getMatkhau() {
        return Matkhau;
    }

    public void setMatkhau(String matkhau) {
        Matkhau = matkhau;
    }
}
