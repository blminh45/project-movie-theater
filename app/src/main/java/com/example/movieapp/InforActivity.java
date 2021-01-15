package com.example.movieapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

public class InforActivity extends AppCompatActivity {
    GoogleSignInClient mGoogleSignInClient;
    private static final int  IMAGE_PICK_CODE = 1000;
    ImageView img;
    TextView fullname,mTextEmail , mTextSDT;
    Button logout;
    LoginButton logoutfb;
    String Name,SDT,DiaChi,Email,NgaySinh,Pass;
    private int count_login;
    private String NameGG,EmailGG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor);
        getFormWidgets();
        Intent intent = getIntent();
        count_login = intent.getIntExtra("count_login",0);
        if(count_login>0) {
            logout.setVisibility(View.INVISIBLE);
            logoutfb.setVisibility(View.VISIBLE);
            fullname.setText(intent.getStringExtra("namefb"));
            Picasso.get().load("https://graph.facebook.com/" + intent.getStringExtra("idfb") + "/picture?type=large").into(img);
        }
        else if(count_login<0){
            logout.setVisibility(View.VISIBLE);
            logoutfb.setVisibility(View.INVISIBLE);
        }
        //logout google
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    // ...
                    case R.id.logout:
                        signOut();
                        break;
                    // ...
                }
            }
        });

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            NameGG = acct.getDisplayName();
            EmailGG = acct.getEmail();
            Uri personPhoto = acct.getPhotoUrl();
            fullname.setText(NameGG);
            Glide.with(this).load(String.valueOf(personPhoto)).into(img);
        }
    }

    AccessTokenTracker accessTokenTracker = new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
            if(currentAccessToken == null){
                LoginManager.getInstance().logOut();
                img.setImageResource(0);
                count_login=0;
                fullname.setText("");
                Intent logoutIntent = new Intent();
                setResult(RESULT_OK, logoutIntent);
                Toast.makeText(InforActivity.this,"Đăng xuất thành công",Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    };

    public void getFormWidgets()
    {
        Intent intent = getIntent();
        Name =intent.getStringExtra("Ten");
        DiaChi =intent.getStringExtra("Diachi");
        SDT = intent.getStringExtra("SDT");
        NgaySinh = intent.getStringExtra("Ngaysinh");
        Email = intent.getStringExtra("Email");
        Pass = intent.getStringExtra("Matkhau");

        img = findViewById(R.id.img);
        fullname=findViewById(R.id.fullname);
        mTextEmail = findViewById(R.id.email);
        mTextSDT = findViewById(R.id.phone);
        logout = findViewById(R.id.logout);
        logoutfb = findViewById(R.id.login_fb);


        fullname.setText(Name);
        mTextEmail.setText(Email);
        mTextSDT.setText(SDT);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        accessTokenTracker.stopTracking();
    }

    public void ClickProfile(View view) {
        Intent intent = new Intent(this,ProfileActivity.class);
        if(Name != null) {
            intent.putExtra("Ten", Name);
            intent.putExtra("Diachi", DiaChi);
            intent.putExtra("SDT", SDT);
            intent.putExtra("Ngaysinh", NgaySinh);
            intent.putExtra("Email", Email);
            intent.putExtra("Pass", Pass);
            intent.putExtra("key",1);
        }
        else intent.putExtra("key",0);
        startActivity(intent);
    }

    public void OnMenu(View view) {
        Intent intent=new Intent(this,ActivityMenu.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }


    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<   Void> task) {
                        img.setImageResource(0);
                        fullname.setText("");
                        count_login=0;
                        Toast.makeText(InforActivity.this,"Đăng xuất thành công",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
    }

    public void ChooseImage(View view) {
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
                img.setImageBitmap(bitmap);
            } catch (FileNotFoundException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void Back(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}