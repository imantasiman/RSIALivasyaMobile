package com.example.uasiman;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;


public class PoliActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private Button btnObygn;
    private Button btnBedah;
    private Button btnAnak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftarpoli);


        btnObygn = findViewById(R.id.btnObygn);
        btnBedah = findViewById(R.id.btnBedah);
        btnAnak = findViewById(R.id.btnAnak);

        btnObygn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Ganti dengan validasi login sesuai kebutuhan
                Intent intent = new Intent(PoliActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }

        });
        btnBedah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Ganti dengan validasi login sesuai kebutuhan
                Intent intent = new Intent(PoliActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }

        });
        btnAnak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Ganti dengan validasi login sesuai kebutuhan
                Intent intent = new Intent(PoliActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }

        });
    }
}
