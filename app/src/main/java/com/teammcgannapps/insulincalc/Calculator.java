package com.teammcgannapps.insulincalc;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static com.teammcgannapps.insulincalc.Home.foods;

public class Calculator extends AppCompatActivity {

    protected LinearLayout layout;
    protected String message;

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

    public void startResult(View view)
    {
        Spinner dropdown1 = (Spinner)findViewById(R.id.spinner1);
        EditText e1 = (EditText)findViewById(R.id.value1);

        Spinner dropdown2 = (Spinner)findViewById(R.id.spinner2);
        EditText e2 = (EditText)findViewById(R.id.value2);

        Spinner dropdown3 = (Spinner)findViewById(R.id.spinner3);
        EditText e3 = (EditText)findViewById(R.id.value3);

        Spinner dropdown4 = (Spinner)findViewById(R.id.spinner4);
        EditText e4 = (EditText)findViewById(R.id.value4);

        Spinner dropdown5 = (Spinner)findViewById(R.id.spinner5);
        EditText e5 = (EditText)findViewById(R.id.value5);

        final int[] dropdowns = new int[5];
        int[] values = new int[5];

        values[0] = Integer.parseInt(e1.getText().toString());
        values[1] = Integer.parseInt(e2.getText().toString());
        values[2] = Integer.parseInt(e3.getText().toString());
        values[3] = Integer.parseInt(e4.getText().toString());
        values[4] = Integer.parseInt(e5.getText().toString());

        dropdown1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dropdowns[0] = Integer.parseInt((parent.getSelectedItem().toString()).split("g/")[0].split(": ")[1]);
            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dropdown2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dropdowns[1] = Integer.parseInt((parent.getSelectedItem().toString()).split("g/")[0].split(": ")[1]);
            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dropdown3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dropdowns[2] = Integer.parseInt((parent.getSelectedItem().toString()).split("g/")[0].split(": ")[1]);
            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dropdown4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dropdowns[3] = Integer.parseInt((parent.getSelectedItem().toString()).split("g/")[0].split(": ")[1]);
            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dropdown5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dropdowns[4] = Integer.parseInt((parent.getSelectedItem().toString()).split("g/")[0].split(": ")[1]);
            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        double dosage = 0;
        for (int i = 0; i < 5; i++) {
            dosage += dropdowns[i] * values[i] / 10000;
        }

        message = Integer.toString((int)dosage);
        Intent intent = new Intent (this, Result.class);
        startActivity(intent);
    }


}
