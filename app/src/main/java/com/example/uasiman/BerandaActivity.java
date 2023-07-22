package com.example.uasiman;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class BerandaActivity extends AppCompatActivity {


    private Button btnDaftarPoli,btnScan, btnMap, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        btnDaftarPoli = findViewById(R.id.btnDaftarPoli);
        btnScan = findViewById(R.id.btnScan);
        btnMap = findViewById(R.id.btnMap);
        btnLogout = findViewById(R.id.btnLogout);

        btnDaftarPoli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Ganti dengan validasi login sesuai kebutuhan
                Intent intent = new Intent( BerandaActivity.this, PoliActivity.class);
                startActivity(intent);
                finish();

            }

        });
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Ganti dengan validasi login sesuai kebutuhan
                Intent intent = new Intent( BerandaActivity.this, ScanActivity.class);
                startActivity(intent);
                finish();

            }

        });
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Ganti dengan validasi login sesuai kebutuhan
                Intent intent = new Intent( BerandaActivity.this, MapActivity.class);
                startActivity(intent);
                finish();

            }

        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Ganti dengan validasi login sesuai kebutuhan
                Intent intent = new Intent( BerandaActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }

        });
    }
}

