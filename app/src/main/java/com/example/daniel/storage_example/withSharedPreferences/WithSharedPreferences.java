package com.example.daniel.storage_example.withSharedPreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.daniel.storage_example.R;

public class WithSharedPreferences extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_shared_preferences);
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
}
