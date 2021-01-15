package com.example.movieapp;

import android.app.ActivityOptions;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.concurrent.ExecutionException;

public class SignUpActivity extends AppCompatActivity {
    TextInputLayout regName,regAddress,regEmail,regPhone,regPassword,regBirthLO;
    TextInputEditText regBirth;
    Button regBtn,regToLoginBtn,chooseBtn;
    ImageView mImageView,image;
    TextView logoText,sloganText;
    DatePickerDialog.OnDateSetListener setListener;
    private static final int  IMAGE_PICK_CODE = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        regName= findViewById(R.id.name);
        regAddress= findViewById(R.id.address);
        regEmail= findViewById(R.id.email);
        regPhone= findViewById(R.id.phone);
        regPassword= findViewById(R.id.password);
        regBirth = findViewById(R.id.birth);
        regBirthLO = findViewById(R.id.birthLayout);
        mImageView = findViewById(R.id.img);
        chooseBtn = findViewById(R.id.choose_image_btn);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        regBirth.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        SignUpActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                 datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = year+"-"+month+"-"+dayOfMonth;
                regBirth.setText(date);
            }
        };
    }
    private Boolean validateName(){
        String val = regName.getEditText().getText().toString();
        if(val.isEmpty())
        {
            regName.setError("Họ tên còn trống");
            return false;
        }
        else
        {
            regName.setError(null);
            regName.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validateAddress(){
        String val = regAddress.getEditText().getText().toString();
        if(val.isEmpty())
        {
            regAddress.setError("Địa chỉ còn trống");
            return false;
        }
        else{
            regAddress.setError(null);
            regAddress.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validateEmail(){
        String val = regEmail.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9]+@[a-z]+\\.+[a-z]+";
        if(val.isEmpty())
        {
            regEmail.setError("Email còn trống");
            return false;
        } else if(!val.matches(emailPattern)){
            regEmail.setError("Địa chỉ Email không hợp lệ");
            return false;
        }
        else
        {
            regEmail.setError(null);
            regEmail.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validateBirth(){
        String val = regBirthLO.getEditText().getText().toString();
        if(val.isEmpty())
        {
            regBirthLO.setError("Ngày sinh còn trống");
            return false;
        }
        else
        {
            regBirthLO.setError(null);
            regBirthLO.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validatePhone(){
        String val = regPhone.getEditText().getText().toString();
        if(val.isEmpty())
        {
            regPhone.setError("Số điện thoại còn trống");
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
        if(val.isEmpty())
        {
            regPassword.setError("Mật khẩu còn trống");
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
        String ten,diachi,sdt,email,matkhau,ngaysinh,anhdaidien;
        ten = regName.getEditText().getText().toString();
        diachi = regAddress.getEditText().getText().toString();
        sdt = regPhone.getEditText().getText().toString();
        email = regEmail.getEditText().getText().toString();
        matkhau = regPassword.getEditText().getText().toString();
        ngaysinh=regBirth.getText().toString();
        anhdaidien="img.png";
        if(!validateName() | !validateAddress() | !validateEmail() | !validatePassword() | !validatePhone() | !validateBirth()){
            Toast.makeText(SignUpActivity.this,"Đăng ký thất bại",Toast.LENGTH_LONG).show();
        }
        else{
            KhachHang inserKH =new KhachHang(ten,diachi,sdt,ngaysinh,email,anhdaidien,matkhau);
            try {
                new KhachHangAPIGetting(SignUpActivity.this).execute(inserKH).get();
                Toast.makeText(SignUpActivity.this,"Đăng ký thành công",Toast.LENGTH_SHORT).show();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
        pairs[3] = new Pair<View,String>(regAddress,"address_tran");
        pairs[4] = new Pair<View,String>(regPassword,"password_tran");
        pairs[6] = new Pair<View,String>(regToLoginBtn,"button_tran");
        pairs[5] = new Pair<View,String>(regBtn,"login_signup_tran");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUpActivity.this,pairs);
        startActivity(intent,options.toBundle());
        finish();
    }
}