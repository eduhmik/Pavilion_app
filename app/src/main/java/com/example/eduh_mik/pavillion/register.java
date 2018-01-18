package com.example.eduh_mik.pavillion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.eduh_mik.pavillion.R;

public class register extends AppCompatActivity {
    EditText FirstName, Lastname, email, phone, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        FirstName = (EditText) findViewById(R.id.etFirstname);
        Lastname = (EditText) findViewById(R.id.etLastname);
        email = (EditText) findViewById(R.id.etEmail);
        phone = (EditText) findViewById(R.id.etPhone);
        password = (EditText) findViewById(R.id.etPassword);

    }

    public  void OnSub (View view) {
        String str_FirstName = FirstName.getText().toString();
        String str_Lastname = Lastname.getText().toString();
        String str_email = email.getText().toString();
        String str_phone = phone.getText().toString();
        String str_password = password.getText().toString();

        String type = "register";


        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_FirstName, str_Lastname, str_email, str_phone, str_password);
    }
}
