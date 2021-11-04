package com.example.testconectdata.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;
import android.support.v7.widget.Toolbar;
import com.example.testconectdata.R;
import com.example.testconectdata.ultil.CheckConnection;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    DrawerLayout drawerLayout;
    Button buttoncontinue;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        if(CheckConnection.haveNetworkConnection(getApplicationContext()))
        {
            getdulieusp();
            ContinueClick();
        }
        else
        {
            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
            finish();
        }
    }
    private void getdulieusp() {
    }
    private void ContinueClick()
    {
        buttoncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });
    }
    private void Anhxa()
    {
        toolbar = findViewById(R.id.toolbarmanhinhchinh);
        viewFlipper = findViewById(R.id.viewFlipper);
        drawerLayout = findViewById(R.id.drawerlayout);
        buttoncontinue = findViewById(R.id.buttoncontinue);

    }
}