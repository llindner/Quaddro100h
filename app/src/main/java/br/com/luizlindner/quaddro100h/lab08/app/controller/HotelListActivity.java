package br.com.luizlindner.quaddro100h.lab08.app.controller;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroActivity;

/**
 * Created by Mobile on 26/07/2017.
 */

public class HotelListActivity extends QuaddroActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.hotel_listar_view);
    }
}
