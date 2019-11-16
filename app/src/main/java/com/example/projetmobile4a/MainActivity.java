package com.example.projetmobile4a;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private FragAdapter myFragAdapter;
    private ViewPager myViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myFragAdapter = new FragAdapter(getSupportFragmentManager());
        myViewPager = findViewById(R.id.ViewPagerContainer); // Ce que contient la page

        setupViewPager(myViewPager);



        TabLayout tabLayout = findViewById(R.id.TabFragment);
        tabLayout.setupWithViewPager(myViewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.logo_menu_barre);
        tabLayout.getTabAt(1).setIcon(R.drawable.logo_crayon);
        tabLayout.getTabAt(2).setIcon(R.drawable.logo_loupe);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.BottomNavigationBar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem= menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.ic_arrox:
                        break;
                    case R.id.ic_dashboard:
                        Intent intent1 = new Intent(MainActivity.this, ActivityOne.class);
                        startActivity(intent1);
                        break;
                    case R.id.ic_android:
                        Intent intent2 = new Intent(MainActivity.this, ActivityTwo.class);
                        startActivity(intent2);
                        break;
                    case R.id.ic_photo:
                        Intent intent3 = new Intent(MainActivity.this, ActivityThree.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });

    }
        private void setupViewPager(ViewPager viewPager){
            FragAdapter Fadapter = new FragAdapter(getSupportFragmentManager());
            Fadapter.addFragment(new Fragment1());
            Fadapter.addFragment(new Fragment2());
            Fadapter.addFragment(new Fragment3());
            myViewPager.setAdapter(Fadapter);

    }
}
