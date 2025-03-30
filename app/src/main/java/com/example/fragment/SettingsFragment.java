package com.example.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;


public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {

    private SharedPreferences sharedPreferences;

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,String key) {
        PreferenceUtils.onSharedPreferenceChanged(requireContext(), key);
        PreferenceUtils.message(requireContext(),sharedPreferences,key);
    }
    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        setPreferencesFromResource(R.xml.preferences,rootKey);
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(requireContext());

        EditTextPreference usernamePreference = findPreference(PreferenceUtils.KEY_USER_NAME);
        if (usernamePreference != null) {
            usernamePreference.setSummaryProvider((Preference.SummaryProvider<EditTextPreference>) preference ->
            {
                String text = preference.getText();
                if (text == null || text.isBlank()) {
                    return "Nom d'utilisateur non défini";
                }
                return text;
            });
    }
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

//reférence forte???
// Map<String, ?>