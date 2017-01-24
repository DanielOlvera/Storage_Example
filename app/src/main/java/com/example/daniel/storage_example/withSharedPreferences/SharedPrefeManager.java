package com.example.daniel.storage_example.withSharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Daniel on 1/24/17.
 */

//Here we are creating a specific class that will manage the preferences to have a better
// modularization of the code
public class SharedPrefeManager {

    public static final String MY_SHRD_PREFS = "MySharePrefs";

    private static Context context;
    private static String uName = "";
    private static String uID = "";
    private static int uAge = 0;

    public SharedPrefeManager() {
        super();
    }

    public static void Init(Context mContext)
    {
        context 		= mContext;
    }

    //Is needed to create an instance of the share preferences for each step of the CRUD we
    //wanted to do
    public static void savePrefs(){
        SharedPreferences settings = context.getSharedPreferences(MY_SHRD_PREFS, 0);
        SharedPreferences.Editor editorPrefs = settings.edit();

        editorPrefs.putString("Name", uName);
        editorPrefs.putString("ID", uID);
        editorPrefs.putInt("Age", uAge);

        editorPrefs.commit();
    }

    public static void getPrefs(){
        SharedPreferences settings = context.getSharedPreferences(MY_SHRD_PREFS, 0);

        uName = settings.getString("Name", "");
        uID = settings.getString("ID", "");
        uAge = settings.getInt("Age", 0);
    }

    public static void deleteSinglePref(String keyName){
        SharedPreferences settings = context.getSharedPreferences(MY_SHRD_PREFS, 0);
        SharedPreferences.Editor editor = settings.edit();

        editor.remove(keyName);
        editor.commit();
    }

    public static void deleteAllPrefs(){
        SharedPreferences settings = context.getSharedPreferences(MY_SHRD_PREFS, 0);
        SharedPreferences.Editor editor = settings.edit();

        editor.clear();
        editor.commit();
    }

    public static String getuName() {
        return uName;
    }

    public static void setuName(String uName) {
        SharedPrefeManager.uName = uName;
    }

    public static String getuID() {
        return uID;
    }

    public static void setuID(String uID) {
        SharedPrefeManager.uID = uID;
    }

    public static int getuAge() {
        return uAge;
    }

    public static void setuAge(int uAge) {
        SharedPrefeManager.uAge = uAge;
    }
}
