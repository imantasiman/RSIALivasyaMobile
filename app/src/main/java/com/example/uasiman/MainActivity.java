package com.example.uasiman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private EditText editTextName, editTextAddress, editTextPhoneNumber, editTextDate;
    private Button buttonSave;
    private ListView listViewClinics;
    private Button btnKembali;
    private List<String> clinicList;
    private ArrayAdapter<String> clinicAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextDate = findViewById(R.id.editTextDate);
        buttonSave = findViewById(R.id.buttonSave);
        btnKembali = findViewById(R.id.btnKembali);
        listViewClinics = findViewById(R.id.listViewClinics);

        clinicList = new ArrayList<>();
        clinicAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, clinicList);
        listViewClinics.setAdapter(clinicAdapter);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String address = editTextAddress.getText().toString();
                String phoneNumber = editTextPhoneNumber.getText().toString();
                String date = editTextDate.getText().toString();

                if (!name.isEmpty() && !address.isEmpty() && !phoneNumber.isEmpty()) {
                    String clinicData = name + ", " + address + ", " + phoneNumber+", "+date;
                    clinicList.add(clinicData);
                    clinicAdapter.notifyDataSetChanged();

                    editTextName.setText("");
                    editTextAddress.setText("");
                    editTextPhoneNumber.setText("");
                    editTextDate.setText("");

                    Toast.makeText(MainActivity.this, "Data poliklinik berhasil disimpan.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Mohon lengkapi semua field.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Ganti dengan validasi login sesuai kebutuhan
                Intent intent = new Intent(MainActivity.this, BerandaActivity.class);
                startActivity(intent);
                finish();

            }

        });
    }
}