package com.drmidnight.materialtest;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v4.app.FragmentManager;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import org.joda.time.DateTime;

import com.doomonafireball.betterpickers.calendardatepicker.CalendarDatePickerDialog;
import com.gc.materialdesign.views.ButtonFloat;


public class DiningActivity extends ActionBarActivity implements CalendarDatePickerDialog.OnDateSetListener {

    private static final String FRAG_TAG_DATE_PICKER = "fragment_date_picker_name";
    
    private Toolbar toolbar;
    private ButtonFloat buttonFloat;

    Calendar c = Calendar.getInstance(TimeZone.getDefault());
    int startYear = c.get(Calendar.YEAR);
    int startMonth = c.get(Calendar.MONTH) + 1;
    int startDay = c.get(Calendar.DAY_OF_MONTH);

    //startMonth + "/" + startDay + "/" + startYear;

    String SUBTITLES[] = {"Quick Links"};


    RecyclerView mRecyclerView;                           // Declaring RecyclerView
    RecyclerView.Adapter mAdapter;                        // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager
    String BREAKFASTTITLES[];
    int BREAKFASTICONS[] = {R.drawable.ic_launcher};
    String BREAKFASTNAME = "Breakfast";
    String BREAKFASTEMAIL = "7:15am to 11:00am";
    int BREAKFASTPROFILE = R.drawable.ic_launcher;

    RecyclerView mRecyclerView2;                           // Declaring RecyclerView
    RecyclerView.Adapter mAdapter2;                        // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager2;            // Declaring Layout Manager as a linear layout manager
    String LUNCHTITLES[] =  {"LunchFood1","Food2","Food3","Food4","Food5"};
    int LUNCHICONS[] = {R.drawable.ic_launcher, R.drawable.ic_dining, R.drawable.ic_bus, R.drawable.ic_map, R.drawable.ic_calendar};
    String LUNCHNAME = "Lunch";
    String LUNCHEMAIL = "12:00pm to 2:00pm";
    int LUNCHPROFILE = R.drawable.ic_launcher;

    RecyclerView mRecyclerView3;                           // Declaring RecyclerView
    RecyclerView.Adapter mAdapter3;                        // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager3;            // Declaring Layout Manager as a linear layout manager
    String DINNERTITLES[] =  {"Food1","Food2","DinnerFood3","Food4","Food5"};
    int DINNERICONS[] = {R.drawable.ic_launcher, R.drawable.ic_dining, R.drawable.ic_bus, R.drawable.ic_map, R.drawable.ic_calendar};
    String DINNERNAME = "Dinner";
    String DINNEREMAIL = "5:00pm to 8:00pm";
    int DINNERPROFILE = R.drawable.ic_launcher;

    //EDDIE's code implementation
    ArrayList<com.drmidnight.materialtest.MenuItem> breakfast;
    ArrayList<com.drmidnight.materialtest.MenuItem> lunch;
    ArrayList<com.drmidnight.materialtest.MenuItem> dinner;
    com.drmidnight.materialtest.Menu menu;




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


/*
        //EDDIE's code implementation
        ArrayList<com.drmidnight.materialtest.MenuItem> breakfast;
        breakfast = new ArrayList<com.drmidnight.materialtest.MenuItem>();
        ArrayList<com.drmidnight.materialtest.MenuItem> lunch;
        lunch = new ArrayList<com.drmidnight.materialtest.MenuItem>();
        ArrayList<com.drmidnight.materialtest.MenuItem> dinner;
        dinner = new ArrayList<com.drmidnight.materialtest.MenuItem>();
        com.drmidnight.materialtest.Menu menu;
*/

        breakfast = new ArrayList<com.drmidnight.materialtest.MenuItem>();
        lunch = new ArrayList<com.drmidnight.materialtest.MenuItem>();
        dinner = new ArrayList<com.drmidnight.materialtest.MenuItem>();

        try {

            // Remove this
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);



            menu = new com.drmidnight.materialtest.Menu(startDay, startMonth, startYear, com.drmidnight.materialtest.Menu.CM);
            breakfast = menu.getBreakfast();
            lunch = menu.getLunch();
            dinner = menu.getDinner();
            //menu = new com.drmidnight.materialtest.Menu(startDay, startMonth, startYear, com.drmidnight.materialtest.Menu.CS);
            //menu = new com.drmidnight.materialtest.Menu(startDay, startMonth, startYear, com.drmidnight.materialtest.Menu.PK);
            //menu = new com.drmidnight.materialtest.Menu(startDay, startMonth, startYear, com.drmidnight.materialtest.Menu.EO);
            //menu = new com.drmidnight.materialtest.Menu(startDay, startMonth, startYear, com.drmidnight.materialtest.Menu.NT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BREAKFASTTITLES = new String[breakfast.size()];
        for (int i = 0; i < breakfast.size(); i++) {
            BREAKFASTTITLES[i] = (String) breakfast.get(i).getElement().text();
        }

        LUNCHTITLES = new String[lunch.size()];
        for (int i = 0; i < lunch.size(); i++) {
            LUNCHTITLES[i] = (String) lunch.get(i).getElement().text();
        }

        DINNERTITLES = new String[dinner.size()];
        for (int i = 0; i < dinner.size(); i++) {
            DINNERTITLES[i] = (String) dinner.get(i).getElement().text();
        }








        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerViewDining); // Assigning the RecyclerView Object to the xml View

        mRecyclerView.setHasFixedSize(false);                            // Letting the system know that the list objects are of fixed size

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

        mRecyclerView2.setHasFixedSize(false);                            // Letting the system know that the list objects are of fixed size

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

        mRecyclerView3.setHasFixedSize(false);                            // Letting the system know that the list objects are of fixed size

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








        //FAB STUFF
        buttonFloat = (ButtonFloat) findViewById(R.id.buttonFloat);

        buttonFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                DateTime now = DateTime.now();
                CalendarDatePickerDialog calendarDatePickerDialog = CalendarDatePickerDialog
                        .newInstance(DiningActivity.this, now.getYear(), now.getMonthOfYear() - 1,
                                now.getDayOfMonth());
                calendarDatePickerDialog.show(fm, FRAG_TAG_DATE_PICKER);
            }
        });
    }


    @Override
    public void onDateSet(CalendarDatePickerDialog dialog, int year, int monthOfYear, int dayOfMonth) {
        //text.setText("Year: " + year + "\nMonth: " + monthOfYear + "\nDay: " + dayOfMonth);
    }

    @Override
    public void onResume() {
        // Example of reattaching to the fragment
        super.onResume();
        CalendarDatePickerDialog calendarDatePickerDialog = (CalendarDatePickerDialog) getSupportFragmentManager()
                .findFragmentByTag(FRAG_TAG_DATE_PICKER);
        if (calendarDatePickerDialog != null) {
            calendarDatePickerDialog.setOnDateSetListener(this);
        }
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
