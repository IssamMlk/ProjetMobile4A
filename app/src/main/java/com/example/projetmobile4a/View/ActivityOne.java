package com.example.projetmobile4a.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetmobile4a.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);//Style = le layout activity_one

        TextView title = (TextView) findViewById(R.id.ActivityTitle1);
        title.setText("ActivityOne");// On definit un Titre car il n'y a pas de texte

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.BottomNavigationBar);// Style = layout

        //Permet de surligner le bouton sur lequel on a cliqué et de savoir sur quelle activité, on se trouve
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem= menu.getItem(1);
        menuItem.setChecked(true);


        //La bottom bar est "à l'écoute d'une touche" et une fois appuyé, les case permettent de changer d'activity grace à Intent
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.ic_arrox:
                        Intent intent0 = new Intent(ActivityOne.this, MainActivity.class);
                        startActivity(intent0);
                        break;
                    case R.id.ic_dashboard:
                        break;
                    case R.id.ic_android:
                        Intent intent2 = new Intent(ActivityOne.this, ActivityTwo.class);
                        startActivity(intent2);
                        break;
                    case R.id.ic_photo:
                        Intent intent3 = new Intent(ActivityOne.this, ActivityThree.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });
    }
}
