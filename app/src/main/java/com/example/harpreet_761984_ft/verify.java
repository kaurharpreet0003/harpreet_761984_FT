package com.example.harpreet_761984_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class verify extends AppCompatActivity {

    CheckBox check_Box;
    Button verify;
    GridView gridView;
    ImageView refresh_image;
    int[] imageArray;
    ArrayList<Integer> images_aList;
    ArrayList<Integer> match_aList;
    ArrayList<Integer> check_aList;

    int t = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        check_Box = findViewById(R.id.checkBox);
        refresh_image = findViewById(R.id.refresh);
        gridView = findViewById(R.id.grid_view);
        verify = findViewById(R.id.btnVerify);
        imageArray = new int[]{R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9};

        check_aList = new ArrayList<>();
        match_aList = new ArrayList<>();

        images_aList = new ArrayList<>();
        images_aList.add(R.drawable.img1);
        images_aList.add(R.drawable.img2);
        images_aList.add(R.drawable.img3);
        images_aList.add(R.drawable.img4);

        match_aList.add(2131099746);
        match_aList.add(2131099747);
        match_aList.add(2131099748);
        match_aList.add(2131099749);

        shuffle();

        final IconAdapter iconAdapter = new IconAdapter(this, imageArray);
        gridView.setAdapter(iconAdapter);


        refresh_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shuffle();
                iconAdapter.notifyDataSetChanged();
            }
        });


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ImageView imageView = (ImageView) view.findViewById(R.id.images);
                imageView.setImageResource(R.drawable.checked);

                imageView.setBackgroundResource(R.drawable.img1);

                imageView.animate().alpha(.5f);

                check_aList.add((Integer) iconAdapter.getItem(position));
                //Toast.makeText(verify.this, "" + check_aList, Toast.LENGTH_SHORT).show();
                Collections.sort(match_aList);
                Collections.sort(check_aList);


                if (match_aList.equals(check_aList))   {
                    t = 1;
                    Toast.makeText(verify.this, "verified", Toast.LENGTH_SHORT).show();
                }
            }
        });
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t == 0) {
                    secDialog();
//                    Intent intent = new Intent(verify.this, MainActivity.class);
//                    startActivity(intent);

                } else if (t > 0 && check_Box.isChecked() ){

                    open_dialog();
                    Intent intent = new Intent(verify.this, MainActivity.class);
                    startActivity(intent);

                }
            }
        });

    }

    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < imageArray.length; i++) {
            int v = random.nextInt(i + 1);
            int t = imageArray[v];
            imageArray[v] = imageArray[i];
            imageArray[i] = t;
        }

    }


    public void open_dialog(){
        dialog dg = new dialog();
        //dialog.show(getSupportFragmentManager(),"dialog");
        dg.show(getSupportFragmentManager(), "dg");

    }

    public void secDialog(){
        second_dialog sd = new second_dialog();
        sd.show(getSupportFragmentManager(), "sd");
    }

}

