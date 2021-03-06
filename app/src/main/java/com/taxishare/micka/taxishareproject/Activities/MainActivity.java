package com.taxishare.micka.taxishareproject.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.taxishare.micka.taxishareproject.Entities.User;
import com.taxishare.micka.taxishareproject.LocalStore.UserLocalStore;
import com.taxishare.micka.taxishareproject.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnLogout;
    EditText etName,etUsername,etAge,etId;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etName = (EditText)findViewById(R.id.etName);
        etUsername = (EditText)findViewById(R.id.etUsername);
        etAge = (EditText)findViewById(R.id.etAge);
        etId = (EditText)findViewById(R.id.etId);
        btnLogout = (Button) findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(this);
        userLocalStore = new UserLocalStore(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //if (authenticate()==true){
            displayUserDetails();
       // }else{
           // startActivity(new Intent(this,LoginActivity.class));
       // }
    }

    private boolean authenticate(){
        return userLocalStore.getUserLoggedIn();
    }

    private void displayUserDetails(){
        User user = userLocalStore.getLogedInUser();
        etUsername.setText(user.username);
        etName.setText(user.name);
        etId.setText(user.id);
        etAge.setText(user.age+"");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogout:
                userLocalStore.clearUserData();
                userLocalStore.setUserLoggedin(false);

                startActivity(new Intent(this,LoginActivity.class));

                break;


        }
    }

}

