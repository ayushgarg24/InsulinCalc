package com.teammcgannapps.insulincalc;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class FoodListings extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_listings);

        // Font path
        String fontPath = "fonts/junegull.ttf";

        // text view label
        TextView txtGhost = (TextView) findViewById(R.id.food_title);

        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);

        // Applying font
        txtGhost.setTypeface(tf);
//--------------------------------------------------------------------------------------------------
        // Font path 2
        String fontPath2 = "fonts/primer.ttf";

        // text view label 2
        TextView txtGhost2 = (TextView) findViewById(R.id.foods);

        // Loading Font Face 2
        Typeface tf2 = Typeface.createFromAsset(getAssets(), fontPath2);

        // Applying font 2
        txtGhost2.setTypeface(tf2);

        String foodList = "";

        for (int i = 0; i < Home.foods.length - 1; i++) {
            foodList = foodList + Home.foods[i] + "\n";
        }
        foodList = foodList.substring(0, foodList.length() - 2);

        TextView t = (TextView) findViewById(R.id.foods);
        t.setText(foodList);
    }

}
