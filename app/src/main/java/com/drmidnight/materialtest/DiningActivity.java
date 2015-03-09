package com.drmidnight.materialtest;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;


public class DiningActivity extends ActionBarActivity {

    private Toolbar toolbar;


    Calendar c = Calendar.getInstance();
    int startYear = c.get(Calendar.YEAR);
    int startMonth = c.get(Calendar.MONTH);
    int startDay = c.get(Calendar.DAY_OF_MONTH);

    //startMonth + "/" + startDay + "/" + startYear;

    String SUBTITLES[] = {"Quick Links"};


    RecyclerView mRecyclerView;                           // Declaring RecyclerView
    RecyclerView.Adapter mAdapter;                        // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager
    String BREAKFASTTITLES[] =  {"Food1","Food2","Food3","Food4","Food5"};
    int BREAKFASTICONS[] = {R.drawable.ic_launcher, R.drawable.ic_dining, R.drawable.ic_bus, R.drawable.ic_map, R.drawable.ic_calendar};
    String BREAKFASTNAME = "Breakfast";
    String BREAKFASTEMAIL = "Breakfast Hours will go here";
    int BREAKFASTPROFILE = R.drawable.ic_launcher;

    RecyclerView mRecyclerView2;                           // Declaring RecyclerView
    RecyclerView.Adapter mAdapter2;                        // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager2;            // Declaring Layout Manager as a linear layout manager
    String LUNCHTITLES[] =  {"LunchFood1","Food2","Food3","Food4","Food5"};
    int LUNCHICONS[] = {R.drawable.ic_launcher, R.drawable.ic_dining, R.drawable.ic_bus, R.drawable.ic_map, R.drawable.ic_calendar};
    String LUNCHNAME = "Lunch";
    String LUNCHEMAIL = "Lunch Hours will go here";
    int LUNCHPROFILE = R.drawable.ic_launcher;

