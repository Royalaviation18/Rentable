package com.fab.rentio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class signup extends AppCompatActivity {

     EditText Name, Email, Phone, Pass, Aadhaarno, DOB;
     Button signup;
     DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Name=(EditText)findViewById(R.id.et_name);
        Email=(EditText)findViewById(R.id.et_email);
        Phone=(EditText)findViewById(R.id.et_phone);
        Aadhaarno=(EditText)findViewById(R.id.et_aadhaarno);
        Pass=(EditText)findViewById(R.id.et_pass);
        DOB=(EditText)findViewById(R.id.et_date);
        signup=(Button)findViewById(R.id.btn_signup);

        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);


        DOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             DatePickerDialog  datePickerDialog=new DatePickerDialog(signup.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {

                        month=month+1;
                        String date=day+"/"+month+"/"+year;
                        DOB.setText(date);

                    }
                },year,month,day);
              datePickerDialog.show();
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=Name.getText().toString();
                String email=Email.getText().toString().trim();
                String phone=Phone.getText().toString();
                String dob= DOB.getText().toString().trim();
                String aadhar=Aadhaarno.getText().toString().trim();
                String pass=Pass.getText().toString();



                if(name.isEmpty())
                {
                    Name.setError("Please Enter Your Name");
                    Name.requestFocus();
                    return;
                }

                if(email.isEmpty())
                {
                    Email.setError("Please Enter a Email ID!");
                    Email.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    Email.setError("Please Provide a Valid Email ID!");
                    Email.requestFocus();
                    return;
                }
                if(phone.isEmpty())
                {
                    Phone.setError("Please Enter the Phone Number!");
                    Phone.requestFocus();
                    return;
                }
                if(phone.length() != 10)
                {
                    Phone.setError("Phone Number should be of 10 digits only");
                    Phone.requestFocus();
                    return;
                }
                if(dob.isEmpty())
                {
                    DOB.setError("Please Enter Your Date of Birth!");
                    DOB.requestFocus();
                    return;
                }

                if(aadhar.isEmpty())
                {
                    Aadhaarno.setError("Please Enter the Aadhaar Number!");
                    Aadhaarno.requestFocus();
                    return;
                }
                if(aadhar.length()!=12)
                {
                    Aadhaarno.setError("Aadhar No should be of 12 digits only!");
                    Aadhaarno.requestFocus();
                    return;
                }
                if(pass.isEmpty())
                {
                    Pass.setError("Please Enter the Password!");
                    Pass.requestFocus();
                    return;
                }
                if(pass.length()<6)
                {
                    Pass.setError("Password should atleast contain 6 characters");
                    Pass.requestFocus();
                    return;
                }






            }
        });
    }
}