package com.xurxo.androidtestingcalculator.unit.fragments.presentation.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.xurxo.androidtestingcalculator.R;
import com.xurxo.androidtestingcalculator.unit.fragments.CalculatorFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (savedInstanceState == null) {
            setupToolbar();
            setupNavDrawer();
            setupNavigationView();
            setupContentFragment();
        }
    }

    private void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
    }

    private void setupNavDrawer() {
        if (toolbar != null) {
            ActionBar actionBar = getSupportActionBar();

            if (actionBar != null)
                actionBar.setDisplayHomeAsUpEnabled(true);

/*            toolbar.setNavigationIcon(R.drawable.ic_drawer);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            });*/

            //ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer)
            ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0){

                @Override
                public void onDrawerClosed(View drawerView) {
                    // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                    super.onDrawerClosed(drawerView);
                }

                @Override
                public void onDrawerOpened(View drawerView) {
                    // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                    super.onDrawerOpened(drawerView);
                }
            };

            drawerLayout.setDrawerListener(actionBarDrawerToggle);

            //calling sync state is necessay or else your hamburger icon wont show up
            actionBarDrawerToggle.syncState();
        }
    }

    private void setupNavigationView(){
        NavigationView view = (NavigationView) findViewById(R.id.navigation);
        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override public boolean onNavigationItemSelected(MenuItem menuItem) {
                Snackbar.make(findViewById(android.R.id.content), menuItem.getTitle() + " pressed", Snackbar.LENGTH_LONG).show();
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });
/*

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        Snackbar.make(mContentFrame, "Item One",
                                Snackbar.LENGTH_SHORT).show();
                        *//*mCurrentSelectedPosition = 0;*//*
                        return true;
                    case R.id.navigation_item_2:
                        Snackbar.make(mContentFrame, "Item Two",
                                Snackbar.LENGTH_SHORT).show();
                        *//*mCurrentSelectedPosition = 1;*//*
                        return true;
                    default:
                        return true;
                }
            }
        });*/
    }

    private void setupContentFragment(){
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new CalculatorFragment())
                .commit();
    }
}
