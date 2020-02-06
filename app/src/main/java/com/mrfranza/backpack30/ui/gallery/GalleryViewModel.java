package com.mrfranza.backpack30.ui.gallery;


import android.app.TimePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mrfranza.backpack30.MainActivity;

import java.util.Calendar;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Selezziona Un'Orario in cui \n Ricevere la notifica contenente la lista.(Piccolo consiglio: \n Metti l'orario in cui ti svegli.)");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void InitiateTimePicker(final Context x, final Button y){

        Calendar mcurrentTime = Calendar.getInstance();
        final int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        final int minute = mcurrentTime.get(Calendar.MINUTE);

        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(x, new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        MainActivity.SetTimeNotific(selectedHour + ":" + selectedMinute);
                        y.setText(selectedHour + ":" + selectedMinute);
                    }

                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });


    }
}

