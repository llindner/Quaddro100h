package br.com.luizlindner.quaddro100h.lab02.app.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroActivity;
import br.com.luizlindner.quaddro100h.lab02.domain.model.Megasena;

/**
 * Created by Luiz on 06/07/2017.
 */

public class MegasenaActivity extends QuaddroActivity {
    SeekBar sbSorteios;
    TextView txtNumSorteios;
    ListView listaDeSorteios;
    final int corretorSeekBar = 1;
    Integer jogos;
    ArrayList<String> lista;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.megasena_view);

        sbSorteios = (SeekBar)findViewById(R.id.sb_sorteios);
        txtNumSorteios = (TextView)findViewById(R.id.txt_num_sorteios);
        listaDeSorteios = (ListView)findViewById(R.id.lv_sorteios);

        sbSorteios.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtNumSorteios.setText(String.valueOf(progress + corretorSeekBar));
                jogos = progress + corretorSeekBar;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        jogos = sbSorteios.getProgress() + corretorSeekBar;
        lista = new ArrayList<String>();

        if(savedInstanceState != null){
            sbSorteios.setProgress(savedInstanceState.getInt("jogos"));
            lista = savedInstanceState.getStringArrayList("lista");
            publicar();
        }
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("jogos", jogos);
        outState.putStringArrayList("lista", lista);
    }

    public void sortear(View v){
        lista = Megasena.sortear(jogos);
        publicar();
    }

    private void publicar() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.linha_sorteio_view, R.id.textItem, lista);
        listaDeSorteios.setAdapter(adapter);
    }

}
