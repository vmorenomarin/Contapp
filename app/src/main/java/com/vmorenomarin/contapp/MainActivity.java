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
import android.text.TextWatcher;  //valida el texto ingresado.
import android.view.View;
import android.view.WindowManager;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText inputNameEditable, inputEmailEditable, inputPhoneEditable, inputDatebirthdayEditable, inputDescriptionEditable;
    private TextInputLayout inputLayoutName, inputLayoutEmail, inputLayoutPhone, inputLayoutDatebirthday, inputLayoutDescription;
    private Button btnConfirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputLayoutName     = (TextInputLayout) findViewById(R.id.inf);
        inputLayoutDatebirthday =   (TextInputLayout) findViewById(R.id.idf);
        inputLayoutPhone    = (TextInputLayout) findViewById(R.id.ipf);
        inputLayoutEmail    = (TextInputLayout) findViewById(R.id.ief);
        inputLayoutDescription  = (TextInputLayout) findViewById(R.id.idf);

        inputNameEditable   = (TextInputEditText) findViewById(R.id.ine);
        inputDatebirthdayEditable   =   (TextInputEditText) findViewById(R.id.ibe);
        inputPhoneEditable  =   (TextInputEditText) findViewById(R.id.ipe);
        inputEmailEditable  =   (TextInputEditText) findViewById(R.id.iee);
        inputDescriptionEditable    =   (TextInputEditText) findViewById(R.id.ide);

        btnConfirmation =   (Button) findViewById(R.id.btnConfirmation);





    }


}
