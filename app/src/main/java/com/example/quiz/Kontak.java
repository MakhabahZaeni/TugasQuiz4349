package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Kontak extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    ArrayList<ItemModel> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontak);

        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);

        recylerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        data = new ArrayList<>();
        for (int i = 0; i < Myitem.Headline.length; i++){
            data.add(new ItemModel(
                    Myitem.Headline[i],
                    Myitem.Subheadline[i],
                    Myitem.iconList[i]));

        }

        recyclerViewAdapter = new AdapterRv(data);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    public void plus(View view) {
        Intent intent = new Intent(Kontak.this, Tambahkontak.class);
        startActivity(intent);
    }
}