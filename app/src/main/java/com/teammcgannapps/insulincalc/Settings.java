package com.teammcgannapps.insulincalc;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        // Font path
        String fontPath = "fonts/junegull.ttf";

        // text view label
        TextView txtGhost = (TextView) findViewById(R.id.title);

        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);

        // Applying font
        txtGhost.setTypeface(tf);
        //------------------------------------------------------------------------------------------

        // Font path 2
        String fontPath2 = "fonts/libel-suit-rg.ttf";

        // text view label 2
        TextView txtGhost2 = (TextView) findViewById(R.id.allSettings);

        // Loading Font Face 2
        Typeface tf2 = Typeface.createFromAsset(getAssets(), fontPath2);

        // Applying font 2
        txtGhost2.setTypeface(tf2);
        //------------------------------------------------------------------------------------------
        TextView txtGhost3 = (TextView) findViewById(R.id.carbs);


        txtGhost3.setTypeface(tf2);
        //------------------------------------------------------------------------------------------
        TextView txtGhost4 = (TextView) findViewById(R.id.mLPer);


        txtGhost4.setTypeface(tf2);
        //------------------------------------------------------------------------------------------
        TextView txtGhost5 = (TextView) findViewById(R.id.correction);


        txtGhost5.setTypeface(tf2);
        //------------------------------------------------------------------------------------------
        TextView txtGhost6 = (TextView) findViewById(R.id.unit);


        txtGhost6.setTypeface(tf2);
        //------------------------------------------------------------------------------------------
        TextView txtGhost7 = (TextView) findViewById(R.id.over);


        txtGhost7.setTypeface(tf2);


    }

}
