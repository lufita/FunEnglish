package com.lihat_lihat.funenglish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class kalimat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalimat);
    }
    public void present(View view)
    {
        Intent intent=new Intent(kalimat.this, com.lihat_lihat.funenglish.present_tense.class);
        startActivity(intent);
    }
    public void pastense(View view)
    {
        Intent intent=new Intent(kalimat.this, com.lihat_lihat.funenglish.past_tense.class);
        startActivity(intent);
    }
    public void future(View view)
    {
        Intent intent=new Intent(kalimat.this, future_tense.class);
        startActivity(intent);
    }
}
