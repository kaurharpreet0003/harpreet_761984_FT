package com.example.harpreet_761984_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class register extends AppCompatActivity {

    public  static final String EXTRA_NAME = "com.example.harpreet_761984_ft.EXTRA_NAME";
    public  static final String EXTRA_MAIL = "com.example.harpreet_761984_ft.EXTRA_MAIL";
    public  static final String EXTRA_PHONE = "com.example.harpreet_761984_ft.EXTRA_PHONE";


    EditText et_name;
    EditText et_mail;
    EditText et_phone;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_name = findViewById(R.id.name);
        et_mail = findViewById(R.id.email);
        et_phone = findViewById(R.id.phone);
        save = findViewById(R.id.save_btn);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!et_name.getText().toString().isEmpty() && !et_mail.getText().toString().isEmpty() && !et_phone.getText().toString().isEmpty()) {

                    String n = et_name.getText().toString();
                    String m = et_mail.getText().toString();
                    int p = Integer.parseInt(et_phone.getText().toString());

                    Intent i = new Intent(register.this, save.class);

                    i.putExtra(EXTRA_NAME, n);
                    i.putExtra(Intent.EXTRA_EMAIL, m);
                    i.putExtra(EXTRA_PHONE, p);

                    startActivity(i);
                } else {
                    Toast.makeText(register.this, "You should fill all the fields", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
