package com.lihat_lihat.funenglish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //kamus:
    Button materi,kuis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Deskripsi:
        materi=(Button)findViewById(R.id.materi);
        kuis=(Button)findViewById(R.id.kuis);

    }

    //Fuction:
    public void kuis(View view)
    {
        Intent intent=new Intent(MainActivity.this, com.lihat_lihat.funenglish.kuis.class);
        startActivity(intent);
    }
}
