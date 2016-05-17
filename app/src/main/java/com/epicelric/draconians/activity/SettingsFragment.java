package com.epicelric.draconians.activity;

import android.os.Bundle;
import android.preference.PreferenceFragment;



import com.epicelric.draconians.R;

/**
 * Created by Elric on 5/13/2016.
 */
public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
    }
}

