package br.com.luizlindner.quaddro100h.lab01.app.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Luiz on 04/07/2017.
 */

public abstract class QuaddroActivity extends AppCompatActivity {
    public static final String TIPO_DE_LOG = "LAB";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TIPO_DE_LOG, "Passei pelo onCreate em: " + getClass().getSimpleName());
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TIPO_DE_LOG, "Passei pelo onStart em: " + getClass().getSimpleName());
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TIPO_DE_LOG, "Passei pelo onResume em: " + getClass().getSimpleName());
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TIPO_DE_LOG, "Passei pelo onPause em: " + getClass().getSimpleName());
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TIPO_DE_LOG, "Passei pelo onStop em: " + getClass().getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TIPO_DE_LOG, "Passei pelo onDestroy em: " + getClass().getSimpleName());
    }

    protected void setOnClickActivity(int id, final Class<?> c) {
        View v = findViewById(id);
        setOnClickActivity(v, c);
    }

    protected void setOnClickActivity(View v, final Class<?> c){
        if(v != null) {
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle anim = ActivityOptionsCompat.makeScaleUpAnimation(v, 0, 0, v.getWidth(), v.getHeight()).toBundle();
                    startActivity(new Intent(getApplicationContext(), c), anim);
                }
            });
        }
    }

    public <T extends View> T getViewById(int id){
        return (T)findViewById(id);
    }

}
