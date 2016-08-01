package com.example.hochnt.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hochnt.contactmanger1.R;
import com.example.hochnt.model.Contact;

import java.util.List;

/**
 * Created by hochnt on 2016/08/01.
 */
public class ContactAdapter extends ArrayAdapter<Contact> {

    Activity context;
    int resource;
    List<Contact> objects;

    public ContactAdapter(Activity context, int resource, List<Contact> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource,null);

        TextView txtTen = (TextView) row.findViewById(R.id.txtTen);
        TextView txtPhone = (TextView) row.findViewById(R.id.txtPhone);
        ImageButton btnCall = (ImageButton) row.findViewById(R.id.btnCall);
        ImageButton btnSms = (ImageButton) row.findViewById(R.id.btnSms);
        ImageButton btnDelete = (ImageButton) row.findViewById(R.id.btnDelete);

        final Contact contact = this.objects.get(position);
        txtTen.setText(contact.getName());
        txtPhone.setText(contact.getPhone());
        
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xyLyCall(contact);
            }
        });
        
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xyLySms(contact);
            }
        });

        
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xyLyXoa(contact);
            }
        });

        return row;
    }

    private void xyLyXoa(Contact contact) {
    }

    private void xyLySms(Contact contact) {
    }

    private void xyLyCall(Contact contact) {
    }
}
