package com.vmorenomarin.contapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.support.design.widget.TextInputEditText;
import android.text.Editable;
import android.widget.TextView;
import android.widget.Toast;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.text.TextWatcher;  //valida el texto ingresado.
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.text.InputType;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;



public class MainActivity extends AppCompatActivity implements OnFocusChangeListener {

    private EditText inputNameEditable, inputEmailEditable, inputPhoneEditable, inputDatebirthdayEditable, inputDescriptionEditable;
    private TextInputLayout inputLayoutName, inputLayoutEmail, inputLayoutPhone, inputLayoutDatebirthday, inputLayoutDescription;
    private Button btnConfirmation;
    private DatePicker datePicker;
    private DatePickerDialog fromDatePickerDialog;
    private SimpleDateFormat dateFormatter;
    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputLayoutName = (TextInputLayout) findViewById(R.id.inf);
        inputLayoutDatebirthday = (TextInputLayout) findViewById(R.id.ibf);
        inputLayoutPhone = (TextInputLayout) findViewById(R.id.ipf);
        inputLayoutEmail = (TextInputLayout) findViewById(R.id.ief);
        inputLayoutDescription = (TextInputLayout) findViewById(R.id.idf);

        inputNameEditable = (EditText) findViewById(R.id.ine);
        inputDatebirthdayEditable = (EditText) findViewById(R.id.ibe);
        inputPhoneEditable = (EditText) findViewById(R.id.ipe);
        inputEmailEditable = (EditText) findViewById(R.id.iee);
        inputDescriptionEditable = (EditText) findViewById(R.id.ide);

        btnConfirmation = (Button) findViewById(R.id.btnConfirmation);
        dateFormatter = new SimpleDateFormat("d 'de' MMMM, yyyy", new Locale("es", "ES"));


        findViewsById();
        setDateTimeField();

    }

    private void findViewsById() {
        inputDatebirthdayEditable = (EditText) findViewById(R.id.ibe);
        inputDatebirthdayEditable.setInputType(InputType.TYPE_NULL);
    }

    private void setDateTimeField() {
        inputDatebirthdayEditable.setOnFocusChangeListener(this);

        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                inputDatebirthdayEditable.setText(dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        if (hasFocus)
            fromDatePickerDialog.show();
    }

    public void setBtnConfirmation(View view) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);

        intent.putExtra("pname", inputNameEditable.getText().toString());
        intent.putExtra("pbirthday", inputDatebirthdayEditable.getText().toString());
        intent.putExtra("pphone", inputPhoneEditable.getText().toString());
        intent.putExtra("pemail", inputEmailEditable.getText().toString());
        intent.putExtra("pdescription", inputDescriptionEditable.getText().toString());
        startActivity(intent);
        finish();
    }

}