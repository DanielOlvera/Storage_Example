package com.example.daniel.storage_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.daniel.storage_example.withSharedPreferences.WithSharedPreferences;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void wSharedPrefs(View view) {
        Intent intent = new Intent(getApplicationContext(), WithSharedPreferences.class);
        startActivity(intent);
    }

    public void wInternalStrg(View view) {
    }

    public void wExternalStrg(View view) {
    }

    public void wSQLiteDB(View view) {
    }

    public void wNetworkConnection(View view) {
    }
}
