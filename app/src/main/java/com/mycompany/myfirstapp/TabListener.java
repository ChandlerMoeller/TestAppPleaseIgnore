package com.mycompany.myfirstapp;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * Created by August on 2/4/2015.
 */
public class TabListener implements android.support.v7.app.ActionBar.TabListener {

    android.support.v4.app.Fragment frag;

    public TabListener(android.support.v4.app.Fragment fragment) {
        // TODO Auto-generated constructor stub
        this.frag = fragment;
    }

    @Override
    public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
        // TODO Auto-generated method stub
        ft.replace(R.id.fragment_container, frag);
    }

    @Override
    public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
        // TODO Auto-generated method stub
        ft.remove(frag);
    }

    @Override
    public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
        // TODO Auto-generated method stub

    }
}
