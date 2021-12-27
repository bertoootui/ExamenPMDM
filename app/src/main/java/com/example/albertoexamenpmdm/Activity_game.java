package com.example.albertoexamenpmdm;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class Activity_game extends AppCompatActivity {
    Button butclean, butres, butcheck;
    EditText txtjirafa, txtcebra, txtcoc, txtleon, txteli,txtpiton;
    TextView txtcont;
    ImageView imgjirafa, imgcebra, imgcoc, imgleon,imgeli,imgpiton;
    Date d = new Date();
    Handler handler;
    long time1, time2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic);
        time1 = d.getTime();
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
        imgcebra = findViewById(R.id.imgcebra);
        imgcoc = findViewById(R.id.imgcoc);
        imgeli = findViewById(R.id.imgeli);
        imgjirafa = findViewById(R.id.imgjirafa);
        imgpiton = findViewById(R.id.imgpiton);
        imgleon = findViewById(R.id.imglion);

        final int[] cont = {0};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("TOCA MEMORIZAR");
        builder.setMessage("Los campos ser rellenan con una sola palabra en minúsculas y si tíldes");
        builder.setPositiveButton("OK", (dialog, which) -> {
            handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    imgpiton.setVisibility(View.INVISIBLE);
                    imgcebra.setVisibility(View.INVISIBLE);
                    imgcoc.setVisibility(View.INVISIBLE);
                    imgeli.setVisibility(View.INVISIBLE);
                    imgjirafa.setVisibility(View.INVISIBLE);
                    imgleon.setVisibility(View.INVISIBLE);

                }
            },3500);
        });
        builder.show();



        butcheck.setOnClickListener(v -> {
            cont[0] = 0;
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
            if(cont[0]>3) {
                txtpiton.setHint("piton");
                txtcebra.setHint("cebra");
                txtjirafa.setHint("jirafa");
                txtcoc.setHint("cocodrilo");
                txteli.setHint("elefante");
                txtleon.setHint("leon");
            }

        });

        butclean.setOnClickListener(v -> {
            txtpiton.setText("");
            txtcebra.setText("");
            txtjirafa.setText("");
            txtcoc.setText("");
            txteli.setText("");
            txtleon.setText("");
            txtcont.setText("");
            txtpiton.setHint("");
            txtcebra.setHint("");
            txtjirafa.setHint("");
            txtcoc.setHint("");
            txteli.setHint("");
            txtleon.setHint("");
            cont[0] = 0;

        });


    }
}
