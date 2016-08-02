package com.example.hochnt.contactmanger1;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hochnt.model.Contact;

public class NhanTinSmsActivity extends AppCompatActivity {

    TextView txtNguoiNhan;
    EditText txtNoidung;
    ImageButton btnSend;

    Contact selectedContact = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_tin_sms);

        addControl();
        addEvent();
    }

    private void addEvent() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xyLyTinNhan();
            }
        });
    }

    private void xyLyTinNhan() {
        //lấy mặc định SmsManager
        final SmsManager sms = SmsManager.getDefault();
        Intent msgSent = new Intent("ACTION_MSG_SENT");//gửi lệnh cho hệ thống điện thoại (gửi tin nhắn)
        //Intent msgSent = new Intent(Intent.ACTION_SEND);

        //Khai báo pendingintent để kiểm tra kết quả
        //phải chờ khi nào xong mới co thể kích hoạt
        final PendingIntent pendingMsgSent = PendingIntent.getBroadcast(this, 0, msgSent, 0);
        registerReceiver(new BroadcastReceiver() {//lecture Broadcast : Tự động lắng nghe
            public void onReceive(Context context, Intent intent) {
                int result = getResultCode();
                String msg="Gửi tin nhắn thành công";
                if (result != Activity.RESULT_OK) {
                    msg="Gửi tin nhắn thất bại";
                }
                Toast.makeText(NhanTinSmsActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        }, new IntentFilter("ACTION_MSG_SENT"));
        //Gọi hàm gửi tin nhắn đi
        sms.sendTextMessage(selectedContact.getPhone(), null, txtNoidung.getText() +"",
                pendingMsgSent, null);
    }

    private void addControl() {
        txtNguoiNhan = (TextView) findViewById(R.id.txtNguoiNhan);
        txtNoidung = (EditText) findViewById(R.id.txtNoiDung);
        btnSend = (ImageButton) findViewById(R.id.btnSend);

        Intent intent = getIntent();
        selectedContact = (Contact) intent.getSerializableExtra("CONTACT");
        txtNguoiNhan.setText(selectedContact.getName() + " - " + selectedContact.getPhone());
    }
}
