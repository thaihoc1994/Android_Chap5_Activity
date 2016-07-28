package com.example.hochnt.movatruyendulieu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void xuLyMoVaGui(View view) {
        Intent intent = new Intent(MainActivity.this,ManHinh2Activity.class);
        //Đưa, đóng gói dữ liệu vào intent
        //DDS1: tên biến
        intent.putExtra("KIEU_BOOLEAN",true);
        intent.putExtra("KIEU_CHAR",'x');
        intent.putExtra("KIEU_INT",100);
        intent.putExtra("KIEU_DOUBLE",15.99);
        intent.putExtra("KIEU_STRING","HocHNT");//khong phai là primitive data
        startActivity(intent);
    }
}
