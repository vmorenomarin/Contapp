package com.vmorenomarin.contapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.KeyEvent;
import android.support.design.widget.TextInputEditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Main2Activity extends AppCompatActivity {

    Button  btnEdit;
    TextView tvName;
    TextView tvBirthday;
    TextView tvPhone;
    TextView tvEmail;
    TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        Intent intent=getIntent();
        Bundle parametros = getIntent().getExtras();

        String name = parametros.getString("pname");
        String birthday= parametros.getString("pbirthday");
        String phone = parametros.getString("pphone");
        String email = parametros.getString("pemail");
        String description = parametros.getString("pdescription");

        tvName      = (TextView)    findViewById(R.id.tvName);
        tvBirthday  = (TextView)    findViewById(R.id.tvBirthday);
        tvPhone     = (TextView)    findViewById(R.id.tvPhone);
        tvEmail     = (TextView)    findViewById(R.id.tvEmail);
        tvDescription   =   (TextView)  findViewById(R.id.tvDescription);

        tvName.setText(name);
        tvBirthday.setText(birthday);
        tvPhone.setText(phone);
        tvEmail.setText(email);
        tvDescription.setText(description);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(Main2Activity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }


    public void setBtnEdit(View view){
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);

        intent.putExtra("pname", tvName.getText().toString());
        intent.putExtra("pbirthday", tvBirthday.getText().toString());
        intent.putExtra("pphone", tvPhone.getText().toString());
        intent.putExtra("pemail", tvEmail.getText().toString());
        intent.putExtra("pdescription", tvDescription.getText().toString());

        startActivity(intent);

        this.finish();

    }



}
