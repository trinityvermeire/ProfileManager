package com.example.profileview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ActivityProfile extends AppCompatActivity {

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_profile2);
            }

            public void SetTeamIcon(View view) {
                Intent returnIntent = new Intent();
                ImageView selectedImage = (ImageView) view;
                returnIntent.putExtra("imageID", selectedImage.getId());
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        }