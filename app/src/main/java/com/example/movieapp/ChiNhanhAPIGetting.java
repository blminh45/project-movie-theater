package com.example.movieapp;

import android.content.Context;
import android.os.AsyncTask;

public class ChiNhanhAPIGetting extends AsyncTask<ChiNhanh, String, String> {
    private Context m_con;
    public   ChiNhanhAPIGetting(Context con)
    {
        m_con =con;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
//        Toast.makeText(m_con, "Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected String doInBackground(ChiNhanh... chiNhanhs) {
        return APIChiNhanh.getChiNhanh();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
//        Toast.makeText(m_con , "Finish ", Toast.LENGTH_SHORT).show();
    }
}
