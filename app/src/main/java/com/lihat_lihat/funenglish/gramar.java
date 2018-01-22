package com.lihat_lihat.funenglish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class gramar extends AppCompatActivity {
    Button kata,read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gramar);
        kata=(Button) findViewById(R.id.kata);
        read=(Button) findViewById(R.id.read);

        MobileAds.initialize(this,"ca-app-pub-4022976492067687~8839315183");
        AdView adView=(AdView)findViewById(R.id.Adview);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }
   public void bacaan(View view)
   {
       Intent intent=new Intent(gramar.this,reading.class);
       startActivity(intent);
   }
   public void kata(View view)
   {
       Intent intent=new Intent(gramar.this, com.lihat_lihat.funenglish.kata.class);
       startActivity(intent);
   }
}
