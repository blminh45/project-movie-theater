package com.example.movieapp;

import android.content.Context;
import android.os.AsyncTask;

public class DatVeAPIGetting extends AsyncTask<Ve, String, String> {
    private Context m_con;

    public DatVeAPIGetting(Context con) {
        m_con = con;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
//        Toast.makeText(m_con, "Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected String doInBackground(Ve... ve) {
        return APIDatVe.DatVe(ve[0]);
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
