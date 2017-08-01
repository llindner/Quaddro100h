package br.com.luizlindner.quaddro100h.lab01.app.controller;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import br.com.luizlindner.quaddro100h.R;

/**
 * Created by Luiz on 04/07/2017.
 */

public class SplashActivity extends QuaddroActivity {

    Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_view);

        handler = new Handler();
    }

    @Override
    protected void onResume() {
        super.onResume();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        }, 5000);

    }

    private void carregaFavoritos(){
        try(FileOutputStream fos = openFileOutput("favoritos.txt", 0); PrintWriter data = new PrintWriter(fos)){
            data.println("www.terra.com.br");
            data.println("www.mksnet.com.br");
        } catch (IOException cause){
            Log.e(TIPO_DE_LOG, "Ops...", cause);
        }

    }
}
