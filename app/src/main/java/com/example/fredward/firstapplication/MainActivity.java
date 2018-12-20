package com.example.fredward.firstapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    //create a layout variable to hold the nav drawer
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         /* Create a Nav drawer that will show up on app bar
        Data will be acquired from the drawer_menu.xml
        assign mDrawerLayout
    */
         Toolbar toolbar = findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);
         ActionBar actionBar = getSupportActionBar();
         //THis if statement handles null exception but does not solve it
        //setDisplayAsUpenabled is invokes null pointer obhjec, need to slove
         if(actionBar != null){
             actionBar.setDisplayHomeAsUpEnabled(true);
             actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
         }



        mDrawerLayout = findViewById(R.id.drawer_layout);
         /* I get the nav menu with the expect design

          */
        NavigationView navigationView = findViewById(R.id.Nav_menu);
        //same error here nullpointer exception
        if(navigationView != null){
            navigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                            menuItem.setChecked(true);

                            mDrawerLayout.closeDrawers();
                            return true;
                        }
                    }
            );

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
