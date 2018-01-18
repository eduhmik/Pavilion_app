package com.example.eduh_mik.pavillion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.eduh_mik.pavillion.BackgroundWorker;
import com.example.eduh_mik.pavillion.R;

public class LoginActivity extends AppCompatActivity {
  EditText UsernameEt, PasswordEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        UsernameEt = (EditText) findViewById(R.id.etUsername);
        PasswordEt = (EditText) findViewById(R.id.etPassword);

    }

    public void OnLogin(View view) {
      String username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();
        String type = "Login";


        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);
    }
    public void OpenReg(View view) {
        startActivity(new Intent(this,register.class));
    }
}

