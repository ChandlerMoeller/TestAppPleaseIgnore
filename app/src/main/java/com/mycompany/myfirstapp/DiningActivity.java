package com.mycompany.myfirstapp;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class DiningActivity extends ActionBarActivity {

    // Tab fragments
    ActionBar.Tab csTab, cmTab, ntTab, pkTab, eoTab;
    android.support.v4.app.Fragment csFragmentTab = new DiningCSFragment();
    android.support.v4.app.Fragment cmFragmentTab = new DiningCMFragment();
    android.support.v4.app.Fragment ntFragmentTab = new DiningNTFragment();
    android.support.v4.app.Fragment pkFragmentTab = new DiningPKFragment();
    android.support.v4.app.Fragment eoFragmentTab = new DiningEOFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining);

        // Set the Action Bar to use tabs for navigation
        ActionBar ab = getSupportActionBar();
        ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Adding labels
        csTab = ab.newTab().setText(R.string.dining_cs_tab);
        cmTab = ab.newTab().setText(R.string.dining_cm_tab);
        ntTab = ab.newTab().setText(R.string.dining_nt_tab);
        pkTab = ab.newTab().setText(R.string.dining_pk_tab);
        eoTab = ab.newTab().setText(R.string.dining_eo_tab);

        // Setting tab listeners
        csTab.setTabListener(new TabListener(csFragmentTab));
        cmTab.setTabListener(new TabListener(cmFragmentTab));
        ntTab.setTabListener(new TabListener(ntFragmentTab));
        pkTab.setTabListener(new TabListener(pkFragmentTab));
        eoTab.setTabListener(new TabListener(eoFragmentTab));

        // Adding tabs
        ab.addTab(csTab);
        ab.addTab(cmTab);
        ab.addTab(ntTab);
        ab.addTab(pkTab);
        ab.addTab(eoTab);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dining, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent actionintent = new Intent(this, DisplaySettingsActivity.class);
            startActivity(actionintent);
            return true;
        }

        if (id == R.id.action_about) {
            Intent aboutintent = new Intent(this, DisplayAboutActivity.class);
            startActivity(aboutintent);
            return true;
        }

        if (id == R.id.action_sendfeedback) {
            Intent aboutintent = new Intent(this, DisplaySendFeedbackActivity.class);
            startActivity(aboutintent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
