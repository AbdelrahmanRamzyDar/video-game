package com.example.videogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class profile extends AppCompatActivity {
    mydata register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        register= new mydata(this);
        final EditText name=(EditText)findViewById(R.id.name);
        final EditText password1=(EditText)findViewById(R.id.password1);
        Button sign=(Button) findViewById(R.id.sign);
        Button login=(Button) findViewById(R.id.login);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m =new Intent(profile.this,Register.class);
                startActivity(m);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = name.getText().toString().trim();
                String pwd = password1.getText().toString().trim();
                Boolean res = register.checkUser(user, pwd);


                if(user.isEmpty()&&pwd.isEmpty()){

                    Toast.makeText(profile.this,"Please Complete Your Login ",Toast.LENGTH_SHORT).show();
                }
                else {
                    if (res == true) {
                        Intent HomePage = new Intent(profile.this, MainActivity.class);
                        startActivity(HomePage);
                    } else {
                        Toast.makeText(profile.this, "Login Error", Toast.LENGTH_SHORT).show();
                    }
                }
            }  });



    }
}
