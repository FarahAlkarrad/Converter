package com.farahalkarrad.digitalsystems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button btnDEC, btnBIN, btnOCT, btnHEX;
    private EditText edtInput;
    private TextView edtResult;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        this.setTitle(R.string.main_activity_name);
        initializeConstraints();
        btnDEC.setOnClickListener(view -> {
            BaseConverter base = new BaseConverter(spinner.getSelectedItem().toString(), getString(R.string.decimal) ,
                    edtInput.getText().toString());
            edtResult.setText(base.getResult());
        });
        btnBIN.setOnClickListener(view -> {
            BaseConverter base = new BaseConverter(spinner.getSelectedItem().toString(), getString(R.string.binary) ,
                    edtInput.getText().toString());
            edtResult.setText(base.getResult());
        });
        btnOCT.setOnClickListener(view -> {
            BaseConverter base = new BaseConverter(spinner.getSelectedItem().toString(), getString(R.string.octal) ,
                    edtInput.getText().toString());
            edtResult.setText(base.getResult());
        });
        btnHEX.setOnClickListener(view -> {
            BaseConverter base = new BaseConverter(spinner.getSelectedItem().toString(), getString(R.string.hexadecimal) ,
                    edtInput.getText().toString());
            edtResult.setText(base.getResult());
        });
    }

    private void initializeConstraints(){
        btnDEC = findViewById(R.id.btnDEC);
        btnBIN = findViewById(R.id.btnBIN);
        btnOCT = findViewById(R.id.btnOCT);
        btnHEX = findViewById(R.id.btnHEX);

        edtInput = findViewById(R.id.editText);
        edtResult = findViewById(R.id.result);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.base_string, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}