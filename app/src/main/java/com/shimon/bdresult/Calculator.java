package com.shimon.bdresult;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {
    EditText editText1,editText2;
    TextView resultTv;
    String number1,number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        resultTv = findViewById(R.id.result);

    }
    public void add(View view) {

        getNumberFromEditText();
        checkNull(0);


    }

    private void checkNull(int i) {
        if (number1.isEmpty() || number2.isEmpty()){
            Toast.makeText(this, "Enter any Number", Toast.LENGTH_SHORT).show();
        }
        else{

            switch (i){
                case 0:
                    double result = Double.parseDouble(number1) + Double.parseDouble(number2);

                    resultTv.setText(String.valueOf(result));
                    break;
                case 1:
                    double result1 = Double.parseDouble(number1) - Double.parseDouble(number2);

                    resultTv.setText(String.valueOf(result1));
                    break;
                case 2:
                    double result2 = Double.parseDouble(number1) * Double.parseDouble(number2);

                    resultTv.setText(String.valueOf(result2));
                    break;
                case 3:
                    double result3 = Double.parseDouble(number1) / Double.parseDouble(number2);

                    resultTv.setText(String.valueOf(result3));
                    break;

            }


        }
    }

    private void getNumberFromEditText() {
        number1 = editText1.getText().toString();
        number2 = editText2.getText().toString();

    }

    public void Sub(View view) {
        getNumberFromEditText();
        checkNull(1);
    }

    public void Mul(View view) {
        getNumberFromEditText();
        checkNull(2);
    }

    public void div(View view) {
        getNumberFromEditText();
        checkNull(3);
    }


}