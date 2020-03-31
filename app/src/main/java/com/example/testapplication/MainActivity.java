package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText txtEmail;
    public EditText txtPassword;
    public Button btnLogin;
    private TextView setText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        setText = findViewById(R.id.setText);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();

                String userName = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();
                if (userName.equals("admin@123") && password.equals("s3cr3t"))
                {
                    System.out.println("If");
                    Log.d("NAME", password);
                    setText.setText("Login Successful");
                    setText.setTextColor(getResources().getColor(R.color.colorGreen));
                }else {
                    System.out.println("Else");
                    setText.setText("Login Failed");
                    setText.setTextColor(getResources().getColor(R.color.colorRed));
                }

            }
        });

    }
}
