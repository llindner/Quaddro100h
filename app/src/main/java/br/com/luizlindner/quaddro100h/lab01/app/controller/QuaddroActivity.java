package br.com.luizlindner.quaddro100h.lab01.app.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Mobile on 04/07/2017.
 */

public class QuaddroActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("SPLASH", "Passei pelo onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i("SPLASH", "Passei pelo onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("SPLASH", "Passei pelo onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i("SPLASH", "Passei pelo onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i("SPLASH", "Passei pelo onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("SPLASH", "Passei pelo onDestroy");
    }

}
