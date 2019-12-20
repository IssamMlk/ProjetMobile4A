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
                        break;
                    case R.id.ic_android:
                        Intent intent1 = new Intent(ActivityTwo.this, ActivityLogo.class);
                        startActivity(intent1);
                        break;
                    case R.id.ic_photo:
                        break;
                }
                finish();
                return false;
            }
        });

    }
}
