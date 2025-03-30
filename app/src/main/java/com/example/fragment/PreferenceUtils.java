package com.example.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceManager;

import java.util.Map;

public class PreferenceUtils {
    public static final String KEY_DARK_THEME = "dark_theme";
    public static final String KEY_USER_NAME = "user_name";

    public static SharedPreferences getSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void onSharedPreferenceChanged(Context context, String key) {
        if (key.equals(KEY_DARK_THEME)) {
            applyTheme(context);
        }

    }

    public static void applyTheme(Context context) {
        boolean isDarkThemeEnabled = getSharedPreferences(context).getBoolean(KEY_DARK_THEME, false);
        int nightMode = isDarkThemeEnabled ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO;
        AppCompatDelegate.setDefaultNightMode(nightMode);
    }


    public static void message(Context context,SharedPreferences sharedPreferences,String key){
        Map<String, ?> all = sharedPreferences.getAll();
        if(all.get(key) instanceof String) {
            Toast.makeText(context,"String\n "+sharedPreferences.getString(key,""),Toast.LENGTH_SHORT).show();
        }
        else if(all.get(key) instanceof Boolean) {
            Toast.makeText(context,"Boolean\n "+sharedPreferences.getBoolean(key,false),Toast.LENGTH_SHORT).show();
        }else if(all.get(key) instanceof Integer) {
            Toast.makeText(context,"Integer\n "+sharedPreferences.getInt(key,0),Toast.LENGTH_SHORT).show();
        }
    }
}
