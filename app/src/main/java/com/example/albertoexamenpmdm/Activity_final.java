package com.example.albertoexamenpmdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Activity_final extends AppCompatActivity {
    TextView txtfinal;
    FloatingActionButton butback;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        txtfinal = findViewById(R.id.txtfinal);
        butback = findViewById(R.id.butback);
        Intent geti = getIntent();
        int cont = geti.getIntExtra("cont",0);
        if(cont == 6) txtfinal.setText("HAS GANADO");
        else txtfinal.setText("HAS PERDIDO");

        butback.setOnClickListener(v -> {
            Intent i = new Intent(Activity_final.this, Activity_game.class);
            startActivity(i);
            finish();
        });

    }
}
