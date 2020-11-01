package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    Button SignUp,btn_login;
    ImageView image;
    TextView logoText,sloganText;
    TextInputLayout username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
    }

    public void callSignUp(View view) {
        Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
        startActivity(intent);
        image = findViewById(R.id.logo_image);
        logoText = findViewById(R.id.slogan);
        sloganText = findViewById(R.id.ex);
        btn_login = findViewById(R.id.login);
        SignUp = findViewById(R.id.signup);
        Pair[] pairs = new Pair[7];
        pairs[0] = new Pair<View,String>(image,"logo_image");
        pairs[1] = new Pair<View,String>(logoText,"logo_text");
        pairs[2] = new Pair<View,String>(sloganText,"ex_tran");
        pairs[3] = new Pair<View,String>(username,"username_tran");
        pairs[4] = new Pair<View,String>(password,"password_tran");
        pairs[6] = new Pair<View,String>(btn_login,"button_tran");
        pairs[5] = new Pair<View,String>(SignUp,"login_signup_tran");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this,pairs);
        startActivity(intent,options.toBundle());
        finish();
    }
    private Boolean validateUsername(){
        String val = username.getEditText().getText().toString();
        String noWhiteSpace ="\\A\\w{4,20}\\z";
        if(val.isEmpty())
        {
            username.setError("Tài khoản không hợp lệ !!!");
            return false;
        }else if(!val.matches(noWhiteSpace)){
            username.setError("Tài khoản không được chứa khoảng trắng");
            return false;
        }
        else{
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validatePassword(){
        String val = password.getEditText().getText().toString();
        if(val.isEmpty())
        {
            password.setError("Mật khẩu còn trống !!!");
            return false;
        }
        else
        {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }
    public void validateUser(View view) {
        if(!validateUsername()| !validatePassword()){
            return;
        }
    }
}