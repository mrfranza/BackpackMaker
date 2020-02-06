package com.mrfranza.backpack30;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.os.Handler;
import android.os.SystemClock;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.mrfranza.backpack30.GestoreNotifiche.CHANNEL_1_ID;
import static com.mrfranza.backpack30.GestoreNotifiche.CHANNEL_2_ID;

public class PrincipalMenu extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private Button snoozebtn;
    private static NotificationManagerCompat notificationManager;
    public static Context context2;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //FLOATING BUTTON ---> TIMER
        final FloatingActionButton fab = findViewById(R.id.floatingn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //OGGI?
                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_WEEK);
                MySQLiteHelper db = new MySQLiteHelper(getApplicationContext());

                switch (day) {
                    case Calendar.MONDAY:
                        // Current day is Sunday
                        String lunedi = db.DAI(1);
                        Toast.makeText(getApplicationContext(),lunedi,Toast.LENGTH_LONG).show();
                        sendOnChannel1("IL TUO ZAINO DEL LUNEDI' ! ",lunedi);
                        break;
                    case Calendar.TUESDAY:
                        // Current day is Monday
                        String martedi = db.DAI(2);
                        Toast.makeText(getApplicationContext(),martedi,Toast.LENGTH_LONG).show();
                        sendOnChannel1("IL TUO ZAINO DEL MARTEDI' ! ",martedi);
                        break;
                    case Calendar.WEDNESDAY:
                        // etc.
                        String mercoledi = db.DAI(3);
                        Toast.makeText(getApplicationContext(),mercoledi,Toast.LENGTH_LONG).show();
                        sendOnChannel1("IL TUO ZAINO DEL MERCOLEDI' ! ",mercoledi);
                        break;
                    case Calendar.THURSDAY:
                        String giovedi = db.DAI(4);
                        Toast.makeText(getApplicationContext(),giovedi,Toast.LENGTH_LONG).show();
                        sendOnChannel1("IL TUO ZAINO DEL GIOVEDI' ! ",giovedi);
                        break;
                    case Calendar.FRIDAY:
                        String venerdi = db.DAI(5);
                        Toast.makeText(getApplicationContext(),venerdi,Toast.LENGTH_LONG).show();
                        sendOnChannel1("IL TUO ZAINO DEL VENERDI' ! ",venerdi);
                        break;
                    case Calendar.SATURDAY:
                        String sabato = db.DAI(6);
                        Toast.makeText(getApplicationContext(),sabato,Toast.LENGTH_LONG).show();
                        sendOnChannel1("IL TUO ZAINO DEL SABATO' ! ",sabato);
                        break;
                    case Calendar.SUNDAY:
                        String domenica = db.DAI(7);
                        Toast.makeText(getApplicationContext(),domenica,Toast.LENGTH_LONG).show();
                        sendOnChannel1("IL TUO ZAINO DELLA DOMENICA' ! ",domenica);
                        break;
                        default:
                            Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
                            break;
                }
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery,
                R.id.nav_tools, R.id.nav_share)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        notificationManager = NotificationManagerCompat.from(this);
        context2 = this;


    }


    public static void sendOnChannel1(View v){
        Notification notification = new NotificationCompat.Builder(context2, CHANNEL_2_ID)
                .setSmallIcon(R.mipmap.ic_launcher_foreground)
                .setContentTitle("PROVA")
                .setContentText("PROVA TEXT")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_ALARM)
                .build();
        notificationManager.notify(1,notification);

    }
    public static void sendOnChannel1(String title,String content){
        Notification notification = new NotificationCompat.Builder(context2, CHANNEL_2_ID)
                .setSmallIcon(R.mipmap.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText(content)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_ALARM)
                //.setSound()
                .build();
        notificationManager.notify(1,notification);

    }
    public static void sendOnChannel1(){
        Notification notification = new NotificationCompat.Builder(context2, CHANNEL_2_ID)
                .setSmallIcon(R.mipmap.ic_launcher_foreground)
                .setContentTitle("PROVA")
                .setContentText("PROVA TEXT")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_ALARM)
                .build();
        notificationManager.notify(1,notification);

    }

    public static void sendOnChannel2(View v){
        Notification notification = new NotificationCompat.Builder(context2, CHANNEL_1_ID)
                .setSmallIcon(R.mipmap.ic_launcher_foreground)
                .setContentTitle("PROVA 2")
                .setContentText("PROVA 2 TEXT")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_ALARM)
                .build();
        notificationManager.notify(2,notification);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal_menu, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void InitiateTimePicker(final Context x){

        Calendar mcurrentTime = Calendar.getInstance();
        final int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        final int minute = mcurrentTime.get(Calendar.MINUTE);

        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(x, new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                MainActivity.SetTimeNotific(selectedHour + ":" + selectedMinute);
            }
            }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

    }
}
