package com.shimon.bdresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Quiz2 extends AppCompatActivity {
    TextView textView;
    RadioGroup radioGroup;
    int previousmarks = 0, total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        radioGroup = findViewById(R.id.radiogroup2id);
        Intent intent = getIntent();
        previousmarks = intent.getIntExtra("q1marks", 0);
    }
    public void previousbtnfunction(View view) {
        Intent intent=new Intent(this,Quiz1.class);
        startActivity(intent);
    }
    public void nextbtnfunction(View view) {
        if (radioGroup.getCheckedRadioButtonId()==R.id.id3btnid)
        {
            total=previousmarks+5;
        }
        else
        {
            total=previousmarks;
        }
        Intent intent=new
                Intent(getApplicationContext(),Final_Quiz.class);
        intent.putExtra("q2marks",total);
        startActivity(intent);
    }
}