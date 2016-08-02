package com.vmorenomarin.contapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
//import android.widget.EditText;
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

    private TextInputEditText inputNameEditable, inputEmailEditable, inputPhoneEditable, inputDatebirthdayEditable, inputDescriptionEditable;
    private TextInputLayout inputLayoutName, inputLayoutEmail, inputLayoutPhone, inputLayoutDatebirthday, inputLayoutDescription;
    private Button btnConfirmation;
    private DatePicker datePicker;
    private DatePickerDialog fromDatePickerDialog;
    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputLayoutName = (TextInputLayout) findViewById(R.id.inf);
//        inputLayoutDatebirthday = (TextInputLayout) findViewById(R.id.ibf);
        inputLayoutPhone = (TextInputLayout) findViewById(R.id.ipf);
        inputLayoutEmail = (TextInputLayout) findViewById(R.id.ief);
        inputLayoutDescription = (TextInputLayout) findViewById(R.id.idf);

        inputNameEditable = (TextInputEditText) findViewById(R.id.ine);
//        inputDatebirthdayEditable = (TextInputEditText) findViewById(R.id.ibe);
        inputPhoneEditable = (TextInputEditText) findViewById(R.id.ipe);
        inputEmailEditable = (TextInputEditText) findViewById(R.id.iee);
        inputDescriptionEditable = (TextInputEditText) findViewById(R.id.ide);

        btnConfirmation = (Button) findViewById(R.id.btnConfirmation);

        //datePicker = (DatePicker) findViewById(R.id.datePicker);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        findViewsById();

        setDateTimeField();

    }

    private void findViewsById() {
        inputDatebirthdayEditable = (TextInputEditText) findViewById(R.id.ibe);
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
        if(hasFocus)
        fromDatePickerDialog.show();
    }
}