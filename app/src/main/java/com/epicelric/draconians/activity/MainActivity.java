package com.epicelric.draconians.activity;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.epicelric.draconians.R;

public class MainActivity extends AppCompatActivity{
    private static final String TAG = "MainActivity";

    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        setContentView(R.layout.activity_main);

         /**
         *Setup the DrawerLayout and NavigationView
         */
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navview) ;

         /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();

        /**
         * Setup click events on the Navigation View Items.
         */
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers(); //Close Drawer menu

                if (menuItem.getItemId() == R.id.nav_item_settings) {
                    /**  Settings menu being called */
                    menuItem.setChecked(true); //Set Menu item to highlighted
                    Log.d(TAG, "Settings Pressed from Drawer");
                    // TODO: 5/17/2016 Figure out why screen is not clearing for the settings view.
                    getFragmentManager().beginTransaction().replace(R.id.containerView,new SettingsFragment()).commit();
                    Log.d(TAG, "SettingsFragment() Displayed");
                }

                if (menuItem.getItemId() == R.id.nav_item_home) {
                    /**  Home screen being called */
                    menuItem.setChecked(true); //Set Menu item to highlighted
                    Log.d(TAG, "Home pressed from Drawer");
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();
                    Log.d(TAG, "TabFragment() Displayed");
                }

                return false;
            }

        });



        /**
         * Setup Drawer Toggle of the Toolbar
         */



        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar,R.string.app_name,R.string.app_name);

//        if(toolbar != null) {
//            setSupportActionBar(toolbar);
//            getSupportActionBar().setTitle("My custom toolbar!");
//            getSupportActionBar().setHomeButtonEnabled(true);
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        }

        mDrawerLayout.addDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();


    }


}
