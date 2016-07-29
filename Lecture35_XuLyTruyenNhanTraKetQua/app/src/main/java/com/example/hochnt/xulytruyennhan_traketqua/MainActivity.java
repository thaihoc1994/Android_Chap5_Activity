package com.example.hochnt.xulytruyennhan_traketqua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtA,txtB;
    Button btnXuLy;
    TextView txtKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }

    private void addEvent() {
        btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xyLyLayUSCLN();
            }
        });
    }

    private void xyLyLayUSCLN() {
        Intent intent = new Intent(MainActivity.this, ManHinhXuLyActivity.class);
        intent.putExtra("a",Integer.parseInt(txtA.getText().toString()));
        intent.putExtra("b",Integer.parseInt(txtB.getText().toString()));
        //Bước 1
        //phải dung startActivity for result
        startActivityForResult(intent,99);//Intens muốn gọi, yêu cầu gửi mã yêu cầu (Số không trùng nhau)

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 99 && resultCode == 33)
        {
            int uscln = data.getIntExtra("USCLN",-1);
            txtKetQua.setText("Kết quả (USCLNT) = " + uscln);
        }
    }

    private void addControl() {
        txtA = (EditText) findViewById(R.id.txtA);
        txtB = (EditText) findViewById(R.id.txtB);
        btnXuLy = (Button) findViewById(R.id.btnXuLy);
        txtKetQua = (TextView) findViewById(R.id.txtKetQua);

    }

}
