package com.example.hochnt.contactmanger1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.hochnt.adapter.ContactAdapter;
import com.example.hochnt.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtTen,txtSDT;
    Button btnLuu;
    ListView lvDanhBa;
    ArrayList<Contact> dsDanhBa;
    ContactAdapter contactAdapter;
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
                xyLyLuuDanhBa();
            }
        });
    }

    private void xyLyLuuDanhBa() {
        Contact contact = new Contact(txtTen.getText().toString(),txtSDT.getText().toString());
        dsDanhBa.add(contact);
        contactAdapter.notifyDataSetChanged();

    }

    private void addControl() {
        txtTen = (EditText) findViewById(R.id.txtTen);
        txtSDT = (EditText) findViewById(R.id.txtPhone);
        btnLuu = (Button) findViewById(R.id.btnLuu);

        lvDanhBa = (ListView) findViewById(R.id.lvDanhBa);
        dsDanhBa = new ArrayList<>();
        contactAdapter = new ContactAdapter(MainActivity.this,R.layout.item,dsDanhBa);

        lvDanhBa.setAdapter(contactAdapter);
    }
}
