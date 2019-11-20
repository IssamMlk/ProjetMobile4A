package com.example.projetmobile4a.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetmobile4a.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.BottomNavigationBar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem= menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.ic_arrox:
                        Intent intent0 = new Intent(ActivityTwo.this, MainActivity.class);
                        startActivity(intent0);
                        break;
                    case R.id.ic_dashboard:
                        Intent intent1 = new Intent(ActivityTwo.this, ActivityOne.class);
                        startActivity(intent1);
                        break;
                    case R.id.ic_android:
                        break;
                    case R.id.ic_photo:
                        Intent intent3 = new Intent(ActivityTwo.this, ActivityThree.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });

    }
}
