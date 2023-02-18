package com.example.videogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class GameOver extends AppCompatActivity {
    private TextView disscore;
    private String score;

    private Button again;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        score=getIntent().getExtras().get("score").toString();
        disscore=(TextView)findViewById(R.id.dscore);

        again=(Button)findViewById(R.id.tr);
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(GameOver.this, Fish.class);
                startActivity(a);
            }
        });

        disscore.setText("score"+score);

    }
}
