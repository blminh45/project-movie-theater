package com.example.movieapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputLayout;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.DatagramPacket;

public class SignUpActivity extends AppCompatActivity {
    TextInputLayout regName,regUsername,regEmail,regPhone,regPassword;
    Button regBtn,regToLoginBtn,chooseBtn;
    ImageView mImageView;
    ImageView image;
    TextView logoText,sloganText;
    private static final int  IMAGE_PICK_CODE = 1000;
    private static final int  PERMISSION_CODE = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        regName= findViewById(R.id.name);
        regUsername= findViewById(R.id.username);
        regEmail= findViewById(R.id.email);
        regPhone= findViewById(R.id.phone);
        regPassword= findViewById(R.id.password);

        mImageView = findViewById(R.id.img);
        chooseBtn = findViewById(R.id.choose_image_btn);
    }
    private Boolean validateName(){
        String val = regName.getEditText().getText().toString();
        if(val.isEmpty())
        {
            regName.setError("Họ tên còn trống !!!");
            return false;
        }
        else
        {
            regName.setError(null);
            regName.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validateUsername(){
        String val = regUsername.getEditText().getText().toString();
        String noWhiteSpace ="\\A\\w{4,20}\\z";
        if(val.isEmpty())
        {
            regUsername.setError("Tài khoản không hợp lệ !!!");
            return false;
        }
        else if(val.length()>=15){
            regUsername.setError("Tài khoản quá dài!!!");
            return false;
        }
        else if(!val.matches(noWhiteSpace)){
            regUsername.setError("Tài khoản không được chứa khoảng trắng");
            return false;
        }
        else{
            regUsername.setError(null);
            regUsername.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validateEmail(){
        String val = regEmail.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9]+@[a-z]+\\.+[a-z]+";
        if(val.isEmpty())
        {
            regEmail.setError("Email còn trống !!!");
            return false;
        } else if(!val.matches(emailPattern)){
            regEmail.setError("Địa chỉ Email không hợp lệ !!!");
            return false;
        }
        else
        {
            regEmail.setError(null);
            regEmail.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validatePhone(){
        String val = regPhone.getEditText().getText().toString();
        if(val.isEmpty())
        {
            regPhone.setError("Họ tên còn trống !!!");
            return false;
        }
        else
        {
            regPhone.setError(null);
            regPhone.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validatePassword(){
        String val = regPassword.getEditText().getText().toString();
        String passwordVal = "^" +
                //"(?=.*[0-9])"
                //"(?=.*[a-z])"
                //"(?=.*[A-Z])"
                "(?=.*[a-zA-Z])" +
                "(?=.*[@#$%^&+=])"+
                "(?=\\S+$)"+
                ".{4,}"+
                "$";
        if(val.isEmpty())
        {
            regPassword.setError("Mật khẩu còn trống !!!");
            return false;
        }else if(!val.matches(passwordVal)){
            regPassword.setError("Mật khẩu không hợp lệ !!!");
            return false;
        }
        else
        {
            regPassword.setError(null);
            regPassword.setErrorEnabled(false);
            return true;
        }
    }
    public void registerUser(View view) {
        if(!validateName() | !validateUsername() | !validateEmail() | validatePhone() | !validatePassword()){
            return;
        }

    }

    public void chooseImage(View view) {
            pickImageFromGallery();
    }

    private void pickImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
            startActivityForResult(intent,IMAGE_PICK_CODE);
    }
    //handle result of picked image
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            //mImageView.setImageURI(data.getData());
            try {
                InputStream inputStream = getContentResolver().openInputStream(data.getData());
                Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                mImageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void callLogin(View view) {
        Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
        startActivity(intent);
        image = findViewById(R.id.logo_image);
        logoText = findViewById(R.id.slogan);
        sloganText = findViewById(R.id.ex);
        regToLoginBtn = findViewById(R.id.login);
        regBtn = findViewById(R.id.signup);
        Pair[] pairs = new Pair[7];
        pairs[0] = new Pair<View,String>(image,"logo_image");
        pairs[1] = new Pair<View,String>(logoText,"logo_text");
        pairs[2] = new Pair<View,String>(sloganText,"ex_tran");
        pairs[3] = new Pair<View,String>(regUsername,"username_tran");
        pairs[4] = new Pair<View,String>(regPassword,"password_tran");
        pairs[6] = new Pair<View,String>(regToLoginBtn,"button_tran");
        pairs[5] = new Pair<View,String>(regBtn,"login_signup_tran");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUpActivity.this,pairs);
        startActivity(intent,options.toBundle());
        finish();
    }
}