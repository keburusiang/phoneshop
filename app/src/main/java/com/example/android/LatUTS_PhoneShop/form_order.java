package com.example.android.LatUTS_PhoneShop;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static java.sql.Types.NULL;

public class form_order extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    private EditText name_text, address_text, phone_text, note_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);

        setSupportActionBar(toolbar);
        //Your toolbar is now an action bar and you can use it like you always do, for example:
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        name_text = findViewById(R.id.name_text);
        address_text = findViewById(R.id.address_text);
        phone_text = findViewById(R.id.phone_text);
        note_text = findViewById(R.id.note_text);

        // ... Rest of onCreate code ...
        // Create the spinner.
        Spinner spinner = findViewById(R.id.spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        // Create ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void btn_order(View view) {
        final Toast toast = Toast.makeText(this, "Data can't be null", Toast.LENGTH_SHORT);
        final String name = String.valueOf(name_text.getText());
        final String address = String.valueOf(address_text.getText());
        final String phone = String.valueOf(phone_text.getText());
        final String note = String.valueOf(note_text.getText());
        if (name.equals("")||address.equals("")||phone.equals("")||note.equals("")) {
            toast.show();
        } else {
            AlertDialog.Builder myAlertBuilder = new
                    AlertDialog.Builder(form_order.this);
            RadioGroup rg = (RadioGroup) findViewById(R.id.color_txt);
            final String color =
                    ((RadioButton) findViewById(rg.getCheckedRadioButtonId()))
                            .getText().toString();
            Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
            final String type = mySpinner.getSelectedItem().toString();

            myAlertBuilder.setTitle("Confirm");
            myAlertBuilder.setMessage("Do you want to Order ?");
            // Add the dialog buttons.
            myAlertBuilder.setPositiveButton("YES", new
                    DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Bundle extras = new Bundle();
                            extras.putString("name", name);
                            extras.putString("address", address);
                            extras.putString("phone", phone);
                            extras.putString("note", note);
                            extras.putString("color", color);
                            extras.putString("type", type);
                            Intent intent = new Intent(form_order.this, detail_order.class);
                            intent.putExtras(extras);
                            startActivity(intent);
                        }
                    });
            myAlertBuilder.setNegativeButton("CANCEL", new
                    DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // User cancelled the dialog.
                        }
                    });
            // Create and show the AlertDialog.
            myAlertBuilder.show();
        }
    }
}
