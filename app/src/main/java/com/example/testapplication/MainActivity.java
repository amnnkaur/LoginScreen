package com.example.testapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public EditText txtEmail;
    public EditText txtPassword;
    public Button btnLogin;
    private Switch swRememberMe;
  //  private TextView setText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intials();

        btnLogin.setOnClickListener(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String userName = txtEmail.getText().toString();
                final String password = txtPassword.getText().toString();

                if (userName.equals("admin@123") && password.equals("s3cr3t"))
                {
                    Log.d("NAME", password);
                    Toast.makeText(MainActivity.this,"Success!",Toast.LENGTH_SHORT).show();
                    Intent homeIntent = new Intent(MainActivity.this,SecondActivity.class);
                    homeIntent.putExtra("Name","Aman");
                    homeIntent.putExtra("Age",23);
                    startActivity(homeIntent);
                    swRememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (isChecked == true){
                                txtEmail.setText(userName);
                                txtPassword.setText(password);
                            }
                        }
                    });
                }else {

                    loginAlert();

                }

            }
        });
    }

    // override method of View.onClickListner interface
    @Override
    public void onClick(View v) {
//        Toast.makeText(LoginActivity.this,"Done" + HomeActivity.class,Toast.LENGTH_SHORT).show();
//        Intent homeIntent = new Intent(LoginActivity.this,HomeActivity.class); // jump from login to home screen // HomeActivity.class = "com.lambton.day1_sample.HomeActivity"
//        startActivity(homeIntent);
//       // finish(); // this will popOut previous screen from stack
    }

    private void intials () {
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        swRememberMe = findViewById(R.id.swRememberMe);
        ActionBar loginBar = getSupportActionBar();
        loginBar.hide();

    }
    public void loginAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error");
        builder.setIcon(R.drawable.ic_launcher_foreground);
        builder.setMessage("User ID Password Invalid");
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Positive",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Negative",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.setNeutralButton("Ignore", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Neutral",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        AlertDialog homeAlert = builder.create();
        homeAlert.show();
    }
}