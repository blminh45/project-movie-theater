package com.example.movieapp;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;

public class APIGetting extends AsyncTask<Phim, String, String> {
    private Context m_con;
    public  APIGetting(Context con)
    {
        m_con =con;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
//        Toast.makeText(m_con, "Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected String doInBackground(Phim... phim) {
            return APIPhim.getPhim();
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

