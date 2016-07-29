package com.example.hochnt.mycontactapplication;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnQuay, btnGoi, btnNhanTin;
    EditText txtSDT, txtTinNhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControl();
        addEvent();
    }

    private void addEvent() {
        btnQuay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xyLyQuaySo();
            }
        });
        btnGoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyGoiLuon();
            }
        });
        btnNhanTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xyLyNhanTinVaQuanLyKetQua();
            }
        });
    }

    private void xyLyNhanTinVaQuanLyKetQua() {
        //lấy mặc định SmsManager
        final SmsManager sms = SmsManager.getDefault();
        Intent msgSent = new Intent("ACTION_MSG_SENT");//gửi lệnh cho hệ thống điện thoại (gửi tin nhắn)
//        Intent msgSent = new Intent(Intent.ACTION_SEND);
        //Khai báo pendingintent để kiểm tra kết quả
        //phải chờ khi nào xong mới co thể kích hoạt
        final PendingIntent pendingMsgSent = PendingIntent.getBroadcast(this, 0, msgSent, 0);
        registerReceiver(new BroadcastReceiver() {//lecture Broadcast : Tự động lắng nghe
            public void onReceive(Context context, Intent intent) {
                int result = getResultCode();
                String msg="Gửi tin nhắn thành công";
                if (result != Activity.RESULT_OK) {
                    msg="Send failed";
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        }, new IntentFilter("ACTION_MSG_SENT"));
        //Gọi hàm gửi tin nhắn đi
        sms.sendTextMessage(c.getPhone(), null, editContent.getText()+"",
                pendingMsgSent, null);
        finish();
    }

    private void xuLyGoiLuon() {
        Uri uri = Uri.parse("tel:" + txtSDT.getText().toString());
        Intent intent = new Intent(Intent.ACTION_CALL);//intent khong tuong minh
        intent.setData(uri);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }

    private void xyLyQuaySo() {
        Uri uri = Uri.parse("tel:" + txtSDT.getText().toString());
        Intent intent = new Intent(Intent.ACTION_DIAL);//intent khong tuong minh
        intent.setData(uri);
        startActivity(intent);
    }

    private void addControl() {
        txtSDT = (EditText) findViewById(R.id.txtSDT);
        txtTinNhan = (EditText) findViewById(R.id.txtTinNhan);
        btnGoi = (Button) findViewById(R.id.btnGoi);
        btnNhanTin = (Button) findViewById(R.id.btnNhanTin);
        btnQuay = (Button) findViewById(R.id.btnQuaySo);
    }
}
