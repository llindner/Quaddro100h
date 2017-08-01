package br.com.luizlindner.quaddro100h.lab10.app.service;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.RemoteViews;

import java.util.HashMap;
import java.util.Map;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab10.app.receiver.FavoritosWidget;

/**
 * Created by Mobile on 31/07/2017.
 */

public class FavoritosService extends Service {

    private String[] sites = {
            "www.google.com.br",
            "www.fb.com",
            "www.pombaloca.com.br",
            "www.youtube.com",
            "www.android.com"
    };

    private Map<Integer, Integer> states;

    @Override
    public void onCreate() {
        super.onCreate();

        states = new HashMap<>();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent != null){
            String acao;
            int id, pos;
            pos = 0;
            RemoteViews views;

            id = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
            acao = intent.getStringExtra(FavoritosWidget.Extras.ACTION);
            Log.i("LAB", "Chegou aqui" + acao);

            if(acao != null){
                switch (acao){
                    case FavoritosWidget.Actions.ANTERIOR:
                    case FavoritosWidget.Actions.PROXIMO:
                        views = new RemoteViews(getPackageName(), R.layout.favoritos_view);

                        pos = getPos(acao, id);
                        views.setTextViewText(R.id.txt_link, sites[pos]);
                        AppWidgetManager appwm;
                        appwm = AppWidgetManager.getInstance(this);


                        appwm.updateAppWidget(id, views);
                        break;
                    case FavoritosWidget.Actions.EXCLUIR:
                        int[] ids = intent.getIntArrayExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS);
                        for(int i  : ids){
                            states.remove(i);
                        }
                        break;
                    case FavoritosWidget.Actions.SITE:
                        pos = states.get(id);
                        Intent ii = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + sites[pos]));
                        ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(ii);
                        break;
                }
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private int getPos(String acao, int id) {
        int pos = 0;
        if(states.containsKey(id)){
            pos = states.get(id);
        } else {
            states.put(id, pos);
            return pos;
        }

        if(FavoritosWidget.Actions.ANTERIOR.equals(acao)){
            pos++;
            pos = pos >= sites.length ? 0 : pos;
        } else if(FavoritosWidget.Actions.PROXIMO.equals(acao)){
            pos--;
            pos = pos < 0 ? sites.length -1 : pos;
        }

        states.put(id, pos);
        return pos;
    }
}
