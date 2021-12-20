package com.example.albertoexamenpmdm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Activity_Form extends AppCompatActivity {
    EditText txtnombre, txtemail, txtpass;
    FloatingActionButton butnext;
    Button butmenu;
    int contn, conte,contw;
    long conttn, contte, conttw;
    Date date;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        txtemail = findViewById(R.id.txtemail);
        txtnombre = findViewById(R.id.txtnombre);
        txtpass = findViewById(R.id.txtemail);
        butnext = findViewById(R.id.butnext);
        butmenu = findViewById(R.id.butmenu);
        conte = 0;
        contn = 0;
        contw = 0;
        contte = 0;
        conttw = 0;
        conttn = 0;
        registerForContextMenu(butmenu);

        date = new Date();

        butnext.setOnClickListener(v -> {
            String nombre = txtnombre.getText().toString();
            Intent i = new Intent(Activity_Form.this,Activity_game.class);
            Bundle b = new Bundle();
            b.putString("nombre", nombre);
            i.putExtras(b);
            startActivity(i);
            finish();



        });
    }//end onCreate

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("CHECK THIS");
        menu.add(0, v.getId(),0,"N");
        menu.add(0, v.getId(),0,"E");
        menu.add(0, v.getId(),0,"W");
        menu.add(0, v.getId(),0,"S");

    }
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle().equals("N"))
        {
            long date1, date2, date3;
            date = new Date();
            contw++;
            if(contw ==1)
            {
                date1 = date.getTime();
            }


        }
        else if(item.getTitle().equals("E"))
        {
            conte++;
        }
        else if(item.getTitle().equals("W"))
        {
            contw++;
        }



        return true;
    }
}//end Class
