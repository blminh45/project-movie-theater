package com.example.movieapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.net.DatagramPacket;

public class SignUpActivity extends AppCompatActivity {
    TextInputLayout regName,regUsername,regEmail,regPhone,regPassword;
    Button regBtn,regToLoginBtn,chooseBtn;
    ImageView mImageView;
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
        //check runtime permission
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_DENIED){
                //permission not granted,request it.
                String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                //show popup for runtime permission
                requestPermissions(permissions,PERMISSION_CODE);
            }
            else{
                pickImageFromGallery();
                //permission already granted
            }
        }
        else{
            pickImageFromGallery();
            //system os is less then marshmallow
        }
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
            mImageView.setImageURI(data.getData());
        }
    }
}