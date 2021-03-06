package com.example.cidseuser.shiftintosleep;

import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    //Declaring All The Variables Needed

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the user interface layout for the front page
        setContentView(R.layout.activity_main);

        /*
        Assigning view variables to their respective view in xml
        by findViewByID method
         */

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        /*
        Creating Adapter and setting that adapter to the viewPager
        setSupportActionBar method takes the toolbar and sets it as
        the default action bar thus making the toolbar work like a normal
        action bar.
         */

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        setSupportActionBar(toolbar);

        /*
        TabLayout.newTab() method creates a tab view, Now a Tab view is not the view
        which is below the tabs, its the tab itself.
         */

        final TabLayout.Tab home = tabLayout.newTab();
        final TabLayout.Tab settings = tabLayout.newTab();
        final TabLayout.Tab alarms = tabLayout.newTab();
        final TabLayout.Tab stats = tabLayout.newTab();
        final TabLayout.Tab music = tabLayout.newTab();
        final TabLayout.Tab tips = tabLayout.newTab();

        /*
        Setting Title text for our tabs respectively
         */

        home.setText("Home");
        settings.setText("Settings");
        alarms.setText("Alarms");
        stats.setText("Stats");
        music.setText("Music");
        tips.setText("Tips");

        /*
        Adding the tab view to our tab layout at appropriate positions
        As I want home at first position I am passing home and 0 as argument to
        the tab layout and likewise for other tabs as well
         */
        tabLayout.addTab(home, 0);
        tabLayout.addTab(settings, 1);
        tabLayout.addTab(alarms, 2);
        tabLayout.addTab(stats, 3);
        tabLayout.addTab(music, 4);
        tabLayout.addTab(tips, 5);

        /*
        TabTextColor sets the color for the title of the tabs, passing a ColorStateList here makes
        tab change colors in different situations such as selected, active, inactive etc

        TabIndicatorColor sets the color for the indicator below the tabs
         */

        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this, R.color.tab_selector));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.indicator));

        /*
        Adding an onPageChangeListener to the viewPager
        1st we add the PageChangeListener and pass a TabLayoutPageChangeListener so that Tabs Selection
        changes when a viewpager page changes.
         */

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {

            }
        });

    }

}
