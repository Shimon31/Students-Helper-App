package com.shimon.bdresult;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    CheckBox checkBox;
    Button button;
    EditText editTextEmail,editTextNPass,editTextCPass;
    AutoCompleteTextView BloodGroup;
    String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser muser;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        checkBox = findViewById(R.id.checkboxID);
        button = findViewById(R.id.Button);
        BloodGroup = findViewById(R.id.BloodGroup);
        editTextEmail = findViewById(R.id.SUEmailET);
        editTextNPass = findViewById(R.id.SUNPass);
        editTextCPass = findViewById(R.id.SUCPass);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        muser = mAuth.getCurrentUser();


        String [] BloodGroupTV = {"A+","A-","B+","B-","AB+","AB-","O+","O-"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,BloodGroupTV);
        BloodGroup.setAdapter(arrayAdapter);
        BloodGroup.setThreshold(1);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked == true){
                    button.setVisibility(View.VISIBLE);

                }
                else{
                    button.setVisibility(View.INVISIBLE);
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PerformAuth();


            }
        });

    }

    private void PerformAuth() {
        String email = editTextEmail.getText().toString();
        String NPassword = editTextNPass.getText().toString();
        String CPassword = editTextCPass.getText().toString();


        if (!email.matches(EMAIL_PATTERN)){
            editTextEmail.setError("Enter valid Email");
        }
        else if (NPassword.isEmpty() || NPassword.length()<6){
            editTextNPass.setError("Enter Proper Password");
        }
        else if (!NPassword.equals(CPassword)){
            editTextCPass.setError("Password Not Matched");
        }
        else{
            progressDialog.setMessage("Please wait for Registration");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            mAuth.createUserWithEmailAndPassword(email,NPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(Login.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(Login.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void sendUserToNextActivity() {
        Intent intent = new Intent(Login.this,Login_Page.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}