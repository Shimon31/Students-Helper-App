package com.shimon.bdresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class Quiz1 extends AppCompatActivity {
    RadioGroup radioGroup;
    int marks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);

        radioGroup=findViewById(R.id.radiogroupid);
    }
    public void nextbtnfunction(View view) {
        if(radioGroup.getCheckedRadioButtonId()==R.id.Diubtnid)
        {
            marks=5;
        }
        else
        {
            marks=0;
        }
        Intent intent=new
                Intent(getApplicationContext(),Quiz2.class);
        intent.putExtra("q1marks",marks);
        startActivity(intent);
    }
}