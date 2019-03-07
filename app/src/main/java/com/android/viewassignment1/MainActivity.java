package com.android.viewassignment1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtForgetPassword = findViewById(R.id.textForgetPassword);

       txtForgetPassword.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               txtForgetPassword.setTextColor(Color.BLUE);
           }
       });
        }
}
