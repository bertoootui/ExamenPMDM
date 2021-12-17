package com.example.albertoexamenpmdm;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicInteger;

public class Activity_game extends AppCompatActivity {
    Button butclean, butres, butcheck;
    EditText txtjirafa, txtcebra, txtcoc, txtleon, txteli,txtpiton;
    TextView txtcont;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic);
        txtcoc = findViewById(R.id.txtcoc);
        txtjirafa = findViewById(R.id.txtjirafa);
        txtcebra = findViewById(R.id.txtcebra);
        txtleon = findViewById(R.id.txtleon);
        txteli = findViewById(R.id.txteli);
        txtpiton = findViewById(R.id.txtpiton);
        txtcont = findViewById(R.id.txtcont);
        butcheck= findViewById(R.id.butcheck);
        butclean = findViewById(R.id.butclean);
        butres = findViewById(R.id.butres);
        final int[] cont = {0};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("INSTRUCCIONES DE USO");
        builder.setMessage("Los campos ser rellenan con una sola palabra en minúsculas y si tíldes");
        builder.setPositiveButton("OK", (dialog, which) -> {});
        builder.show();
        butcheck.setOnClickListener(v -> {
            if((txtpiton.getText().toString()).equals("piton")) {cont[0]++;}

            if((txtcoc.getText().toString()).equals("cocodrilo")) cont[0]++;
            if(txtjirafa.getText().toString().equals("jirafa")) cont[0]++;
            if(txtcebra.getText().toString().equals("cebra")) cont[0]++;
            if(txteli.getText().toString().equals("elefante")) cont[0]++;
            if(txtleon.getText().toString().equals("leon")) cont[0]++;
            txtcont.setText(String.valueOf(cont[0]));
            if(cont[0] == 6 || cont[0] == 0)
            {
                Intent i = new Intent(Activity_game.this, Activity_final.class);
                i.putExtra("cont", cont[0]);
                startActivity(i);
                finish();
            }

        });

        butres.setOnClickListener(v -> {
            txtpiton.setText("piton");
            txtcebra.setText("cebra");
            txtjirafa.setText("jirafa");
            txtcoc.setText("cocodrilo");
            txteli.setText("elefante");
            txtleon.setText("leon");


        });

        butclean.setOnClickListener(v -> {
            txtpiton.setText("");
            txtcebra.setText("");
            txtjirafa.setText("");
            txtcoc.setText("");
            txteli.setText("");
            txtleon.setText("");
            txtcont.setText("");
            cont[0] = 0;

        });


    }
}
