package com.example.chint.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBHelper helper;
    EditText phone;
    EditText psw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new DBHelper(this);
        phone = (EditText)findViewById(R.id.phone);
        psw = (EditText)findViewById(R.id.psw);
    }
    public void onSigninClicked(View v){
        String number = phone.getText().toString();
        String password = psw.getText().toString();
        String pass = helper.importFunction(number);
        if(password.equals(pass))
            Toast.makeText(this, "Success", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Fail", Toast.LENGTH_LONG).show();
        phone.setText("");
        psw.setText("");
    }
}
