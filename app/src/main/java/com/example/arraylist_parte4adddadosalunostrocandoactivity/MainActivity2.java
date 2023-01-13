package com.example.arraylist_parte4adddadosalunostrocandoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView textName, textAddress, textEmail;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textName = findViewById(R.id.textName);
        textAddress = findViewById(R.id.textAddress);
        textEmail = findViewById(R.id.textEmail);

        i = getIntent();

        textName.setText(i.getExtras().getString("name"));
        textAddress.setText(i.getExtras().getString("address"));
        textEmail.setText(i.getExtras().getString("email"));
    }
}