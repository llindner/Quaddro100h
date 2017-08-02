package br.com.luizlindner.quaddro100h.lab01.app.controller;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab10.app.util.PermissionHelper;

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

        carregarFavoritos();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        }, 5000);
    }

    private void carregarFavoritos(){
        boolean isOk = PermissionHelper.checkPermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE, 1000);

        if(isOk) {
            tratarArquivo();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1000:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    tratarArquivo();
                }
                break;
        }
    }

    private void tratarArquivo() {
        try(FileOutputStream fos = openFileOutput("favoritos.txt", 0); PrintWriter data = new PrintWriter(fos)){
            data.println("www.terra.com.br");
            data.println("www.mksnet.com.br");
        } catch (IOException cause){
            Log.e(TIPO_DE_LOG, "Ops...", cause);
        }

        try{
            File sd = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            Log.d(TIPO_DE_LOG, sd.getAbsolutePath());
            File arq = new File(sd, "favoritosSD.txt");
            InputStream is;
            OutputStream os;
            Reader r;
            Writer w;
            try(FileWriter des = new FileWriter(arq); BufferedWriter dataOut = new BufferedWriter(des); FileInputStream ori = openFileInput("favoritos.txt"); DataInputStream dataIn = new DataInputStream(ori)){
                String line;
                while(dataIn.available() > 0) {
                    line = dataIn.readLine();
                    Log.d(TIPO_DE_LOG, "Linha: " + line);
                    dataOut.write(line);
                }
                dataOut.flush();
            }
        } catch (Exception cause){
            Log.e(TIPO_DE_LOG, "Ops...", cause);
        }
    }
}
