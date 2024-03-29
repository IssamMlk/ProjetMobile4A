package com.example.projetmobile4a.View;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.projetmobile4a.Model.MyList;
import com.example.projetmobile4a.R;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;


public class DetailActivity extends AppCompatActivity {


     @Override
    protected void onCreate(Bundle savedInstanceState){
         super.onCreate(savedInstanceState);
         setContentView(R.layout.detail_activity);
         final Toolbar toolbar = (Toolbar) findViewById(R.id.MyToolbar);
         setSupportActionBar(toolbar);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

         setupViewPager();

     }

    private void setupViewPager(){

        String JSONkey = getIntent().getStringExtra("JSONkey");
        Gson gson = new Gson();
        MyList JSONlist = gson.fromJson(JSONkey, MyList.class);

        ViewPager myViewPager = findViewById(R.id.ViewPagerContainer); // Ce que contient la page
        FragAdapter Fadapter = new FragAdapter(getSupportFragmentManager());
            for(int i=0;i<JSONlist.getTransformation().size();i++) {
                Fadapter.addFragment(new Fragment1(i), getIntent().getStringExtra("Nom") + " " + JSONlist.getTransformation().get(i).getStade());
            }
        myViewPager.setAdapter(Fadapter);
        TabLayout tabLayout = findViewById(R.id.TabFragment);
        tabLayout.setupWithViewPager(myViewPager);
    }


}
