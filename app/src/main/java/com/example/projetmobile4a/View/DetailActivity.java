package com.example.projetmobile4a.View;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.example.projetmobile4a.R;
import com.google.android.material.tabs.TabLayout;


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

        ViewPager myViewPager = findViewById(R.id.ViewPagerContainer); // Ce que contient la page
        FragAdapter Fadapter = new FragAdapter(getSupportFragmentManager());
        Fadapter.addFragment(new Fragment1(),getIntent().getStringExtra("Nom"));
        Fadapter.addFragment(new Fragment2(),getIntent().getStringExtra("Nom"));
        Fadapter.addFragment(new Fragment3(),getIntent().getStringExtra("Nom"));
        myViewPager.setAdapter(Fadapter);
        TabLayout tabLayout = findViewById(R.id.TabFragment);
        tabLayout.setupWithViewPager(myViewPager);
    }


}
