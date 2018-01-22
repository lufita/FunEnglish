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

public class future_tense extends AppCompatActivity {

    //Kamus:
    TextView quis;
    RadioGroup radiogroup;
    RadioButton pilihA, pilihB, pilihC, pilihD;
    int nomor = 0;
    public static int hasil, benar, salah;

    String[] pertanyaan = new String[]{
            "1. They will meet us in the party, translete is ...",
            "2. I ..... you smile. Complete ",
            "3. We will ... been opening the door of car when there is car. complete",
            "4. Pada selasa pagi yang akan datang, Kami akan pergi ke sekolah dengan menggunakan sepeda, translete is ...",
            "5. In next afternoon, I will have ... you there, complete "
    };
    String[] pilih_jawaban = new String[]{
            "Mereka akan bertemu kita di pesta", "Mereka akan membantu disana", "Mereka akan menangis untuk kondisi ini.", "Aku tidak berharap ini terjadi",
            "would", "will", "will make", "should",
            "has", "have", "had", "haven",
            "By next december, I will have got my new shoes", "By the next year, we will have moved to another city", "When we were kids, we were always together", "By the next tuesday morning, We will have gone to the school by bycycle",
            "seen", "been", "see", "saw",
    };
    String[] jawaban_benar = new String[]{
            "Mereka akan bertemu kita di pesta",
            "will make",
            "have",
            "By the next tuesday morning, We will have gone to the school by bycycle",
            "seen",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future_tense);

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
                Intent selesai = new Intent(getApplicationContext(),score_furute.class);
                startActivity(selesai);

            }
        } else {
            Toast.makeText(this, "Choise You're Answer", Toast.LENGTH_SHORT).show();
        }
    }

}
