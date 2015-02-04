package com.mycompany.myfirstapp;

/**
 * Created by August on 2/4/2015.
 */

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DiningNTFragment extends android.support.v4.app.Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Resources res = getResources();
        String text = String.format(
                res.getString(R.string.dining_content2),R.string.dining_nt);
        View rootView = inflater.inflate(R.layout.fragment_dining, container, false);

        return rootView;
    }
}
