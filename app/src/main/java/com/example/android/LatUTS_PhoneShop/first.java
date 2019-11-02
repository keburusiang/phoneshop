package com.example.android.LatUTS_PhoneShop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.jar.Attributes;

public class first extends AppCompatActivity implements View.OnClickListener {


public static final String EXTRA = "com.exmaple EXTRA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Button btn1 = findViewById(R.id.btn_lihat1);
        Button btn2 = findViewById(R.id.btn_lihat2);
        Button btn3 = findViewById(R.id.btn_lihat3);
        Button btn4 = findViewById(R.id.btn_lihat4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String name = "Samsung note";
        Intent intent = new Intent(this, MainActivity.class);
        switch (view.getId()){

            case R.id.btn_lihat1:

               startActivity(intent);
               // Toast.makeText(first.this,"COBA",Toast.LENGTH_SHORT).show();
                break;

        }


    }

    public void float_order(View view) {
        Intent intent = new Intent(this,form_order.class);
        startActivity(intent);
    }
}
