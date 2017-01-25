package com.example.daniel.storage_example.withInternalStorage;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daniel.storage_example.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InternalStorageActivity extends AppCompatActivity {

    private static final String TAG = "IntrnStrgActvitTAG_";
    private EditText userIDEdTxt;
    private EditText phoneEdTxt;
    private TextView userTxtVw;
    private TextView phoneTxtVw;

    private String userData;
    private String fileName = "user_Data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);

        userIDEdTxt = (EditText) findViewById(R.id.ais_userID);
        phoneEdTxt = (EditText) findViewById(R.id.ais_cellPhone);
        userTxtVw = (TextView) findViewById(R.id.ais_userTxtVw);
        phoneTxtVw = (TextView) findViewById(R.id.ais_phoneTxtVw);
    }

    public void doSave(View view) {

        userData = userIDEdTxt.getText().toString();
        Log.d(TAG, "doSave: "+ userData);

        try {
            //The following line will create the file
            FileOutputStream fileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            fileOutputStream.write(userData.getBytes());
            fileOutputStream.close();

            Toast.makeText(this, "File saved", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doLoad(View view) {
        try {
            FileInputStream fileInput = openFileInput(fileName);

            int c;
            String temp = "";

            while( (c = fileInput.read()) != -1){
                temp = temp + Character.toString((char)c);
            }

            fileInput.close();


            userTxtVw.setText(temp);
            //phoneTxtVw.setText(phone);

            Toast.makeText(this, "File read", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
References:
    - http://stackoverflow.com/questions/15779266/how-to-split-a-string-into-different-variables
    - http://www.tutorialspoint.com/java/java_string_split.htm
    - http://www.journaldev.com/9383/android-internal-storage-example-tutorial
    - https://www.tutorialspoint.com/android/android_internal_storage.htm
    - https://developer.android.com/guide/topics/data/data-storage.html#filesInternal
 */
/*
String[] splitted = s.split("},");

        // add the end brace for every entry except the last
        for (int i=0 ; i < splitted.length-1 ; i++) {
            splitted[i]=splitted[i] + "}";
        }

        System.out.println("-> "+splitted[1]);

        // print out the string array
        for (int i=0; i< splitted.length ; i++) {
            System.out.println("String s"+i+" = "+splitted[i]);
        }

        String x = splitted[0].toString();
        System.out.println("-->"+x.substring(1, x.length()-1));
 */