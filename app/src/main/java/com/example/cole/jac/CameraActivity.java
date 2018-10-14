package com.example.cole.jac;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.io.FileNotFoundException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.provider.MediaStore;

public class CameraActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);


        wireWidgets();
        setUpHomeScreen();
    }




    private void wireWidgets(){

    }

    private void setUpHomeScreen(){

    }
}
