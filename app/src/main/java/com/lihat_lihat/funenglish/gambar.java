package com.lihat_lihat.funenglish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class gambar extends AppCompatActivity {

    //Kamus:
    TextView quis;
    RadioGroup radiogroup;
    RadioButton pilihA, pilihB, pilihC, pilihD;
    int nomor = 0;
    public static int hasil, benar, salah;

    String[] pertanyaan = new String[]{
            "1. What number is the head part?",
            "2. What number are showed leg and foot?",
            "3. Number 11 is part of?",
            "4. Numbers 5 and 6 are part?",
            "5. What number is showed ear?",
    };
    String[] pilih_jawaban = new String[]{
            "Number 1","Number 2","Number 4","Number 13",
            "Number 2 and 3","Number 4 and 5","Number 6 and 7","Number 8 and 9",
            "Hair","Eye","Ear","Mouth",
            "Eye and Eyebrows","Neck and Stomach","Arm and Hand","Leg and Foot",
            "Number 2","Number 4","Number 3","Number 12",
    };
    String[] jawaban_benar = new String[]{
            "Number 1",
            "Number 6 and 7",
            "Mouth",
            "Arm and Hand",
            "Number 4",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambar);

        //iklan
        MobileAds.initialize(this,"ca-app-pub-4022976492067687~8839315183");
        AdView adView=(AdView)findViewById(R.id.Adview);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        //Diskripsi:
        quis = (TextView) findViewById(R.id.quis);
        radiogroup = (RadioGroup) findViewById(R.id.radioGroup);
        pilihA = (RadioButton) findViewById(R.id.pilihA);
        pilihB = (RadioButton) findViewById(R.id.pilihB);
        pilihC = (RadioButton) findViewById(R.id.pilihC);
        pilihD = (RadioButton) findViewById(R.id.pilihD);

        radiogroup.check(0);
        benar = 0;
        salah = 0;

        //Fungtion
        quis.setText(pertanyaan[nomor]);
        pilihA.setText(pilih_jawaban[0]);
        pilihB.setText(pilih_jawaban[1]);
        pilihC.setText(pilih_jawaban[2]);
        pilihD.setText(pilih_jawaban[3]);
    }
    //Function:
    public void next(View view) {
        if (pilihA.isChecked() || pilihB.isChecked() || pilihC.isChecked() || pilihD.isChecked()) {
            RadioButton jawaban_user = (RadioButton) findViewById(radiogroup.getCheckedRadioButtonId());
            String ambil_jawaban = jawaban_user.getText().toString();
            radiogroup.check(0);
            if (ambil_jawaban.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < pertanyaan.length) {
                quis.setText(pertanyaan[nomor]);
                pilihA.setText(pilih_jawaban[(nomor * 4) + 0]);
                pilihB.setText(pilih_jawaban[(nomor * 4) + 1]);
                pilihC.setText(pilih_jawaban[(nomor * 4) + 2]);
                pilihD.setText(pilih_jawaban[(nomor * 4) + 3]);
            } else {
                hasil = benar * 20;
                Intent selesai = new Intent(getApplicationContext(),score_body.class);
                startActivity(selesai);

            }
        } else {
            Toast.makeText(this, "Choise You're Answer", Toast.LENGTH_SHORT).show();
        }
    }
}
