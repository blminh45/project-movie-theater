package com.example.movieapp;

import android.content.Context;
import android.os.AsyncTask;

public class GheAPIGetting extends AsyncTask<Ghe, String, String> {
    private Context m_con;
    public  GheAPIGetting(Context con)
    {
        m_con =con;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
//        Toast.makeText(m_con, "Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected String doInBackground(Ghe... ghe) {
        return APIGhe.getGhe();
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
