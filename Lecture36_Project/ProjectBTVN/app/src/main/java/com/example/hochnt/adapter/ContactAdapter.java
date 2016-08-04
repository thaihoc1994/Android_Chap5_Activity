package com.example.hochnt.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hochnt.contacthomework.MainActivity;
import com.example.hochnt.contacthomework.NhanTinActivity;
import com.example.hochnt.contacthomework.R;
import com.example.hochnt.model.Contact;

import java.util.List;

/**
 * Created by hochnt on 2016/08/03.
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

        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View row = layoutInflater.inflate(this.resource, null);

        TextView txtTen = (TextView) row.findViewById(R.id.txtTen);
        TextView txtSdt = (TextView) row.findViewById(R.id.txtSDT);
        final CheckBox chkCanSend = (CheckBox) row.findViewById(R.id.chkContact);

        ImageButton btnCall = (ImageButton) row.findViewById(R.id.btnCall);
        ImageButton btnSms = (ImageButton) row.findViewById(R.id.btnSms);
        ImageButton btnDell = (ImageButton) row.findViewById(R.id.btnDell);

        //hien thi du lieu
        final Contact contact = this.objects.get(position);
        txtTen.setText(contact.getName());
        txtSdt.setText(contact.getSdt());
        chkCanSend.setChecked(contact.isCanSend());

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyGoi(contact);
            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xyLyGuiTinNhan(contact);
            }
        });

        btnDell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyXoa(contact);
            }
        });

        chkCanSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contact.setCanSend(chkCanSend.isChecked());
            }
        });

        return row;

    }

    private void xuLyXoa(Contact contact) {
        this.remove(contact);

    }

    private void xyLyGuiTinNhan(Contact contact) {
        Intent intent = new Intent(this.context, NhanTinActivity.class);
        intent.putExtra("CONTACT", contact);//truyen du lieu
        this.context.startActivity(intent);
    }

    private void xuLyGoi(Contact contact) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri uri = Uri.parse("tel:" + contact.getSdt());
        intent.setData(uri);
        if (ActivityCompat.checkSelfPermission(this.context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        this.context.startActivity(intent);
    }
}
