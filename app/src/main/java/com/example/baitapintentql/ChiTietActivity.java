package com.example.baitapintentql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChiTietActivity extends AppCompatActivity {
    EditText edtMaSp, edtTenSp, edtDonSp;
    Button btnXoa, btnTroVe;
    Intent intent;
    SanPham sp;
    int maResult = 115;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("San Pham", sp);
                setResult(maResult, intent);
                finish();
            }
        });
    }

    private void addControls() {
        edtDonSp = (EditText) findViewById(R.id.edtDonSp);
        edtMaSp = (EditText) findViewById(R.id.edtMaSp);
        edtTenSp = (EditText) findViewById(R.id.edtTenSp);
        btnTroVe = (Button) findViewById(R.id.btnTroVe);
        btnXoa = (Button) findViewById(R.id.btnXoa);
        intent = getIntent();
        sp = (SanPham) intent.getSerializableExtra("San Pham");
        edtMaSp.setText(sp.getMaSp());
        edtTenSp.setText(sp.getTenSp());
        edtDonSp.setText(sp.getDonGia() + "");
    }
}