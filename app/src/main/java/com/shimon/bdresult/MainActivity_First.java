package com.shimon.bdresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shimon.bdresult.view.activity.MainActivity;

public class MainActivity_First extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_first);

    }

    public void bdResultBTN(View view) {
        Intent intent = new Intent(MainActivity_First.this, MainActivity.class);
        startActivity(intent);
    }

    public void BMIcalculator(View view) {
        Intent intent = new Intent(MainActivity_First.this,BmiAndFragment.class);
        startActivity(intent);
    }

    public void Calculator(View view) {
        Intent intent = new Intent(MainActivity_First.this,Calculator.class);
        startActivity(intent);
    }

    public void quiz(View view) {
        Intent intent = new Intent(MainActivity_First.this,Quiz1.class);
        startActivity(intent);
    }
}