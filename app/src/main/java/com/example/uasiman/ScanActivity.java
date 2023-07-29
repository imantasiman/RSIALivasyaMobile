package com.example.uasiman;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class ScanActivity extends AppCompatActivity {
    private TextView scanResultTextView;
    private Button btnScan;
    private Button btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        scanResultTextView = findViewById(R.id.scanResultTextView);
        btnScan = findViewById(R.id.btnScan);
        btnKembali=findViewById(R.id.btnKembali);


        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize the QR code scanner
                IntentIntegrator integrator = new IntentIntegrator(ScanActivity.this);
                integrator.setPrompt("Scan Now");
                integrator.setBeepEnabled(true);
                integrator.setOrientationLocked(true);
                integrator.setCaptureActivity(CaptureAct.class);
                integrator.initiateScan();
            }

        });
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Ganti dengan validasi login sesuai kebutuhan
                Intent intent = new Intent(ScanActivity.this, MenuUtamaActivity.class);
                startActivity(intent);
                finish();

            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                // QR code scanning cancelled
                Toast.makeText(this, "Scanning cancelled.", Toast.LENGTH_SHORT).show();
            } else {
                // QR code scanning successful
                String scanResult = result.getContents();
                scanResultTextView.setText("Scan Result: " + scanResult);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}

