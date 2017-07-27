package br.com.luizlindner.quaddro100h.lab08.app.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroActivity;
import br.com.luizlindner.quaddro100h.lab08.domain.model.Hotel;

/**
 * Created by Luiz on 26/07/2017.
 */

public class HotelActivity extends QuaddroActivity {
    FragmentManager fm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.hotel_view);

        fm = getSupportFragmentManager();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Hotel model;
        HotelFragment hotelFragment;
        FragmentTransaction ft;

        model = (Hotel) getIntent().getSerializableExtra("hotel");
        hotelFragment = new HotelFragment();
        Bundle b = new Bundle();
        Log.i("Chegou aqui", model.toString());
        b.putSerializable("hotel", model);
        hotelFragment.setArguments(b);

        ft = fm.beginTransaction();
        ft.replace(R.id.detalhe, hotelFragment, "LAB");

        ft.commit();
    }
}
