package com.teammcgannapps.insulincalc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;

public class Home extends AppCompatActivity {

    protected String[] saveFoods = {
            "Milk: 12g/cup",
            "Yogurt: 3.6g/100g",
            "Ice Cream: 24g/100g",
            "Apple: 14g/100g",
            "Banana: 23g/100g",
            "Orange: 12g/100g",
            "Strawberry: 8g/100g",
            "Bread: 49g/100g",
            "Rice: 28g/100g",
            "Cracker: 61g/100g",
            "Cereal: 68g/100g",
            "Beans: 63g/100g",
            "Peas: 14g/100g",
            "Lentils: 20g/100g",
            "Potato: 17g/100g",
            "Corn: 74g/100g",
            "Soda: 21g/cup",
            "Cookies: 58g/100g"};

    protected static String[] foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Font path
        String fontPath = "fonts/junegull.ttf";

        // text view label
        TextView txtGhost = (TextView) findViewById(R.id.title);

        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);

        // Applying font
        txtGhost.setTypeface(tf);

        foods = loadArray("food", getApplicationContext());

        if (foods.length == 0) {
            saveArray(saveFoods, "food", getApplicationContext());
            foods = saveFoods;
        }

    }
    public void startFood(View view)
    {
        Intent intent = new Intent(this, FoodListings.class);
        foods = loadArray("food", getApplicationContext());
        startActivity(intent);
    }
    public void startCalc(View view)
    {
        Intent intent = new Intent (this, Calculator.class);
        startActivity(intent);
    }
    public void startSettings(View view)
    {
        Intent intent = new Intent (this, Settings.class);
        startActivity(intent);
    }

    public boolean saveArray(String[] array, String arrayName, Context context) {
        SharedPreferences pref = context.getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(arrayName + "_size", array.length);
        Arrays.sort(array);
        for (int i=0; i<array.length;i++) {
            editor.putString(arrayName + "_" + i, array[i]);
        }
        return editor.commit();
    }

    public String[] loadArray(String arrayName, Context context) {
        SharedPreferences pref = context.getSharedPreferences("myPrefs",MODE_PRIVATE);
        int size = pref.getInt(arrayName + "_size", 0);
        String array[] = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = pref.getString(arrayName + "_" + i, null);
        }
        return array;
    }

    public String[] getFoods() {
        return foods;
    }

}