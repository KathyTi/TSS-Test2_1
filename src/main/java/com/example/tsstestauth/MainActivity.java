package com.example.tsstestauth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber;
    private EditText editTextPassword;
    private Button button;
    //private PhoneAuthProvider provider;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;
    private String verificationID;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNumber = findViewById(R.id.editTextNumber);
        button = findViewById(R.id.button);
        mAuth = FirebaseAuth.getInstance();
        editTextNumber.setText("+7");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextNumber.getText().toString() != "+7") {
                    Intent intent = new Intent(MainActivity.this, EnterCodeActivity.class);
                    intent.putExtra("number", editTextNumber.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }



    //private void signInWidthCredential(PhoneAuthCredential phoneAuthCredential) {
    //    mAuth.signInWithCredential(phoneAuthCredential);
    //}
}