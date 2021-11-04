package com.example.testconectdata.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testconectdata.R;

public class ThongTinKhachHangActivity extends AppCompatActivity {
    Button btncomeback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_khach_hang);
            Anhxa();
          ComeBack();
    }

    private void ComeBack() {
        btncomeback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThongTinKhachHangActivity.this, GioHangActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Anhxa() {
        btncomeback = findViewById(R.id.buttoncomeback);
    }
}