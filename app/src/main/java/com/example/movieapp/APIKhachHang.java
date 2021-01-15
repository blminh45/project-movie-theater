package com.example.movieapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;

public class APIKhachHang {
    static HttpURLConnection urlConnection = null;
    static String uri = "http://dashboard-movie-web.herokuapp.com/api/khach-hang";
    static String uriThemKH = "http://dashboard-movie-web.herokuapp.com/api/them-khach-hang";
    //Lấy danh sách khách hàng
    static String getKhachHang(){
        BufferedReader reader = null;
        String result = null;
        String url = uri+"?get";

        try {
            URL requestURL = new URL(url);
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            if (builder.length() == 0) {
                return null;
            }
            result = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    //Thêm khách hàng
    static String addKhachHang(KhachHang khachHang) throws IOException {
        BufferedReader reader = null;
        String result = null;
        String url = uriThemKH+"?ten="+khachHang.getTen()+"&dia_chi="+khachHang.getDiachi()+
                "&so_dien_thoai="+khachHang.getSdt()+"&ngay_sinh="+khachHang.getNgaySinh()+"&email="+khachHang.getEmail()+
                "&anh_dai_dien="+khachHang.getAvatar()+"&mat_khau="+khachHang.getMatkhau();
        try {
            URL requestURL = new URL(url);
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            if (builder.length() == 0) {
                return null;
            }
            result = builder.toString();
        }
        catch (Exception e){
            return e.toString();
        }finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
