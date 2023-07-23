package com.example.uasiman;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName, editTextAddress, editTextPhoneNumber, editTextDate;
    private Calendar calendar;
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
        editTextDate=findViewById(R.id.editTextDate);
        buttonSave = findViewById(R.id.buttonSave);
        btnKembali = findViewById(R.id.btnKembali);
        listViewClinics = findViewById(R.id.listViewClinics);

        Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updateCalendar();
            }
            private void updateCalendar(){
                String Format="dd/MM/yyyy";
                SimpleDateFormat sdf= new SimpleDateFormat(Format, Locale.US);
                editTextDate.setText(sdf.format(calendar.getTime()));
            }
        };
        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }

        });
{

        }

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

                if (!name.isEmpty() && !address.isEmpty() && !phoneNumber.isEmpty()
                && !date.isEmpty()) {
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