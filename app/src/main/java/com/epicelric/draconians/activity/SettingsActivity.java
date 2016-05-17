package com.epicelric.draconians.activity;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Elric on 5/16/2016.
 */
public class SettingsActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }

}
