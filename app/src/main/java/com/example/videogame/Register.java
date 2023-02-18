package com.example.videogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final mydata db =new mydata(this);

        final EditText name=(EditText)findViewById(R.id.name);
        EditText mail=(EditText)findViewById(R.id.mail);
        final EditText password1=(EditText)findViewById(R.id.password1);
        final EditText password=(EditText)findViewById(R.id.password);
        Button signin=(Button) findViewById(R.id.signin);


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = name.getText().toString().trim();
                String pwd = password1.getText().toString().trim();
                String cnf_pwd = password.getText().toString().trim();

                if(pwd.equals(cnf_pwd)) {
                    long val = db.addUser(user, pwd);

                    if (user.isEmpty() && pwd.isEmpty()) {

                        Toast.makeText(Register.this, "Please Complete Your Register ", Toast.LENGTH_SHORT).show();
                    } else {
                        if (val > 0) {
                            Toast.makeText(Register.this, "You have registered", Toast.LENGTH_SHORT).show();
                            Intent moveToLogin = new Intent(Register.this, MainActivity.class);
                            startActivity(moveToLogin);
                        } else {
                            Toast.makeText(Register.this, "Registeration Error", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
                else{
                    Toast.makeText(Register.this,"Password is not matching",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
