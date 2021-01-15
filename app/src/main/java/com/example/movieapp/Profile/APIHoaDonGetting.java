package com.example.movieapp.Profile;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.movieapp.HoaDon;

public class APIHoaDonGetting extends AsyncTask<HoaDon, String, String> {

    private Context m_con;

    public APIHoaDonGetting(Context con) {
        m_con = con;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(m_con, "Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected String doInBackground(HoaDon... ves) {
        return APIHoaDon.getHoaDon();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(m_con, "Finished", Toast.LENGTH_SHORT).show();
    }
}
