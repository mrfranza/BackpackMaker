package com.mrfranza.backpack30;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SuppressLint("Registered")
public class SendDataService extends Service {
    private final LocalBinder mBinder = new LocalBinder();
    private Handler mToastHandler = null;

    public class LocalBinder extends Binder {
        public SendDataService getService() {
            return SendDataService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        final Handler ha=new Handler();


        Runnable r = new Runnable() {
            @Override
            public void run() {
                PrincipalMenu.sendOnChannel1();
            }
        };

        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(r, 0, 5, TimeUnit.SECONDS);

        return Service.START_STICKY;
    }

}