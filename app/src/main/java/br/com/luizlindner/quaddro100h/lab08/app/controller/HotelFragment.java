package br.com.luizlindner.quaddro100h.lab08.app.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroFragment;
import br.com.luizlindner.quaddro100h.lab08.domain.model.Hotel;

/**
 * Created by Luiz on 26/07/2017.
 */

public class HotelFragment extends QuaddroFragment {
    TextView nomeView, enderecoView;
    RatingBar estrelasView;
    Hotel model;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = (Hotel) getArguments().getSerializable("hotel");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.hotel_fragment_view, container, false);
        nomeView = (TextView) layout.findViewById(R.id.hotelNome);
        enderecoView = (TextView) layout.findViewById(R.id.hotelEndereco);
        estrelasView = (RatingBar)layout.findViewById(R.id.hotelEstrelas);

        if(model != null){
            nomeView.setText(model.getNome());
            enderecoView.setText(model.getEndereco());
            estrelasView.setRating(model.getEstrelas());
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
