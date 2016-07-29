package com.example.hochnt.xulytruyennhan_traketqua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ManHinhXuLyActivity extends AppCompatActivity {

    TextView txtNhan;
    Button btnTinh;

    Intent intent;
    int a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_xu_ly);

        addControl();
        addEvent();
    }

    private void addEvent() {
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xyLyTinhUSCLN();
            }
        });
    }

    private void xyLyTinhUSCLN() {
        int min = Math.min(a,b);
        int uscln = 1;
        for (int i = min; i >= 1; i-- )
        {
            if(a%i == 0 && b%i == 0)
            {
                uscln = i;
                break;
            }
        }
        //Buoc 3, thay doi thong tin va truyen vao intent tra ve
        //nên sử dụng lại intent
        intent.putExtra("USCLN",uscln);
        //Buoc 4: Đánh dấu kết quả trả về
        setResult(33,intent);//ds1: mã kết quả, ds2: intent(đã thay đổi thông tin)
        //Bước 5 => đóng màn hình đang sử dụng
        finish();//=> để màn hình MainActivity trở thành foreground Life time vì nó chỉ nhận được
        //kết quả trả về ở trong fore ground life time
    }

    private void addControl() {
        txtNhan = (TextView) findViewById(R.id.txtNhan);
        btnTinh = (Button) findViewById(R.id.btnTinh);
        //Lấy dữ liệu
        intent = getIntent();
        a=intent.getIntExtra("a",-1);
        b=intent.getIntExtra("b",-1);
        txtNhan.setText("a = " + a + " ;b = " + b);
    }
}
