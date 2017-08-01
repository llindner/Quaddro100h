package br.com.luizlindner.quaddro100h.lab10.app.receiver;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab10.app.service.FavoritosService;

/**
 * Created by Luiz on 31/07/2017.
 */

public class FavoritosWidget extends AppWidgetProvider {

    public interface Extras {
        String ACTION = "acao";
    }

    public interface Actions {
        String ANTERIOR = "anterior";
        String PROXIMO = "proximo";
        String EXCLUIR = "apagar";
        String SITE = "site";
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.favoritos_view);
        PendingIntent pendingIntent;
        Intent intent;

        for (int i = 0; i < appWidgetIds.length; i++){
            intent = new Intent(Actions.ANTERIOR);
            intent.putExtra(Extras.ACTION, Actions.ANTERIOR);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[i]);
            pendingIntent = PendingIntent.getService(context, appWidgetIds[i], intent, 0);
            views.setOnClickPendingIntent(R.id.btn_anterior, pendingIntent);

            intent = new Intent(Actions.PROXIMO);
            intent.putExtra(Extras.ACTION, Actions.PROXIMO);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[i]);
            pendingIntent = PendingIntent.getService(context, appWidgetIds[i], intent, 0);
            views.setOnClickPendingIntent(R.id.btn_proximo, pendingIntent);

            intent = new Intent(Actions.SITE);
            intent.putExtra(Extras.ACTION, Actions.SITE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[i]);
            pendingIntent = PendingIntent.getService(context, appWidgetIds[i], intent, 0);
            views.setOnClickPendingIntent(R.id.txt_link, pendingIntent);
        }

        appWidgetManager.updateAppWidget(appWidgetIds, views);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        Intent i = new Intent(context, FavoritosService.class);
        i.putExtra(Extras.ACTION, Actions.EXCLUIR);
        i.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        context.stopService(new Intent(context, FavoritosService.class));
    }
}
