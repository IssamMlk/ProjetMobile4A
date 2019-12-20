package com.example.projetmobile4a.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.projetmobile4a.Controller.Controller;
import com.example.projetmobile4a.Model.MyList;
import com.example.projetmobile4a.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    String key = "myCacheList";
    private ImageButton Logo;
    private Controller controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecyclerView);
        toolbar=(Toolbar) findViewById(R.id.MyToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



        Logo = (ImageButton) findViewById(R.id.LogoBouton);
        Logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogoActivity();
            }
        });

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
                    case R.id.ic_android:
                        Intent intent1 = new Intent(MainActivity.this, ActivityOne.class);
                        startActivity(intent1);
                        break;
                    case R.id.ic_photo:
                        Intent intent2 = new Intent(MainActivity.this, ActivityTwo.class);
                        startActivity(intent2);
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

    public void openLogoActivity(){
        Intent LogoIntent = new Intent(this, ActivityLogo.class);
        startActivity(LogoIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Details:
                Intent ActivityDetail = new Intent(this, ActivityDetail.class);
                startActivity(ActivityDetail);
                break;
            case R.id.Dev:
                Intent ActivityDev = new Intent(this, ActivityDev.class);
                startActivity(ActivityDev);
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
