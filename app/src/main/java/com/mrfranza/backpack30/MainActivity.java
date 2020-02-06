package com.mrfranza.backpack30;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {

    public static String time = "";

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public static void SetTimeNotific(String s){
        time = s;
    }
    public static String GetTimeNotific(){
        return time;
    }
}

