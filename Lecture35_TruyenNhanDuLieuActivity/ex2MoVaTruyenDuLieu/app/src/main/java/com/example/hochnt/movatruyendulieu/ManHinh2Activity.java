package com.example.hochnt.movatruyendulieu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hochnt.model.SinhVien;

public class ManHinh2Activity extends AppCompatActivity {

    //khai bao hung du lieu
    TextView txtKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh2);

        addControl();
    }

    private void addControl() {
        txtKetQua = (TextView) findViewById(R.id.txtKetQua);
        //hung ket qua thong qua getintent()
        Intent intent = getIntent();
        //(tim thay tra ve ket qua trong putExtra, khong thay tra ve ket qua mac dinh)
        boolean kieuBool = intent.getBooleanExtra("KIEU_BOOLEAN",false);
        char kieuChar = intent.getCharExtra("KIEU_CHAR",'s');
        int kieuInt = intent.getIntExtra("KIEU_INT",0);
        double kieuDouble = intent.getDoubleExtra("KIEU_DOUBLE",0.0);
        String kieuString = intent.getStringExtra("KIEU_STRING");//khong phai là primitive data

        SinhVien sv = (SinhVien) intent.getSerializableExtra("SINHVIEN");

        txtKetQua.setText("Kiểu boolean = " + kieuBool + "\n" +
                "Kiểu INT = " + kieuInt + "\n" +
                "Kiểu Char = " + kieuChar + "\n" +
                "Kiểu Double = " + kieuDouble + "\n" +
                "Kiểu String = " + kieuString
        + "Kiểu đối tượng " + sv);

    }
}
