package com.lihat_lihat.funenglish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class kata extends AppCompatActivity {
    //Kamus:
    TextView quis;
    RadioGroup radiogroup;
    RadioButton pilihA, pilihB, pilihC, pilihD;
    int nomor = 0;
    public static int hasil, benar, salah;

    String[] pertanyaan = new String[]{
            "1. Nasi, translete is ...",
            "2. Bunga, translate is.. ",
            "3. Car, translate is..",
            "4. Lion, translete is ...",
            "5. Window, translate is.. "
    };
    String[] pilih_jawaban = new String[]{
           "Rice", "Flower", "Cake", "Rices",
            "Sunday", "Cucumber", "Car", "Flower",
            "Nasi", "Mobil", "Kucing", "Hewan",
            "Harimau", "Macan", "Singa", "Kucing",
            "Atap", "Lantai", "Pintu", "Jendela",
    };
    String[] jawaban_benar = new String[]{
            "Rice",
            "Flower",
            "Mobil",
            "Singa",
            "Jendela",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kata);

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
                Intent selesai = new Intent(getApplicationContext(),score_kata.class);
                startActivity(selesai);

            }
        } else {
            Toast.makeText(this, "Choise You're Answer", Toast.LENGTH_SHORT).show();
        }
    }

}
