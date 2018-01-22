package com.lihat_lihat.funenglish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class reading extends AppCompatActivity {
    TextView pertanyaan ;
    RadioGroup rg ;
    RadioButton PilihanA,PilihanB,PilihanC,PilihanD ;
    int nomor = 0 ;
    public static int hasil,benar,salah;


    /// pertanyaan kuis
    String [] pertanyaan_kuis = new String[]
            {
                    "1. To write on the blackboard, Mrs.Henni uses ... ? ",
                    "2. Mrs.Henni puts the books and important things ... ? ",
                    "3. There are ... tables in the classroom.",
                    "4. The cupboard is located ... ?",
                    "5. There are ... students in the class six of SD Sukadamai.",
            };

    /// pilihan jawaban
    String [] pilihan_jawaban = new String[]
            {
                    "A. pen","B. pencil","C. chalk","D. eraser",
                    "A. on the table","B. in the cupboard","C. at the corner","D. in front of the class",
                    "A. fourty","B. twenty two","C. twenty","D. two",
                    "A. in front of the class","B. beside the blackboard","C. at the back of the class","D. at the corner of the classroom",
                    "A. two","B. fourty","C. twenty","D. four",
            };

    /// jawaban benar
    String [] jawaban_benar = new String[]
            {
                    "C. chalk",
                    "B. in the cupboard",
                    "C. twenty",
                    "D. at the corner of the classroom",
                    "B. fourty",
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);

        pertanyaan = (TextView)findViewById(R.id.quis);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) findViewById(R.id.pilihanD);

        pertanyaan.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0 ;
        salah = 0 ;
    }
    public  void next (View view) {
        if (PilihanA.isChecked() || PilihanB.isChecked() || PilihanC.isChecked() || PilihanD.isChecked()) {
            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            else salah++;
            nomor++;

            if (nomor < pertanyaan_kuis.length) {
                pertanyaan.setText(pertanyaan_kuis[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                PilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                PilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                PilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);

            } else {
                hasil = benar * 20;
                Intent selesai = new Intent(getApplicationContext(), score_reading.class);
                startActivity(selesai);
            }
        }
        else
        {
            Toast.makeText(this, "Choise You're Answer",Toast.LENGTH_SHORT).show();
        }
    }
}
