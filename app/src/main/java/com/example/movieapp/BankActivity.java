package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.concurrent.ExecutionException;

public class BankActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private BankListAdapter mAdapter;
    String idGhe;
    String idLich;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);
        Intent in = getIntent();
        idGhe = in.getStringExtra("IDGHE");
        idLich = in.getStringExtra("IDLICH");

        LinkedList<String> lst = new LinkedList<String>();
        lst.add("Ngân hàng Á châu");
        lst.add("Ocean Bank");
        lst.add("HDBank");
        lst.add("Ngân hàng Quốc tế");
        lst.add("Eximbank");
        lst.add("Sacombank");
        lst.add("Đông Á Bank");

        mRecyclerView = findViewById(R.id.recycler_bank);
        mAdapter = new BankListAdapter(this, lst);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void btnXacNhan(View view) {
        Ve ve = new Ve(Integer.parseInt(idLich), 1, Integer.parseInt(idGhe));
        try {
            String jsonString = new DatVeAPIGetting(this).execute(ve).get();
            Toast.makeText(this, ""+jsonString, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void btnHuy(View view) {
        finish();
    }
}