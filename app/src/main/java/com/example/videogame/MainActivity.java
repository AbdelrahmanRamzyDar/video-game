package com.example.videogame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomnav);

        final TextView fishh=(TextView)findViewById(R.id.textView);







        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment=null;


                switch (menuItem.getItemId()){

                    case R.id.home:

                        break;
                    case R.id.favourite:
                        Intent m=new Intent(MainActivity.this,favorite.class);
                        startActivity(m);
                    break;
                    case R.id.profile:
                    Intent n=new Intent(MainActivity.this,profile.class);
                    startActivity(n);
                    break;



                }


                return true;
            }
        });
































fishh.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent bb=new Intent(MainActivity.this,SplashFish.class);
        startActivity(bb);
    }
});














    }}