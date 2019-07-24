package com.example.windows.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private EditText eLebar;
private EditText eTinggi;
private EditText ePanjang;
private Button bHitung;
private TextView tHasil;
private Button Pindah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eLebar = findViewById(R.id.idlebar);
        ePanjang = findViewById(R.id.idpanjang);
        eTinggi = findViewById(R.id.idtinggi);
        bHitung = findViewById(R.id.bhitung);
        tHasil = findViewById(R.id.thasil);
        Pindah = findViewById(R.id.pindah);

        Pindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        bHitung.setOnClickListener(this);

        if (savedInstanceState !=null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tHasil.setText(result);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bhitung) {
            String inputPanjang = ePanjang.getText().toString().trim();
            String inputLebar = eLebar.getText().toString().trim();
            String inputTinggi = eTinggi.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputLebar)) {
                isEmptyFields = true;
                eLebar.setError("Jangan Kosong Dong");
            }
            if (TextUtils.isEmpty(inputPanjang)) {
                isEmptyFields = true;
                ePanjang.setError("Jangan Kosong Dong");
            }
            if (TextUtils.isEmpty(inputTinggi)) {
                isEmptyFields = true;
                eTinggi.setError("Jangan Kosong Dong");
            }

            Double panjang = toDouble(inputPanjang);
            Double lebar = toDouble(inputLebar);
            Double tinggi = toDouble(inputTinggi);

            if (panjang == null) {
                isInvalidDouble = true;
                ePanjang.setError("Nomor Harus Sesuai");
            }
            if (lebar == null) {
                isInvalidDouble = true;
                eLebar.setError("Nomor Harus Sesuai");
            }
            if (!isEmptyFields && !isInvalidDouble) {
                double volume = panjang * lebar * tinggi;
                tHasil.setText(String.valueOf(volume));
            }
        }
    }

    private Double toDouble(String string) {
        try{
            return Double.valueOf(string);
        }catch (NumberFormatException e){
            return null;
        }
    }

    private static final String STATE_RESULT = "state_result";
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tHasil.getText().toString());
    }

}
