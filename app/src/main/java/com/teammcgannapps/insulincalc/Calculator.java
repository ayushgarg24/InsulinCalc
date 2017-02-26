package com.teammcgannapps.insulincalc;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import static com.teammcgannapps.insulincalc.Home.foods;

public class Calculator extends AppCompatActivity {

    protected LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        // Font path
        String fontPath = "fonts/junegull.ttf";

        // text view label
        TextView txtGhost = (TextView) findViewById(R.id.title);

        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);

        // Applying font
        txtGhost.setTypeface(tf);

        layout = (LinearLayout)findViewById(R.id.content_calculator);
        Spinner dropdown1 = (Spinner)findViewById(R.id.spinner1);
        String[] food = foods;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, food);
        dropdown1.setAdapter(adapter);

        Spinner dropdown2 = (Spinner)findViewById(R.id.spinner2);
        dropdown2.setAdapter(adapter);
        Spinner dropdown3 = (Spinner)findViewById(R.id.spinner3);
        dropdown3.setAdapter(adapter);
        Spinner dropdown4 = (Spinner)findViewById(R.id.spinner4);
        dropdown4.setAdapter(adapter);
        Spinner dropdown5 = (Spinner)findViewById(R.id.spinner5);
        dropdown5.setAdapter(adapter);
    }



}
