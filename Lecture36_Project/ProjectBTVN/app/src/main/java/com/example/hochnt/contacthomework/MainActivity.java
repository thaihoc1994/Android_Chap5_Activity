package com.example.hochnt.contacthomework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hochnt.adapter.ContactAdapter;
import com.example.hochnt.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtTen;
    EditText txtSdt;
    Button btnLuu;
    Button btnGuiMulti;
    ListView lvDanhBa;
    ArrayList<Contact> dsDanhBa;
    ContactAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControl();
        addEvent();
    }

    private void addEvent() {
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xyLyLuu();
            }
        });
        
        btnGuiMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xyLyGuiNhieuNguoi(dsDanhBa);
            }
        });
    }

    private void xyLyGuiNhieuNguoi(ArrayList<Contact> dsDanhBa) {
        Intent intent = new Intent(MainActivity.this, NhanTinActivity.class);
        ArrayList<Contact> tmp = new ArrayList<Contact>();
        Contact ct = new Contact();
        for (int i = 0; i<dsDanhBa.size(); i++)
        {
            if (dsDanhBa.get(i).isCanSend() == true)
            {
                ct = dsDanhBa.get(i);
                tmp.add(ct);
            }

        }
        intent.putExtra("LISTCONTACT", tmp);//truyen du lieu
        MainActivity.this.startActivity(intent);
    }

    private void xyLyLuu() {
        Contact contact = new Contact(
                txtTen.getText().toString(),
                txtSdt.getText().toString(),
                false

        );

        dsDanhBa.add(contact);
        adapter.notifyDataSetChanged();
    }

    private void addControl() {
        txtTen = (EditText) findViewById(R.id.txtTen);
        txtSdt = (EditText) findViewById(R.id.txtSDT);
        btnLuu = (Button) findViewById(R.id.btnLuu);
        btnGuiMulti = (Button) findViewById(R.id.btnSendMulti);

        lvDanhBa = (ListView) findViewById(R.id.lvDanhBa);
        dsDanhBa = new ArrayList<>();
        adapter = new ContactAdapter(MainActivity.this,R.layout.item,dsDanhBa);
        lvDanhBa.setAdapter(adapter);
    }
}
