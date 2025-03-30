package com.example.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

public class advancedSettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {
    private SharedPreferences sharedPreferences;
    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        setPreferencesFromResource(R.xml.advanced_preferences,rootKey);
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(requireContext());

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, @Nullable String key) {

    }

    @Override
    public void onPause(){
        super.onPause();
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (sharedPreferences != null) {
            sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        }
    }
}
