package com.shimon.bdresult;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_Page extends AppCompatActivity {
    TextView textViewRegister;


    EditText editTextEmail,editTextLPass;
    String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser muser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        textViewRegister = findViewById(R.id.registerTextView);
        editTextEmail = findViewById(R.id.loginEmailET);
        editTextLPass = findViewById(R.id.loginPassET);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        muser = mAuth.getCurrentUser();


        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Page.this,Login.class);
                startActivity(intent)  ;
            }
        });

    }



    public void loginPageBTN(View view) {

        perforLogin();

    }

    private void perforLogin() {
        String email = editTextEmail.getText().toString();
        String NPassword = editTextLPass.getText().toString();


        if (!email.matches(EMAIL_PATTERN)) {
            editTextEmail.setError("Enter valid Email");
        } else if (NPassword.isEmpty() || NPassword.length() < 6) {
            editTextLPass.setError("Enter Proper Password");
        } else {
            progressDialog.setMessage("Please wait for Login");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(email,NPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(Login_Page.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(Login_Page.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }

                }
            });


        }
    }
    private void sendUserToNextActivity() {
        Intent intent = new Intent(Login_Page.this,MainActivity_First.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}