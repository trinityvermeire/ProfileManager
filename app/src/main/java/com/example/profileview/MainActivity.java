package com.example.profileview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.profileview.ActivityProfile;
import com.example.profileview.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnOpenInGoogleMaps(View view) {

        EditText teamAddress = (EditText) findViewById(R.id.teamAddressField);
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q=" + teamAddress.getText());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        startActivity(mapIntent);
    }

    public void OnSetAvatarButton(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityProfile.class);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) return;

        ImageView avatarImage = (ImageView) findViewById(R.id.logoImage);

        String drawableName = "ic_logo_00";
        switch (data.getIntExtra("imageID", R.id.imageView10)) {
            case R.id.imageView10:
                drawableName = "cutedog";
                break;
            case R.id.imageView11:
                drawableName = "cat";
                break;
            case R.id.imageView12:
                drawableName = "ffy";
                break;
            case R.id.imageView20:
                drawableName = "gg";
                break;
            case R.id.imageView21:
                drawableName = "hh";
                break;
            case R.id.imageView22:
                drawableName = "ss";
                break;
            default:
                drawableName = "rf";
                break;
        }
        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
        avatarImage.setImageResource(resID);
    }
}