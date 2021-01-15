package com.example.movieapp;

import android.content.Context;
import android.os.AsyncTask;

public class LichChieuAPIGetting extends AsyncTask<LichChieu, String, String> {
    private Context m_con;
    public  LichChieuAPIGetting(Context con)
    {
        m_con =con;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
//        Toast.makeText(m_con, "Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected String doInBackground(LichChieu... lichChieus) {
        return APILichChieu.getLichChieu();
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
