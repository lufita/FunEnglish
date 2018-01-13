package com.lihat_lihat.funenglish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class present_tense extends AppCompatActivity {

    //Kamus:
    TextView quis;
    RadioGroup radiogroup;
    RadioButton pilihA, pilihB, pilihC, pilihD;
    int nomor = 0;
    public static int hasil, benar, salah;

    String[] pertanyaan = new String[]{
            "1. Cheeta adalah binatang tercepat di dunia, translete is ...",
            "2. We will not come to your party if you ... invite us. Complete ",
            "3. Do you know where is my wallet?, translete is ...",
            "4. Does the water boils at 100 C ?, translete is ...",
            "5. Life ... not beautiful without love. Complete "
    };
    String[] pilih_jawaban = new String[]{
            "God is always be with us.", "I always pray five times a day.", "Cheeta's love each other.", "Cheeta is the fastest animal in the world.",
            "not", "don't", "aren't", "doesn't",
            "apakah kamu tahu dimana dompetku?", "apakah kamu tidak pernah minum kopi?", "apakah Joni pergi ke sekolah dengan mengendarai sepeda motor?", "apakah ibu dan kakakku pergi berbelanja pada pagi hari?",
            "apakah kamu tidak pernah minum kopi?", "apakah pamanmu hidup di rumah sangat sederhana sekali?", "hidup tidak indah tanpa cinta", "apakah air mendidih pada 100 derajat celcius?",
            "am", "are", "is", "was",
    };
    String[] jawaban_benar = new String[]{
            "Cheeta is the fastest animal in the world.",
            "don't",
            "apakah kamu tahu dimana dompetku?",
            "apakah air mendidih pada 100 derajat celcius?",
            "is",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present_tense);

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
            if (ambil_jawaban.equalsIgnoreCase(jawaban_benar[nomor]))benar++;
            else salah++;
            nomor++;
            if (nomor < pertanyaan.length) {
                quis.setText(pertanyaan[nomor]);
                pilihA.setText(pilih_jawaban[(nomor*4)+0]);
                pilihB.setText(pilih_jawaban[(nomor*4)+1]);
                pilihC.setText(pilih_jawaban[(nomor*4)+2]);
                pilihD.setText(pilih_jawaban[(nomor*4)+3]);
            } else {
                hasil = benar * 20;
                Intent selesai = new Intent(getApplicationContext(), com.lihat_lihat.funenglish.score_present.class);
                startActivity(selesai);

            }
        }
        else
        {
            Toast.makeText(this, "Choise You're Answer",Toast.LENGTH_SHORT).show();
        }
    }
}
