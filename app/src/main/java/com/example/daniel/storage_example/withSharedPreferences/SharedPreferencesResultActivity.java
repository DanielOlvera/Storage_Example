package com.example.daniel.storage_example.withSharedPreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.daniel.storage_example.R;

public class SharedPreferencesResultActivity extends AppCompatActivity {

    private TextView nameTxtVw;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_result);

        nameTxtVw = (TextView) findViewById(R.id.aspr_nameTxtVw);

        name = SharedPrefeManager.getuName();
        nameTxtVw.setText(name);

    }
}

/*
References:
    http://techblogon.com/android-sharedpreferences-example-code/
    https://www.youtube.com/watch?v=n04qMWGzqQU
    http://androidopentutorials.com/android-sharedpreferences-tutorial-and-example/
    https://www.youtube.com/watch?v=n04qMWGzqQU
 */