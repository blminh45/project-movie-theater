package com.example.movieapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIDatVe {
    static HttpURLConnection urlConnection = null;
    static String uri="http://dashboard-movie-web.herokuapp.com/api/ve/them-ve";
    static  String DatVe(Ve ve){
        BufferedReader reader = null;
        String result = null;
        String url = uri+"?datve";

        try {
            //Tạo kết nối
            URL requestURL = new URL(url);
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.connect();
            OutputStream os=urlConnection.getOutputStream();
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            bw.write(new Ve(ve.getIDLichChieu(), ve.getIDKhachHang(), ve.getIDGhe()).packData());
            bw.flush();
            bw.close();
            os.close();
            // co kết nối thanh f công
            int responseCode=urlConnection.getResponseCode();
            if(responseCode==urlConnection.HTTP_OK)
            {
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuffer stringBuffer=new StringBuffer();
                String line;
                // Đọc mỗi dòng
                while ((line=bufferedReader.readLine())!=null)
                {
                    stringBuffer.append(line);
                }
                bufferedReader.close();
                return stringBuffer.toString();
            }

            //Lấy dữ liệu được trả về ra
//            InputStream inputStream = urlConnection.getInputStream();
//            reader = new BufferedReader(new InputStreamReader(inputStream));
//            StringBuilder builder = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                builder.append(line);
//            }
//            if (builder.length() == 0) {
//                return null;
//            }
//            result = builder.toString();
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
}
