package com.vmorenomarin.contapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

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

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

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

        contact = new Contact(MainActivity.this.inputLayoutName.getEditText().toString(), MainActivity.this.inputLayoutDatebirthday.getEditText().toString(),
                MainActivity.this.inputLayoutPhone.getEditText().toString(), MainActivity.this.inputLayoutEmail.getEditText().toString(), MainActivity.this.inputLayoutDescription.getEditText().toString());

        btnConfirmation = (Button) findViewById(R.id.btnConfirmation);


        dateFormatter = new SimpleDateFormat("d 'de' MMMM, yyyy", new Locale("es", "ES"));

        findViewsById();

        setDateTimeField();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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

        intent.putExtra("pname", contact.getName());
        intent.putExtra("pbirthday", contact.getBirthday());
        intent.putExtra("pphone", contact.getPhone());
        intent.putExtra("pemail", contact.getEmail());
        intent.putExtra("pdescription", contact.getDescription());
        startActivity(intent);
        finish();
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.vmorenomarin.contapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.vmorenomarin.contapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}