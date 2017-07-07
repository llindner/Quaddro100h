package br.com.luizlindner.quaddro100h.lab03.app.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroActivity;

/**
 * Created by Mobile on 06/07/2017.
 */

public class TictactoeActivity extends QuaddroActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe_view);
    }
}
