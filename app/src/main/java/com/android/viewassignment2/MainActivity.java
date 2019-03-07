package com.android.viewassignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.layout.simple_spinner_item;

public class MainActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {

    Button saveButton;
    Button clearButton;
    Spinner spin;
    EditText name,qualification;
    TextView nameResult;
    TextView ageResult;
    TextView qualificationResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         saveButton = (Button) findViewById(R.id.saveButton);
         clearButton = (Button) findViewById(R.id.clearButton);
         spin = (Spinner) findViewById(R.id.spinner);
         name = (EditText) findViewById(R.id.textName);
         qualification = (EditText) findViewById(R.id.textQualification);
         nameResult = (TextView) findViewById(R.id.nameResult);
         ageResult = (TextView) findViewById(R.id.ageResult);
         qualificationResult = (TextView) findViewById(R.id.qualificationResult);
        //Spinner click event
        spin.setOnItemSelectedListener(this);

        List<String> ageList = new ArrayList<String>();
        ageList.add("Select");
        ageList.add("23");
        ageList.add("25");
        ageList.add("30");
        ageList.add("35");
        ageList.add("40");

        //ArrayAdapter instance having the age list
        ArrayAdapter aa =  new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, ageList);

        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);


       saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.v( "index=" , "hello");
               String values =  name.getText().toString()+ " " + qualification.getText().toString()+
                      " " + spin.getSelectedItem();
               Log.v("welcome", values);
               name.requestFocus();
               nameResult.setText(name.getText().toString());
               ageResult.setText(spin.getSelectedItem().toString());
               qualificationResult.setText(qualification.getText().toString());

            }
        });


       clearButton.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {
               name.setText(" ");
               name.requestFocus();
               spin.setSelection(0);
               qualification.setText("");
               nameResult.setText(" ");
               ageResult.setText(" ");
               qualificationResult.setText(" ");

           }
       });

    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }
}