    RecyclerView mRecyclerView3;                           // Declaring RecyclerView
    RecyclerView.Adapter mAdapter3;                        // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager3;            // Declaring Layout Manager as a linear layout manager
    String DINNERTITLES[] =  {"Food1","Food2","DinnerFood3","Food4","Food5"};
    int DINNERICONS[] = {R.drawable.ic_launcher, R.drawable.ic_dining, R.drawable.ic_bus, R.drawable.ic_map, R.drawable.ic_calendar};
    String DINNERNAME = "Dinner";
    String DINNEREMAIL = "Dinner Hours will go here";
    int DINNERPROFILE = R.drawable.ic_launcher;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining);

        toolbar = (Toolbar) findViewById(R.id.tool_bar_dining);
        setSupportActionBar(toolbar);
        //disable default title
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                onBackPressed();
            }
        });


        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerViewDining); // Assigning the RecyclerView Object to the xml View

        mRecyclerView.setHasFixedSize(true);                            // Letting the system know that the list objects are of fixed size

        mAdapter = new MyDiningListAdapter(BREAKFASTTITLES,BREAKFASTICONS,SUBTITLES,BREAKFASTNAME,BREAKFASTEMAIL,BREAKFASTPROFILE,this);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)
        // And passing the titles,icons,header view name, header view email,
        // and header view profile picture

        mRecyclerView.setAdapter(mAdapter);                              // Setting the adapter to RecyclerView

        final GestureDetector mGestureDetector = new GestureDetector(DiningActivity.this, new GestureDetector.SimpleOnGestureListener() {

            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        });


        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());


                if (child != null && mGestureDetector.onTouchEvent(motionEvent)) {
                    Toast.makeText(DiningActivity.this, "The Item Clicked is: " + recyclerView.getChildPosition(child), Toast.LENGTH_SHORT).show();

                    switch (recyclerView.getChildPosition(child)) {
                        case 0:
                            //This is the header
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:

                            break;
                        case 4:

                            break;
                        case 5:

                            break;
                        case 6:
                            //This is a line
                            break;
                        case 7:
                            //This is a subtitle
                            break;
                        case 8:

                            break;
                        case 9:

                            break;
                        case 10:

                            break;
                        default:
                            break;
                    }

                    return true;

                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

            }
        });


        mLayoutManager = new LinearLayoutManager(this);                 // Creating a layout Manager

        mRecyclerView.setLayoutManager(mLayoutManager);                 // Setting the layout Manager













        mRecyclerView2 = (RecyclerView) findViewById(R.id.RecyclerViewDining2); // Assigning the RecyclerView Object to the xml View

        mRecyclerView2.setHasFixedSize(true);                            // Letting the system know that the list objects are of fixed size

        mAdapter2 = new MyDiningListAdapter(LUNCHTITLES,LUNCHICONS,SUBTITLES,LUNCHNAME,LUNCHEMAIL,LUNCHPROFILE,this);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)
        // And passing the titles,icons,header view name, header view email,
        // and header view profile picture

        mRecyclerView2.setAdapter(mAdapter2);                              // Setting the adapter to RecyclerView

        final GestureDetector mGestureDetector2 = new GestureDetector(DiningActivity.this, new GestureDetector.SimpleOnGestureListener() {

            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        });


        mRecyclerView2.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());


                if (child != null && mGestureDetector2.onTouchEvent(motionEvent)) {
                    Toast.makeText(DiningActivity.this, "The Item Clicked is: " + recyclerView.getChildPosition(child), Toast.LENGTH_SHORT).show();

                    switch (recyclerView.getChildPosition(child)) {
                        case 0:
                            //This is the header
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:

                            break;
                        case 4:

                            break;
                        case 5:

                            break;
                        case 6:
                            //This is a line
                            break;
                        case 7:
                            //This is a subtitle
                            break;
                        case 8:

                            break;
                        case 9:

                            break;
                        case 10:

                            break;
                        default:
                            break;
                    }

                    return true;

                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

            }
        });


        mLayoutManager2 = new LinearLayoutManager(this);                 // Creating a layout Manager

        mRecyclerView2.setLayoutManager(mLayoutManager2);                 // Setting the layout Manager















        mRecyclerView3 = (RecyclerView) findViewById(R.id.RecyclerViewDining3); // Assigning the RecyclerView Object to the xml View

        mRecyclerView3.setHasFixedSize(true);                            // Letting the system know that the list objects are of fixed size

        mAdapter3 = new MyDiningListAdapter(DINNERTITLES,DINNERICONS,SUBTITLES,DINNERNAME,DINNEREMAIL,DINNERPROFILE,this);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)
        // And passing the titles,icons,header view name, header view email,
        // and header view profile picture

        mRecyclerView3.setAdapter(mAdapter3);                              // Setting the adapter to RecyclerView

        final GestureDetector mGestureDetector3 = new GestureDetector(DiningActivity.this, new GestureDetector.SimpleOnGestureListener() {

            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        });


        mRecyclerView3.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());


                if (child != null && mGestureDetector3.onTouchEvent(motionEvent)) {
                    Toast.makeText(DiningActivity.this, "The Item Clicked is: " + recyclerView.getChildPosition(child), Toast.LENGTH_SHORT).show();

                    switch (recyclerView.getChildPosition(child)) {
                        case 0:
                            //This is the header
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:

                            break;
                        case 4:

                            break;
                        case 5:

                            break;
                        case 6:
                            //This is a line
                            break;
                        case 7:
                            //This is a subtitle
                            break;
                        case 8:

                            break;
                        case 9:

                            break;
                        case 10:

                            break;
                        default:
                            break;
                    }

                    return true;

                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

            }
        });


        mLayoutManager3 = new LinearLayoutManager(this);                 // Creating a layout Manager

        mRecyclerView3.setLayoutManager(mLayoutManager3);                 // Setting the layout Manager








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
        if (id == R.id.action_Changedate) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
