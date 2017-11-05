package com.taxishare.micka.taxishareproject.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.taxishare.micka.taxishareproject.Database.DatabaseManipulate;
import com.taxishare.micka.taxishareproject.R;

public class ProfileActivity extends AppCompatActivity {

    DatabaseManipulate databaseManipulate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        databaseManipulate = new DatabaseManipulate("users");

    }
}
