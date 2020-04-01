package com.example.testapplication;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private ImageView homeImage;
    private Switch homeSwitch;
    private TextView welcomeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        welcomeText = findViewById(R.id.textView);
        //homeSwitch.isChecked();// Get status of switch
        ActionBar homeBar = getSupportActionBar();
        homeBar.setTitle("Home");
        homeBar.setSubtitle("Home Screen");
        homeImage.setImageResource(R.drawable.ic_launcher_foreground); // set image dynamically
        homeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    Toast.makeText(SecondActivity.this,"On!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SecondActivity.this,"Off!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Intent intent = getIntent();
        if (intent.hasExtra("Name")) {
            String name = intent.getStringExtra("Name");
            int age = intent.getIntExtra("Age",0);
            welcomeText.setText("Welcome, " + name);
        }
    }

}
