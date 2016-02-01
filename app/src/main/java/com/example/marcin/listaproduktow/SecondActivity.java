package com.example.marcin.listaproduktow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle intentExtras = getIntent().getExtras();
        String username = intentExtras.getString("username");
        String password = intentExtras.getString("password");
        TextView helloView = (TextView) findViewById(R.id.hello);
        helloView.setText("Witaj " + username + "!");
    }

}

