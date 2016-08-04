package com.example.hochnt.contacthomework;

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

import java.util.ArrayList;

public class NhanTinActivity extends AppCompatActivity {

    //Nhan intent
    TextView txtNguoiNhan;
    EditText txtTinNhan;
    ImageButton btnSend;

    Contact selectedContact = null;//hung du lieu tu seriablize
    ArrayList<Contact> listSelectedContact = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_tin);
        
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
        //Mac dinh smsManager
        SmsManager smsManager = SmsManager.getDefault();
        Intent msgSend = new Intent("ACTION_MSG_SEND");//Gửi lệnh cho hệ thống điện thoại

        PendingIntent pendingMsgsent = PendingIntent.getBroadcast(this,0,msgSend,0);
        registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                int result = getResultCode();
                String msg="Gửi tin nhắn thành công";
                if (result != Activity.RESULT_OK) {
                    msg="Gửi tin nhắn thất bại";
                }
                Toast.makeText(NhanTinActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        }, new IntentFilter("ACTION_MSG_SENT"));
        //Gọi hàm gửi tin nhắn đi
        for (Contact tmp : listSelectedContact)
        {
            smsManager.sendTextMessage(tmp.getSdt(),null,txtTinNhan.getText() + "",pendingMsgsent,null);
        }
        smsManager.sendTextMessage(selectedContact.getSdt(), null, txtTinNhan.getText() +"",
                pendingMsgsent, null);
    }

    private void addControl() {
        txtNguoiNhan = (TextView) findViewById(R.id.txtNguoiNhan);
        txtTinNhan = (EditText) findViewById(R.id.txtTinNhan);

        btnSend = (ImageButton) findViewById(R.id.btnSend);

        Intent intent = getIntent();//lay du lieu

//        selectedContact = (Contact) intent.getSerializableExtra("CONTACT");
        listSelectedContact = (ArrayList<Contact>) intent.getSerializableExtra("LISTCONTACT");
        String nguoiNhan= "";
        for (Contact tmp : listSelectedContact)
        {
            nguoiNhan = nguoiNhan + tmp.getName() + ";";
        }
//        txtNguoiNhan.setText(selectedContact.getName() + " - " + selectedContact.getSdt());
        txtNguoiNhan.setText(nguoiNhan);

    }
}
