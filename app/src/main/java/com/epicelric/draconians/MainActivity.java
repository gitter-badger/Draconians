package com.epicelric.draconians;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.util.Log;




public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        setTitle(getString(R.string.title_main));
        Log.d(TAG, "onCreate()");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        Log.d(TAG, "onCreateOptionsMenu() Inflate main_menu");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
//              TODO: 5/11/2016 Add settings page
//              Change to settings page
                Toast.makeText(getApplicationContext(), "Settings Touched", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onOptionsItemSelected() Settings pressed and toast sent");
                return true;


            case R.id.action_members:
                /*Change to members page*/
                setContentView(R.layout.members);
                Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
                setSupportActionBar(myToolbar);
                setTitle(getString(R.string.title_members));
                Log.d(TAG, "onOptionsItemSelected() Members pressed and change layout to members");
                return true;


            default:
//                If we got here, the user's action was not recognized.
//                Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


}
