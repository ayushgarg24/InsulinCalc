package com.teammcgannapps.insulincalc;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import static com.teammcgannapps.insulincalc.Home.userSettings;

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

        EditText e1 = (EditText)findViewById(R.id.editText1);
        EditText e2 = (EditText)findViewById(R.id.editText2);
        EditText e3 = (EditText)findViewById(R.id.editText3);
        e1.setText(userSettings[0]);
        e2.setText(userSettings[1]);
        e3.setText(userSettings[2]);


    }

    public void confirmSettings(View view) {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("userSettings_size", 3);
        EditText e1 = (EditText) findViewById(R.id.editText1);
        EditText e2 = (EditText) findViewById(R.id.editText2);
        EditText e3 = (EditText) findViewById(R.id.editText3);
        String[] values = {e1.getText().toString(), e2.getText().toString(), e3.getText().toString()};
        for (int i=0; i < 3;i++) {
            editor.putString("userSettings_" + i, values[i]);
        }
        editor.commit();

        Context context = getApplicationContext();
        CharSequence text = "Settings Saved";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
