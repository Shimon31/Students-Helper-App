package com.shimon.bdresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Final_Quiz extends AppCompatActivity {
    int finalmarks = 0;
    TextView resultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_quiz);

        resultTv = findViewById(R.id.resulttvid);
        Intent intent = getIntent();
        finalmarks = intent.getIntExtra("q2marks", 0);
        resultTv.setText("Your result is: " + finalmarks + " / 10");
    }

    public void tryagainbtnfunction(View view) {
        Intent intent = new Intent(this, Quiz1.class);
        startActivity(intent);

    }
}