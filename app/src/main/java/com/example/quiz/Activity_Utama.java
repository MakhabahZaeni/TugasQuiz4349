package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_Utama extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);


        final SharedPrefManager sharedPrefManager = new SharedPrefManager(this);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activity_Utama.this, MainActivity.class);
                sharedPrefManager.saveIsLogin(false);
                finishAffinity();
                startActivity(i);

            }
        });




    }
    public void kontak(View view) {
        Intent intent = new Intent(Activity_Utama.this, Kontak.class);
        startActivity(intent);
    }
}