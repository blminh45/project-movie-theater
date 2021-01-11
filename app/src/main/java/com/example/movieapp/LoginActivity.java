package com.example.movieapp;

import android.app.ActivityOptions;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

    Button SignUp, btn_login;
    ImageView image;
    TextView logoText, sloganText;
    TextInputLayout username, password;
    SignInButton loginGg;
    GoogleSignInClient mGoogleSignInClient;
    int RC_SIGN_IN = 0;
    private LoginButton login;
    private CallbackManager callbackManager;
    public static final int SCROLL_DELTA = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login_fb);
        loginGg = findViewById(R.id.login_gg);
        ImageView img = findViewById(R.id.img);
        TextView fullname=findViewById(R.id.fullname),email = findViewById(R.id.email);
        //login google
        loginGg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.login_gg:
                        signIn();
                        break;
                    // ...
                }
            }
        });
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        //login facebook
        callbackManager = CallbackManager.Factory.create();
        login.setPermissions(Arrays.asList("user_gender","user_friends"));
        login.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent intent = new Intent(LoginActivity.this,InforActivity.class);
                startActivity(intent);
                Log.d("demo","Đăng nhập thành công");
            }

            @Override
            public void onCancel() {

                Log.d("demo","Đóng đăng nhập");
            }

            @Override
            public void onError(FacebookException error) {

                Log.d("demo","Đăng nhập thất bại");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
    }

    public void callSignUp(View view) {
        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);

        sloganText = findViewById(R.id.ex);
        image = findViewById(R.id.logo_image);
        logoText = findViewById(R.id.slogan);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.login);
        SignUp = findViewById(R.id.signup);

        Pair[] pairs = new Pair[7];
        pairs[0] = new Pair<View, String>(image, "logo_image");
        pairs[1] = new Pair<View, String>(logoText, "logo_text");
        pairs[2] = new Pair<View, String>(sloganText, "ex_tran");
        pairs[3] = new Pair<View, String>(username, "username_tran");
        pairs[4] = new Pair<View, String>(password, "password_tran");
        pairs[6] = new Pair<View, String>(btn_login, "button_tran");
        pairs[5] = new Pair<View, String>(SignUp, "login_signup_tran");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);
        startActivity(intent, options.toBundle());
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
        GraphRequest graphRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        Log.d("Demo",object.toString());
                        try {
                            String name = object.getString("name");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
        Bundle bundle = new Bundle();
        bundle.putString("fields","gender,name,id,first_name,last_name");
        graphRequest.setParameters(bundle);
        graphRequest.executeAsync();
    }

    AccessTokenTracker accessTokenTracker = new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
            if(currentAccessToken == null){
                LoginManager.getInstance().logOut();
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        accessTokenTracker.stopTracking();
    }

    private Boolean validateUsername() {
        String val = username.getEditText().getText().toString();
        String noWhiteSpace = "\\A\\w{6,20}\\z";

        if (val.isEmpty()) {
            username.setError("Tài khoản không được bỏ trống");
            return false;
        } else if (!val.matches(noWhiteSpace)) {
            username.setError("Tài khoản phải từ 6 đến 20 ký tự");
            return false;
        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = password.getEditText().getText().toString();

        if (val.isEmpty()) {
            password.setError("Mật khẩu không được bỏ trống");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

    public void validateUser(View view) {
        if (!validateUsername() | !validatePassword()) {
        }
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            // Signed in successfully, show authenticated UI.
            Intent intent = new Intent(this,InforActivity.class);
            //String message = account.getEmail();
            //intent.putExtra("email", message);
            startActivity(intent);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("Error", "signInResult:failed code=" + e.getStatusCode());
        }
    }
}