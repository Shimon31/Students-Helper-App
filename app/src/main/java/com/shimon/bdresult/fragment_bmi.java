package com.shimon.bdresult;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class fragment_bmi extends Fragment {
    EditText editText1,editText2;
    Button button;
    TextView textView1;
    String h1,w1;



    public fragment_bmi() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bmi, container, false);

        editText1 = view.findViewById(R.id.heightET);
        editText2 = view.findViewById(R.id.weightET);
        button = view.findViewById(R.id.bmiButtton);
        textView1 = view.findViewById(R.id.displayTV);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                h1 = editText1.getText().toString();
                w1 = editText2.getText().toString();
                float fh1 = Float.parseFloat(editText1.getText().toString());
                Float mheight=fh1/100;
                float fw1 = Float.parseFloat(editText2.getText().toString());
                float result=(fw1/(mheight*mheight));
                String sresult = Float.toString(result);

                textView1.setText("BMI is :"+sresult);

            }
        });

        return view;
    }
}