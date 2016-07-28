package com.example.hochnt.vidu3_bunlde;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hochnt.model.SanPham;

public class ManHinh2Activity extends AppCompatActivity {

    TextView txtKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh2);
        addControl();
    }

    private void addControl() {
        txtKetQua = (TextView) findViewById(R.id.txtKetQua);


        Intent intent = getIntent();
        Bundle bundle =  intent.getBundleExtra("BUNDLE");
        SanPham sp = (SanPham) bundle.getSerializable("SANPHAM");
        txtKetQua.setText("X = " + bundle.getInt("X") +"\n"
        +"D = " + bundle.getDouble("D") + "\n"
        +"Sp = " + sp);

    }
}
