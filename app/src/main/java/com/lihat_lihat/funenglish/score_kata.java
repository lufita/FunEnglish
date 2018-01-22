package com.lihat_lihat.funenglish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class score_kata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_kata);

        //Kamus + Deskripsi:
        TextView hasil=(TextView)findViewById(R.id.hasil);
        TextView nilai=(TextView)findViewById(R.id.nilai);

        hasil.setText("True Answer : "+kata.benar+"\nFalse Answer : "+kata.salah);
        nilai.setText(""+kata.hasil);
    }
    public void ulangi(View view)
    {
        finish();
        Intent intent=new Intent(getApplicationContext(), kata.class);
        startActivity(intent);
    }
}
