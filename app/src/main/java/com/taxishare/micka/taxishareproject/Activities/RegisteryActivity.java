package com.taxishare.micka.taxishareproject.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.taxishare.micka.taxishareproject.Database.DatabaseManipulate;
import com.taxishare.micka.taxishareproject.Entities.User;
import com.taxishare.micka.taxishareproject.LocalStore.UserLocalStore;
import com.taxishare.micka.taxishareproject.R;

public class RegisteryActivity extends AppCompatActivity implements View.OnClickListener{

    UserLocalStore userLocalStore;
    DatabaseManipulate databaseManipulate;
    Button btnRegister;
    EditText etName,etUsername,etAge,etPassword ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registery);

        etName = (EditText)findViewById(R.id.etName);
        etUsername = (EditText)findViewById(R.id.etUsername);
        etAge = (EditText)findViewById(R.id.etAge);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        databaseManipulate = new DatabaseManipulate("users");
        userLocalStore = new UserLocalStore(this);

        btnRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRegister:

                String name = etName.getText().toString();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                int age = Integer.parseInt(etAge.getText().toString());
                    //TODO: save to local storage with unique id from Firebase
                User registerData = new User(name,username,password,age);
                userLocalStore.storeUserData(new User(name,username,password,age,databaseManipulate.getUniqueId()));
                databaseManipulate.saveObjectToDatabase(new User(name,username,password,age));

                startActivity(new Intent(this,MainActivity.class));


                break;
        }
    }
}
