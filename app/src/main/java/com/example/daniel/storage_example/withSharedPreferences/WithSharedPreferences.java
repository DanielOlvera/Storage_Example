package com.example.daniel.storage_example.withSharedPreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daniel.storage_example.R;

public class WithSharedPreferences extends AppCompatActivity {

    private EditText nameEdTxt;
    private EditText idEdTxt;
    private EditText ageEdTxt;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_shared_preferences);

        nameEdTxt = (EditText) findViewById(R.id.wsp_nameEdTXt);
        idEdTxt = (EditText) findViewById(R.id.wsp_userIdEdTxt);
        ageEdTxt = (EditText) findViewById(R.id.wsp_ageEdTxt);

        SharedPrefeManager.Init(this);
    }

    // We need the below two callbacks to inflate the MenuItems in the app
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.wsp_settings:
                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent);

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void doShowSP(View view) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String chngName = sharedPreferences.getString("op_name", "Without Name");
        Boolean  checkboxVl = sharedPreferences.getBoolean("chkbx_value", false);
        String chngColor  = sharedPreferences.getString("color_list", "Without Name");

        Toast.makeText(this, chngName + checkboxVl + chngColor, Toast.LENGTH_SHORT).show();

    }

    public void goResultPref(View view) {
        Intent intent = new Intent(getApplicationContext(), SharedPreferencesResultActivity.class);
        startActivity(intent);
    }

    public void doShowPref(View view) {
        SharedPrefeManager.getPrefs();

        String name;

        //Here we are loading the values from sharedpreferences
        name = SharedPrefeManager.getuName();

        EditText rtrvePrefs;
        rtrvePrefs = (EditText) findViewById(R.id.wsp_nameEdTXt);
        rtrvePrefs.setText(name);

        Toast.makeText(this, "Data successfully loaded", Toast.LENGTH_SHORT).show();
    }

    public void doSavePref(View view) {

        //Here Im retriving the values from the edittext
        String name = nameEdTxt.getText().toString();
        String id = idEdTxt.getText().toString();
        String age = ageEdTxt.getText().toString();

        //now the validation for empty values
        if (name != null) {
            SharedPrefeManager.setuName(name);
        }
        if (id != null) {
            SharedPrefeManager.setuID(id);
        }
        if (age != null) {
            SharedPrefeManager.setuAge(Integer.parseInt(age));
        }

        SharedPrefeManager.savePrefs();

        //Here I will clean the first edit text, to show there the loaded values
        EditText cleanET;
        cleanET = (EditText) findViewById(R.id.wsp_nameEdTXt);
        cleanET.setText("");

        Toast.makeText(this, "Data saved in SharedPreferences file", Toast.LENGTH_SHORT).show();
    }
}

/*
References:
- Thanks to: search.maven.org/#artifactdetails%7Ccom.google.code.gson%7Cgson%7C2.8.0%7C
 */