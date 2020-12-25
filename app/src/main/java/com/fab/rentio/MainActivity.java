package com.fab.rentio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText Email, Password;
    Button Login;
    TextView Fpassword, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email=(EditText)findViewById(R.id.lt_email);
        Password=(EditText)findViewById(R.id.lt_pass);
        Fpassword=(TextView) findViewById(R.id.lt_forgot);
        signup=(TextView)findViewById(R.id.lt_signup);
        Login=(Button)findViewById(R.id.btn_login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=Email.getText().toString();
                String pass=Password.getText().toString();

                if(email.isEmpty())
                {
                    Email.setError("Please enter your email!");
                    Email.requestFocus();
                    return;
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    Email.setError("Please enter a valid email id!");
                    Email.requestFocus();
                    return;
                }

                if(pass.isEmpty())
                {
                    Password.setError("Please enter your Password!");
                    Password.requestFocus();
                    return;
                }
            }
        });

        Fpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MainActivity.this,signup.class);
                startActivity(intent);
            }
        });
    }
}