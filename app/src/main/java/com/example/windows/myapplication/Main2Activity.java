package com.example.windows.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private EditText Nama;
    private EditText Tipe;
    private Button Enter;
    private TextView Hasil;
    private TextView Nama2;
    private TextView Tipe2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Nama = findViewById(R.id.nama);
        Tipe = findViewById(R.id.tipe);
        Enter = findViewById(R.id.enter);
        Hasil = findViewById(R.id.hasil);
        Nama2 = findViewById(R.id.nama2);
        Tipe2 = findViewById(R.id.tipe2);

        Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nama2.setText("Nama Senjata adalah "+Nama.getText().toString());
                Tipe2.setText("Tipe Senjata Anda Sebutkan "+Tipe.getText().toString());
            }
        });



    }


    }



