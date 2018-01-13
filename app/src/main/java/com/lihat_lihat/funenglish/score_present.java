package com.lihat_lihat.funenglish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class score_present extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_present);

        //Kamus + Deskripsi:
        TextView hasil=(TextView)findViewById(R.id.hasil);
        TextView nilai=(TextView)findViewById(R.id.nilai);

        hasil.setText("True Answer : "+present_tense.benar+"\nFalse Answer : "+present_tense.salah);
        nilai.setText(""+present_tense.hasil);
    }

    public void ulangi(View view)
    {
        finish();
        Intent intent=new Intent(getApplicationContext(), present_tense.class);
        startActivity(intent);
    }
}
