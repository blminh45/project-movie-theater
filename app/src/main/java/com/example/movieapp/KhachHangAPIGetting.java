package com.example.movieapp;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import java.io.IOException;

public class KhachHangAPIGetting extends AsyncTask<KhachHang, String, String> {

    private Context m_con;

    public KhachHangAPIGetting(Context con) {
        m_con = con;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(KhachHang... khachHangs) {
        //return APIKhachHang.getKhachHang();
        if (khachHangs[0].getSdt().isEmpty())
            return APIKhachHang.getKhachHang();
        else {
            try {
                return APIKhachHang.addKhachHang(khachHangs[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}