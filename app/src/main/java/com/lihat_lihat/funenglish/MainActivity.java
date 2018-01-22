package com.lihat_lihat.funenglish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    //kamus:
    Button materi,kuis;
    //Iklan
    AdView adView;
    AdRequest adRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Deskripsi:
        materi=(Button)findViewById(R.id.materi);
        kuis=(Button)findViewById(R.id.kuis);

        //Iklan
        MobileAds.initialize(this,"ca-app-pub-4022976492067687~8839315183");
        adView=(AdView)findViewById(R.id.Adview);
        adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        ///Ads(); ///masih bermasalah

    }

    //Fuction:
    public void materi(View view)
    {
        Intent intent=new Intent(MainActivity.this, com.lihat_lihat.funenglish.materi.class);
        startActivity(intent);
    }
    public void kuis(View view)
    {
        Intent intent=new Intent(MainActivity.this, com.lihat_lihat.funenglish.kuis.class);
        startActivity(intent);
    }
    public void tentang(View view)
    {
        Intent intent=new Intent(MainActivity.this, com.lihat_lihat.funenglish.tentang.class);
        startActivity(intent);
    }
}
