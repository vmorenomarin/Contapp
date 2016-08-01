package com.vmorenomarin.contapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
//import android.widget.EditText;
import android.support.design.widget.TextInputEditText;
import android.text.Editable;
import android.widget.Toast;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText inputNameEditable, inputEmailEditable, inputPhoneEditable, inputDatebirthdayEditable, inputDescriptionEditable;
    private TextInputLayout inputLayoutName, inputLayoutEmail, inputLayoutPhone, inputLayoutDatebirthday, inputLayoutDescription;
    private Button btnConformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
