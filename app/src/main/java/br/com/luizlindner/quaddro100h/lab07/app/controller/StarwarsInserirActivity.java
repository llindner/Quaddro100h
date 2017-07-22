package br.com.luizlindner.quaddro100h.lab07.app.controller;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroActivity;

/**
 * Created by Luiz on 21/07/2017.
 */

public class StarwarsInserirActivity extends QuaddroActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starwars_inserir_view);
    }

    public void buscarId(View v){
        Toast.makeText(this, "DEU", Toast.LENGTH_LONG).show();
    }
}
