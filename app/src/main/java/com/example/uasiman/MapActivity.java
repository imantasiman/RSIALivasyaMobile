package com.example.uasiman;





import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MapActivity extends AppCompatActivity {

    private Button btnKembaliMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);



        EditText editTextSource = findViewById(R.id.lokasi);
        EditText editTextDestination= findViewById(R.id.tujuan);
        Button button = findViewById(R.id.btnSubmit);
        btnKembaliMenu=findViewById(R.id.btnKembaliMenu);

        button.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v){
                String lokasi = editTextSource.getText().toString();
                String tujuan = editTextDestination.getText().toString();

                if(lokasi.equals("") && tujuan.equals("")){
                    Toast.makeText(MapActivity.this, "Input Lokasi Dan Tujuan Anda", Toast.LENGTH_SHORT).show();

                }else{
                    Uri uri =Uri.parse("https://www.google.com/maps/dir/"+lokasi+"/"+tujuan);
                    Intent intent=new Intent(Intent.ACTION_VIEW, uri);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }

            }
        });
        btnKembaliMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Ganti dengan validasi login sesuai kebutuhan
                Intent intent = new Intent(MapActivity.this, BerandaActivity.class);
                startActivity(intent);
                finish();

            }

        });


    }
}

