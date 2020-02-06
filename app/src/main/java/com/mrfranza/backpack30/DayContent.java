package com.mrfranza.backpack30;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DayContent extends AppCompatActivity {
    public static MySQLiteHelper db = null;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_content);
        db = new MySQLiteHelper(this);

        final EditText et = findViewById(R.id.dayofweekitemspos);


        final Intent itnt = getIntent();
        if(itnt.hasExtra("name_of_day_of_week")){

            String m = itnt.getStringExtra("name_of_day_of_week");
            switch (m){
                case "1":
                    et.setText(db.DAI(1));
                    break;
                case "2":
                    et.setText(db.DAI(2));
                    break;
                case "3":;
                    et.setText(db.DAI(3));
                    break;
                case "4":
                    et.setText(db.DAI(4));
                    break;
                case "5":
                    et.setText(db.DAI(5));
                    break;
                case "6":
                    et.setText(db.DAI(6));
                    break;
                case "7":
                    et.setText(db.DAI(7));
                    break;
            }


            final FloatingActionButton continua = findViewById(R.id.permevabene);
            continua.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String g = itnt.getStringExtra("name_of_day_of_week");
                    switch (g){
                        case "1":
                            db.Aggiungi(et.getText().toString(),1);
                            break;
                        case "2":
                            db.Aggiungi(et.getText().toString(),2);
                            break;
                        case "3":;
                            db.Aggiungi(et.getText().toString(),3);
                            break;
                        case "4":
                            db.Aggiungi(et.getText().toString(),4);
                            break;
                        case "5":
                            db.Aggiungi(et.getText().toString(),5);
                            break;
                        case "6":
                            db.Aggiungi(et.getText().toString(),6);
                            break;
                        case "7":
                            db.Aggiungi(et.getText().toString(),7);
                            break;
                    }
                }
            });
        }

    }
    public static MySQLiteHelper getDB(){
        return db;
    }
}
