package com.example.fredward.firstapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
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

         mDrawerLayout = findViewById(R.id.drawer_layout);

         ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.openNav,R.string.closeNav);
         mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
         actionBarDrawerToggle.syncState();

        /**
         * NavigationView to open the user requested menu:
         * Using onclicklistener and switch statement to open the correct menu
         */

        NavigationView navigationView = findViewById(R.id.Nav_menu);
            navigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                            //Go to the selected tab by the user
                            //using menuItem compare the selection and go to appropriate fragment
                            switch (menuItem.getItemId()){
                                case (R.id.recent_release):
                                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new RecentFragment()).commit();
                                    break;
                                case (R.id.favorites):
                                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FavoritesFragment()).commit();
                                    break;
                                case (R.id.settings):
                                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new UpdateFragment()).commit();
                                    break;
                            }
                            menuItem.setChecked(true);
                            mDrawerLayout.closeDrawers();
                            return true;
                        }
                    }
            );

        }

    /**
     * override onBackPressed for back button press when menu is open
     * Close the menu instead of the app
     */

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
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
