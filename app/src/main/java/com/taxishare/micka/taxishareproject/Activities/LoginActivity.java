package com.taxishare.micka.taxishareproject.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.taxishare.micka.taxishareproject.LocalStore.UserLocalStore;
import com.taxishare.micka.taxishareproject.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin;
    EditText etUsername,etPassword;
    TextView tvRegisterLink;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);

        btnLogin.setOnClickListener(this);
        userLocalStore = new UserLocalStore(this);
        tvRegisterLink.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:


                userLocalStore.setUserLoggedin(true);
                break;
            case R.id.tvRegisterLink:
                startActivity(new Intent(this,RegisteryActivity.class));
                break;
        }
    }
}
