package com.example.hochnt.learnactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Screen2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
    }

    public void xuLyCheKhuatToanBo(View view) {
        Intent intent = new Intent(Screen2Activity.this,MainActivity.class);//nhay toi man hinh 2
        startActivity(intent);
    }
}
