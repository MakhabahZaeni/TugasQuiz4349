package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tambahkontak extends AppCompatActivity {
    EditText et1, et2;
    Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahkontak);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        btn2 = findViewById(R.id.btn2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = String.valueOf(et1.getText().toString());
                String hp = String.valueOf(et2.getText().toString());

                Bundle bundle = new Bundle();
                bundle.putString("et1",nama);
                bundle.putString("et2",hp);

                Intent i = new Intent(Tambahkontak.this, Activity_Utama.class);
                i.putExtras(bundle);
                startActivity(i);


            }
        });


    }

}