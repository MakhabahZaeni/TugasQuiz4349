package com.example.quiz;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    static SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SharedPrefManager(Context context) {
        sharedPreferences = context.getSharedPreferences("com.example.sharedpreferences", context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        setAsDefaultValue();
    }

    private void setAsDefaultValue() {
        setUsername("Makhabah");
        setPassword("4349");
    }

    public void saveString(String value) {
        editor.putString("sp_string", value);
        editor.commit();
    }

    private void setUsername(String usernameValue) {
        editor.putString("sp_username", usernameValue).apply();
    }

    private void setPassword(String passwordValue) {
        editor.putString("sp_password", passwordValue).apply();
    }

    public void saveIsLogin(Boolean value) {
        editor.putBoolean("sp_islogin", value);
        editor.commit();
    }

    public String getString(){
        return sharedPreferences.getString("sp_string", "");
    }

    public static String getUsername(){
        return sharedPreferences.getString("sp_username", "");
    }

    public static String getPassword() {
        return sharedPreferences.getString("sp_password", "");
    }

    public boolean getIsLogin() {
        return sharedPreferences.getBoolean("sp_isLogin", false);
    }


}
