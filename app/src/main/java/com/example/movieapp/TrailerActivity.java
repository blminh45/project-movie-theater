package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TrailerActivity extends AppCompatActivity {

    private WebView trailer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer);
        //trailer = (WebView)findViewById(R.id.trailer);
        //WebSettings webSettings = trailer.getSettings();
        //webSettings.setJavaScriptEnabled(true);
        //trailer.setWebViewClient(new WebViewClient());
        //trailer.loadUrl("https://www.youtube.com/watch?v=Q6iK6DjV_iE");
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data...");
        progressDialog.setCancelable(false);
        WebView web_view = findViewById(R.id.trailer);
        web_view.requestFocus();
        web_view.getSettings().setLightTouchEnabled(true);
        web_view.getSettings().setJavaScriptEnabled(true);
        web_view.getSettings().setGeolocationEnabled(true);
        web_view.setSoundEffectsEnabled(true);
        web_view.getSettings().setMediaPlaybackRequiresUserGesture(false);
        web_view.loadData("<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <style>\n" +
                        "        body {\n" +
                        "            margin: 0 auto;\n" +
                        "            text-align: center;\n" +
                        "        }\n" +
                        "        a{\n" +
                        "            padding: 10px;\n" +
                        "            width: 20%;\n" +
                        "            background-color: red;\n" +
                        "            text-decoration: none;\n" +
                        "            color: white;\n" +
                        "            display: block;\n" +
                        "            margin: 0 auto;\n" +
                        "        }\n" +
                        "        div{\n" +
                        "            background-color: black;\n" +
                        "            text-align: center;\n" +
                        "        }\n" +
                        "    </style>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <iframe width=\"432\" height=\"250\" src=\"https://www.youtube.com/embed/Q6iK6DjV_iE?autoplay=1\" frameborder=\"0\" allow=\"accelerometer; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>\n" +
                        "<div><a href=\"https://www.youtube.com/\">YouTube</a></div>\n" +
                        "</body>\n" +
                        "</html>",
                "text/html", "UTF-8");
        web_view.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress < 100) {
                    progressDialog.show();
                }
                if (progress == 100) {
                    progressDialog.dismiss();
                }
            }
        });
    }
}