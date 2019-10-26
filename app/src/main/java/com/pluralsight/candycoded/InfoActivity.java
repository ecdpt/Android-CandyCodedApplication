package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);


    }

    //
    // Task 2 - Launch the Google Maps Activity
    //
    public void createMapIntent(View view){
        Uri addressToMap = Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, addressToMap);
        mapIntent.setPackage("com.google.android.apps.maps");

        if(mapIntent.resolveActivity(getPackageManager()) != null){
            startActivity(mapIntent);
        }else{
            Toast.makeText(this, getString(R.string.map_opening_error),
                    Toast.LENGTH_LONG).show();
        }
    }

    // ***
    // TODO - Task 3 - Launch the Phone Activity
    // ***

}
