package com.example.uasiman;



import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private EditText  etEmail,etUsername, etPassword;
    private Button btnRegister;
    private TextView textLogin;

    private DatabaseReference database;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        etEmail = findViewById(R.id.etEmail);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);
        textLogin = findViewById(R.id.textLogin);

        database= FirebaseDatabase.getInstance().getReferenceFromUrl("https://database-rsialivasyamobile-default-rtdb.firebaseio.com/");

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if(email.isEmpty() || username.isEmpty()|| password.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Ada Data Yang Kosong!!",Toast.LENGTH_SHORT ).show();
                }else{
                    database=FirebaseDatabase.getInstance().getReference("users");
                    database.child(username).child("email").setValue(email);
                    database.child(username).child("username").setValue(username);
                    database.child(username).child("password").setValue(password);

                    Toast.makeText(getApplicationContext(),"Register Berhasil",Toast.LENGTH_SHORT ).show();

                    Intent register= new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(register);
                }


            }

        });
        textLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Ganti dengan validasi login sesuai kebutuhan
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }

        });
    }
}


