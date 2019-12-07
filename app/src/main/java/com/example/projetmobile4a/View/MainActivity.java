package com.example.projetmobile4a.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;


import com.example.projetmobile4a.Controller.Controller;
import com.example.projetmobile4a.Model.MyList;
import com.example.projetmobile4a.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    String key = "myCacheList";

    private Controller controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecyclerView);

        controller = new Controller(this, getSharedPreferences(key, Context.MODE_PRIVATE));
        controller.onCreate();

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

    //Permet d'afficher la recyclerView + API à l'écran
    public void showList(List<MyList> listItems)
    {
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new RecyclerViewAdapter(listItems, getApplicationContext());
        recyclerView.setAdapter(adapter);
    }

}
