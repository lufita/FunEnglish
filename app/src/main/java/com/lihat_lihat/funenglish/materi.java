package com.lihat_lihat.funenglish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class materi extends AppCompatActivity {

    Button satu,dua,tiga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);
        satu=(Button)findViewById(R.id.satu);
        dua=(Button)findViewById(R.id.dua);
        tiga=(Button)findViewById(R.id.tiga);
    }
    public void present(View view)
    {
        Intent intent=new Intent(materi.this,materi_present.class);
        startActivity(intent);
    }
    public void past(View view)
    {
        Intent intent=new Intent(materi.this,materi_past.class);
        startActivity(intent);
    }
    public void future(View view)
    {
        Intent intent=new Intent(materi.this,materi_future.class);
        startActivity(intent);
    }

}
