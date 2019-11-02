package com.example.android.LatUTS_PhoneShop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class detail_order extends AppCompatActivity {
    private TextView name_text, address_text,phone_text, note_text,color_text, type_text;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);
        name_text = (TextView) findViewById(R.id.name_text);
        address_text = (TextView) findViewById(R.id.address_text);
        phone_text = (TextView) findViewById(R.id.phone_text);
        note_text = (TextView) findViewById(R.id.note_text);
        color_text = (TextView) findViewById(R.id.color_txt);
        type_text = (TextView) findViewById(R.id.type_txt);
        Bundle extras = getIntent().getExtras();
        String txt_name = extras.getString("name");
        String txt_address = extras.getString("address");
        String txt_phone = extras.getString("phone");
        String txt_note = extras.getString("note");
        String color_txt = extras.getString("color");
        String type_txt = extras.getString("type");
        name_text.setText(txt_name);
        address_text.setText(txt_address);
        phone_text.setText(txt_phone);
        note_text.setText(txt_note);
        color_text.setText(color_txt);
        type_text.setText(type_txt);
    }
    public void btn_backMenu(View view) {
        Intent intent = new Intent(detail_order.this, first.class);
        startActivity(intent);
    }
}
