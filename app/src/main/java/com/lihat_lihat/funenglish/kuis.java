package com.lihat_lihat.funenglish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class kuis extends AppCompatActivity {

    //Kamus:
    Button grammer,kalimat,gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis);
        //Diskripsi:
        grammer=(Button)findViewById(R.id.grammer);
        kalimat=(Button)findViewById(R.id.kalimat);
        gambar=(Button)findViewById(R.id.gambar);
    }
    //Function:
    public void tense(View view)
    {
        Intent intent=new Intent(kuis.this, com.lihat_lihat.funenglish.kalimat.class);
        startActivity(intent);
    }
    public void gramar(View view)
    {
        Intent intent=new Intent(kuis.this, com.lihat_lihat.funenglish.gramar.class);
        startActivity(intent);
    }
    public void gambar(View view)
    {
        Intent intent=new Intent(kuis.this,gambar.class);
        startActivity(intent);
    }
}
