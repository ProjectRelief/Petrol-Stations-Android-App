package com.androiddev.petrolstations;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

public class InsideActivity extends AppCompatActivity {

    Toolbar toolbar;
    NavigationView navigationView;
    CoordinatorLayout coordinatorLayout;
    FrameLayout frameLayout;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside);

        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationView);
        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        frameLayout = findViewById(R.id.frame);
        drawerLayout = findViewById(R.id.drawerLayout);

        setUpToolBar();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame,new HomeFragment(),"HomeFragment")
                .commit();
        getSupportActionBar().setTitle(null);
        toolbar.setBackgroundColor(Color.parseColor("#ff0000"));

        actionBarDrawerToggle = new ActionBarDrawerToggle(
                InsideActivity.this,
                drawerLayout,
                R.string.open_drawer,
                R.string.close_drawer
        );

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.black));

        final MenuItem[] prevItemChecked = {null};
        final Fragment[] fragment = {null};
        navigationView.setCheckedItem(R.id.nav_home);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(prevItemChecked[0]!=null){
                    prevItemChecked[0].setChecked(false);
                }
                item.setCheckable(true);
                item.setChecked(true);
                prevItemChecked[0] = item;
                if(item.getItemId()==R.id.nav_home){
                    fragment[0] = new HomeFragment();
                    getSupportFragmentManager().popBackStack();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame,new HomeFragment(),"HomeFragment")
                            .addToBackStack("HomeFragment")
                            .commit();
                    getSupportActionBar().setTitle(null);
                    toolbar.setBackgroundColor(Color.parseColor("#ff0000"));
                    actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.black));
                    drawerLayout.closeDrawers();
                }else if(item.getItemId()==R.id.nav_petrol){
                    fragment[0] = new PetrolPumpsFragment();
                    getSupportFragmentManager().popBackStack();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame,new PetrolPumpsFragment(),"PetrolFragment")
                            .addToBackStack("PetrolFragment")
                            .commit();
                    getSupportActionBar().setTitle(null);
                    toolbar.setBackgroundColor(Color.parseColor("#ff0000"));
                    actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.black));
                    drawerLayout.closeDrawers();
                }else if(item.getItemId()==R.id.Speedometer){
                    fragment[0] = new SpeedometerFragment();
                    getSupportFragmentManager().popBackStack();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame,new PetrolPumpsFragment(),"SpeedometerFragment")
                            .addToBackStack("SpeedometerFragment")
                            .commit();
                    getSupportActionBar().setTitle(null);
                    toolbar.setBackgroundColor(Color.parseColor("#ff0000"));
                    actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.black));
                    drawerLayout.closeDrawers();
                }
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    public void setUpToolBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        if(getSupportActionBar() != null) {
//            getSupportActionBar().setTitle("Title");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}