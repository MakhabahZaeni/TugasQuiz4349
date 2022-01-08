package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private SharedPrefManager sharedPrefManager;
    private EditText etUsername, etPassword;
    private Button btnLogin;
    private ProgressBar pbLogin;
    private ImageView ivLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPrefManager = new SharedPrefManager(this);
        if (sharedPrefManager.getIsLogin()) {
            startHomeUi();
        } else {
            etUsername = findViewById(R.id.etUsername);
            etPassword = findViewById(R.id.etPassword);
            btnLogin = findViewById(R.id.btnLogin);
            pbLogin = findViewById(R.id.pblogin);
            ivLogin = findViewById(R.id.ivLogin);


            Login();

        }
    }
    private void startHomeUi() {
        Intent i = new Intent(MainActivity.this, Activity_Utama.class);
        startActivity(i);
        finishAffinity();
    }

    private void Login() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();

                pbLogin.setVisibility(View.VISIBLE);
                ivLogin.setVisibility(View.GONE);

                if (username.isEmpty() || password.isEmpty()) {
                    pbLogin.setVisibility(View.VISIBLE);
                    ivLogin.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Username atau Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            String spUsername = SharedPrefManager.getUsername();
                            String spPassword = SharedPrefManager.getPassword();

                            Log.d("Username", "User" + username);
                            Log.d("Password", "pass" + password);

                            if (username.equals(spUsername) && password.equals(spPassword)) {
                                Intent i = new Intent(MainActivity.this, Activity_Utama.class);
                                sharedPrefManager.saveIsLogin(true);
                                finishAffinity();
                                startActivity(i);
                            } else {
                                pbLogin.setVisibility(View.GONE);
                                ivLogin.setVisibility(View.VISIBLE);
                                Toast.makeText(MainActivity.this, "Username Atau Password salah", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, 300);
                }
            }
        });

    }
}