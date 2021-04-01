package com.example.photoapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.photoapp.R;
import com.squareup.picasso.Picasso;

public class ViewPhotoActivity extends AppCompatActivity {
    ImageView imageView;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_photo);
        imageView = findViewById(R.id.viewPhoto); //intializing imageView

        //getting url using intent from PhotolistActivity
        Intent i = getIntent();
        url = i.getStringExtra("url");

        //uploading image in imageView
        Picasso.get().load(url).into(imageView);
    }
}