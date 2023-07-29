package com.example.uasiman;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageView;

public class MenuUtamaActivity extends AppCompatActivity {


    private ImageView imageDaftar,imageLokasi, imageBayar, imageKontak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);


        imageDaftar = findViewById(R.id.imageDaftar);
        imageLokasi = findViewById(R.id.imageLokasi);
        imageBayar = findViewById(R.id.imageBayar);
        imageKontak = findViewById(R.id.imageKontak);

        imageDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Ganti dengan validasi login sesuai kebutuhan
                Intent intent = new Intent( MenuUtamaActivity.this, PoliActivity.class);
                startActivity(intent);
                finish();

            }

        });
        imageBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Ganti dengan validasi login sesuai kebutuhan
                Intent intent = new Intent( MenuUtamaActivity.this, ScanActivity.class);
                startActivity(intent);
                finish();

            }

        });
        imageLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Ganti dengan validasi login sesuai kebutuhan
                Intent intent = new Intent( MenuUtamaActivity.this, MapActivity.class);
                startActivity(intent);
                finish();

            }

        });

    }
}

