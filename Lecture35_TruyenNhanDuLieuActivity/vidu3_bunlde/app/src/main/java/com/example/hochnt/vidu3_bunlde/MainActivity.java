package com.example.hochnt.vidu3_bunlde;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.hochnt.model.SanPham;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void xuLyMoVaGuiBundle(View view) {
        //xu ly gui du lieu
        Intent intent = new Intent(MainActivity.this,ManHinh2Activity.class);
        //dong goi
        Bundle bundle = new Bundle();
        bundle.putInt("X",113);
        bundle.putDouble("D",114.115);
        SanPham coca = new SanPham(1,"Coca Cola",15000);

        bundle.putSerializable("SANPHAM",coca);
        intent.putExtra("BUNDLE",bundle);
        startActivity(intent);
    }
}
