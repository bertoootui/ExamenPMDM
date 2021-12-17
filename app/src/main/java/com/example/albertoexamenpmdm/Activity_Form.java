package com.example.albertoexamenpmdm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Activity_Form extends AppCompatActivity {
    EditText txtnombre, txtemail, txtpass;
    FloatingActionButton butnext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        txtemail = findViewById(R.id.txtemail);
        txtnombre = findViewById(R.id.txtnombre);
        txtpass = findViewById(R.id.txtemail);
        butnext = findViewById(R.id.butnext);

        butnext.setOnClickListener(v -> {
            String nombre = txtnombre.getText().toString();
            Intent i = new Intent(Activity_Form.this,Activity_game.class);
            Bundle b = new Bundle();
            b.putString("nombre", nombre);
            i.putExtras(b);
            startActivity(i);
            finish();



        });
    }
}
