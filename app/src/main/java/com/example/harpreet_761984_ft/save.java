package com.example.harpreet_761984_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class save extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        Intent intent = getIntent();
        String name = intent.getStringExtra(register.EXTRA_NAME);
        String email = intent.getStringExtra(register.EXTRA_MAIL);
        int phone = intent.getIntExtra(register.EXTRA_PHONE, 0);

        TextView n = (TextView) findViewById(R.id.name);
        TextView e = (TextView) findViewById(R.id.email);
        TextView p = (TextView) findViewById(R.id.phone);

        n.setText(name);
        e.setText(email);
        p.setText("" + phone);
    }
}
