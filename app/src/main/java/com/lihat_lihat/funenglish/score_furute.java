package com.lihat_lihat.funenglish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class score_furute extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_furute);

        //Kamus + Deskripsi:
        TextView hasil=(TextView)findViewById(R.id.hasil);
        TextView nilai=(TextView)findViewById(R.id.nilai);

        hasil.setText("True Answer : "+future_tense.benar+"\nFalse Answer : "+future_tense.salah);
        nilai.setText(""+future_tense.hasil);
    }
    public void ulangi(View view)
    {
        finish();
        Intent intent=new Intent(getApplicationContext(), future_tense.class);
        startActivity(intent);
    }
}
