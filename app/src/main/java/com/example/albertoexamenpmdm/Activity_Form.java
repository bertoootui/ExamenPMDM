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
    long time[] = new long[3];
    long time1[] = new long[3];
    long time2[] = new long[3];
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

            date = new Date();
            contw++;
            if(contw ==1)
            {
                time[0] = date.getTime();
            }
            else if(contw ==2)
            {
                if(date.getTime()>(time[0]+15)) time[1] = date.getTime();
                else contw = 0;
            }
            else if(contw ==3)
            {
                if(date.getTime()>(time[1]+15)) time[2] = date.getTime();
                else contw = 0;
            }
            if(contw == 3){
                time[0] = 0;
                time[1] = 0;
                time[2] = 0;
                txtnombre.setText("PLAYER365");
            }


        }
        else if(item.getTitle().equals("E"))
        {
            date = new Date();
            conte++;
            if(conte ==1)
            {
                time1[0] = date.getTime();
            }
            else if(conte ==2)
            {
                if(date.getTime()>(time1[0]+15)) time1[1] = date.getTime();
                else conte = 0;
            }
            else if(conte ==3)
            {
                if(date.getTime()>(time1[1]+15)) time1[2] = date.getTime();
                else conte = 0;
            }
            if(conte == 3){
                time1[0] = 0;
                time1[1] = 0;
                time1[2] = 0;
                txtemail.setText("player365@thegame.com");
            }
        }
        else if(item.getTitle().equals("W"))
        {
            date = new Date();
            contn++;
            if(contn ==1)
            {
                time2[0] = date.getTime();
            }
            else if(contn ==2)
            {
                if(date.getTime()>(time2[0]+15)) time2[1] = date.getTime();
                else contn = 0;
            }
            else if(contn ==3)
            {
                if(date.getTime()>(time2[1]+15)) time2[2] = date.getTime();
                else contn = 0;
            }
            if(contn == 3){
                time2[0] = 0;
                time2[1] = 0;
                time2[2] = 0;
                txtpass.setText("youAreTheOne");
            }
        }



        return true;
    }
}//end Class
