package br.com.luizlindner.quaddro100h.lab09.app.controller;

import android.app.Notification;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.NotificationCompat;
import android.view.View;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroActivity;

/**
 * Created by Mobile on 27/07/2017.
 */

public class NotificationActivity extends QuaddroActivity {

    NotificationManagerCompat nm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.notification_view);
        nm = NotificationManagerCompat.from(this);
    }

    public void notificarSimples(View v){
        Notification n;
        n = new NotificationCompat.Builder(this)
                .setDefaults(Notification.DEFAULT_ALL)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Titulo")
                .setContentText("Texto que eu quiser")
                .setVibrate(new long[]{ 800, 400, 800, 400 })
                .build();

        nm.notify(100, n);
    }

    public void notificarCompleto(View v){

    }

    public void notificarTipoUber(View v){

    }
}
