package br.com.luizlindner.quaddro100h.lab02.app.controller;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroActivity;

/**
 * Created by Luiz on 06/07/2017.
 */

public class MegasenaActivity extends QuaddroActivity {
    SeekBar sbSorteios;
    TextView txtSorteios;
    Button btnSortear;
    ArrayList<String> sorteadas;
    ListView listaDeSorteios;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.megasena_view);

        sbSorteios = (SeekBar)findViewById(R.id.sb_sorteios);
        txtSorteios = (TextView)findViewById(R.id.txt_num_sorteios);
        btnSortear = (Button)findViewById(R.id.btn_sortear);
        listaDeSorteios = (ListView)findViewById(R.id.lv_sorteios);
        sorteadas = new ArrayList<String>();

        sbSorteios.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtSorteios.setText("Sorteios: " + String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnSortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int progress = sbSorteios.getProgress();
                if(progress != 0) {
                    onClickSort(progress);
                }
            }
        });
    }

    private void onClickSort(int progress) {
        sorteadas.clear();
        while(sorteadas.size() < progress){
            Random r = new Random();
            int next = r.nextInt(61);
            if(!sorteadas.contains(next)) {
                sorteadas.add(String.valueOf(next));
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, sorteadas);
        listaDeSorteios.setAdapter(adapter);

        Log.i("Sorteada: ", "------------------");
        for (String sorteada: sorteadas){
            Log.i("Sorteada: ", String.valueOf(sorteada));
        }


    }


}
