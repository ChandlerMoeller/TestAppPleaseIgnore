/*The icons in this ZIP file were downloaded from http://icons4android.com

        All icons are licensed under Creative Commons (Attribution 3.0 Unported) (https://creativecommons.org/licenses/by/3.0/)
        Please note that one condition of this license is attribution.

        If you use these icons in your project(s), you must add a link to

        http://icons8.com/android-icons

        on your website or playstore site.

        Example of correct attribution:

        App icons by <a href="http://icons8.com/android-icons">Icons8.com</a>.*/

package com.drmidnight.materialtest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    ////String TITLES[] =  {"youCSC","Dining","Bus Routes","Campus Map","Event Calendar","myUCSC","eCommons","Piazza"};
    ////int ICONS[] = {R.drawable.ic_launcher, R.drawable.ic_dining, R.drawable.ic_bus, R.drawable.ic_map, R.drawable.ic_calendar, R.drawable.ic_myucsc, R.drawable.ic_myucsc, R.drawable.piazza};

    String TITLES[] =  {"youCSC","Dining","Bus Routes","Campus Map","Event Calendar"};
    int ICONS[] = {R.drawable.ic_launcher, R.drawable.ic_dining, R.drawable.ic_bus, R.drawable.ic_map, R.drawable.ic_calendar};

    String TITLES2[] = {"myUCSC","eCommons","Piazza"};
    int ICONS2[] = {R.drawable.ic_myucsc, R.drawable.ic_myucsc, R.drawable.piazza};

    String TITLES3[] = {"Settings","Help & feedback","About"};
    int ICONS3[] = {R.drawable.ic_settings, R.drawable.ic_feedback, R.drawable.ic_feedback};

    String SUBTITLES[] = {"Quick Links"};

    String NAME = "youCSC";
    String EMAIL = "An unofficial UCSC Application";
    int PROFILE = R.drawable.ic_launcher;

    private Toolbar toolbar;

    RecyclerView mRecyclerView;                           // Declaring RecyclerView
    RecyclerView.Adapter mAdapter;                        // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager
    DrawerLayout Drawer;

    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView); // Assigning the RecyclerView Object to the xml View

        mRecyclerView.setHasFixedSize(true);                            // Letting the system know that the list objects are of fixed size

        mAdapter = new MyAdapter(TITLES,ICONS,TITLES2,ICONS2,TITLES3,ICONS3,SUBTITLES,NAME,EMAIL,PROFILE,this);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)
        // And passing the titles,icons,header view name, header view email,
        // and header view profile picture

        mRecyclerView.setAdapter(mAdapter);                              // Setting the adapter to RecyclerView

        final GestureDetector mGestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener() {

            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        });


        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());


                if (child != null && mGestureDetector.onTouchEvent(motionEvent)) {
                    //Drawer.closeDrawers();
                    Toast.makeText(MainActivity.this, "The Item Clicked is: " + recyclerView.getChildPosition(child), Toast.LENGTH_SHORT).show();

                    switch (recyclerView.getChildPosition(child)) {
                        case 0:
                            //This is the header
                            break;
                        case 1:
                            Drawer.closeDrawers();
                            break;
                        case 2:
                            Drawer.closeDrawers();
                            Intent diningintent = new Intent(MainActivity.this, DiningActivity.class);
                            startActivity(diningintent);
                            break;
                        case 3:
                            Drawer.closeDrawers();
                            break;
                        case 4:
                            Drawer.closeDrawers();
                            break;
                        case 5:
                            Drawer.closeDrawers();
                            break;
                        case 6:
                            //This is a line
                            break;
                        case 7:
                            //This is a subtitle
                            break;
                        case 8:
                            Drawer.closeDrawers();
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://my.ucsc.edu/psp/ep9prd/?cmd=login&languageCd=ENG"));
                            if (browserIntent.resolveActivity(getPackageManager()) != null) {
                                startActivity(browserIntent);
                            }
                            break;
                        case 9:
                            Drawer.closeDrawers();
                            Intent browserIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ecommons.ucsc.edu/portal/login"));
                            if (browserIntent2.resolveActivity(getPackageManager()) != null) {
                                startActivity(browserIntent2);
                            }
                            break;
                        case 10:
                            Drawer.closeDrawers();
                            Intent browserIntent3 = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://piazza.com/class"));
                            if (browserIntent3.resolveActivity(getPackageManager()) != null) {
                                startActivity(browserIntent3);
                            }
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


        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);        // Drawer object Assigned to the view
        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                // open I am not going to put anything here)
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }



        }; // Drawer Toggle Object Made
        Drawer.setDrawerListener(mDrawerToggle); // Drawer Listener set to the Drawer toggle
        mDrawerToggle.syncState();               // Finally we set the drawer toggle sync State

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_todining) {
            Intent diningintent = new Intent(MainActivity.this, DiningActivity.class);
            startActivity(diningintent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}