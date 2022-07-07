package com.example.android;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.util.DisplayMetrics;

import androidx.appcompat.app.AppCompatDelegate;

import java.util.Locale;

public class SettingsActivity extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
        // implement your settings here
        setHasOptionsMenu(true);
        bindPreferenceSummaryToValue(findPreference("Choose_theme"));
        bindPreferenceSummaryToValue(findPreference("Choose_language"));
    }
    private void bindPreferenceSummaryToValue(Preference preference) {
        // Set the listener to watch for value changes.
        preference.setOnPreferenceChangeListener
                (sBindPreferenceSummaryToValueListener);

        // Trigger the listener immediately with the preference's
        // current value.
        sBindPreferenceSummaryToValueListener
                .onPreferenceChange(preference, PreferenceManager
                        .getDefaultSharedPreferences(preference.getContext())
                        .getString(preference.getKey(), ""));
    }

    private final Preference.OnPreferenceChangeListener sBindPreferenceSummaryToValueListener =
            (preference, o) -> {
                String stringValue = o.toString();
                Resources res = getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();
                // Toast.makeText(preference.getContext(), preference.getSummary(), Toast.LENGTH_SHORT).show();
                if (preference instanceof ListPreference) {
                    // For list preferences, look up the correct display value in
                    // the preference's 'entries' list.
                    ListPreference listPreference = (ListPreference) preference;
                    int index = listPreference.findIndexOfValue(stringValue);
                    //Toast.makeText(preference.getContext(), ((ListPreference) preference).getValue(), Toast.LENGTH_SHORT).show();

                    // Set the summary to reflect the new value.
                    preference.setSummary(
                            index >= 0
                                    ? listPreference.getEntries()[index]
                                    : null);
                    try {
                        AppCompatDelegate.setDefaultNightMode(Integer.parseInt(stringValue));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        if (stringValue.equals("zh")) {
                            conf.setLocale(new Locale("zh", "TW"));
                        } else {
                            conf.setLocale(new Locale("en"));
                        }
                        res.updateConfiguration(conf, dm);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else if (preference instanceof RingtonePreference) {
                    // For ringtone preferences, look up the correct display value
                    // using RingtoneManager.
                    Ringtone ringtone = RingtoneManager.getRingtone(
                            preference.getContext(), Uri.parse(stringValue));

                    if (ringtone == null) {
                        // Clear the summary if there was a lookup error.
                        preference.setSummary(null);
                    } else {
                        // Set the summary to reflect the new ringtone display
                        // name.
                        String name = ringtone.getTitle(preference.getContext());
                        preference.setSummary(name);

                    }
                } else {
                    // For all other preferences, set the summary to the value's
                    // simple string representation.
                    preference.setSummary(stringValue);

                }
                return true;
            };
}

