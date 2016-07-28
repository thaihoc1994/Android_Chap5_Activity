package com.example.hochnt.momotmanhinh;

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

    public void xuLyMoManHinh(View view) {
        //DS1: Là màn hình hiện tại gọi Intent này (Tên activity.this)
        //DS2: là màn hình muốn mở lên
        Intent intent = new Intent(MainActivity.this,ManHinh2Activity.class);
        //gửi lệnh tới Android System để mở màn hình
        startActivity(intent);
    }
}
