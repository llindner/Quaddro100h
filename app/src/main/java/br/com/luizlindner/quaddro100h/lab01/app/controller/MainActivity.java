package br.com.luizlindner.quaddro100h.lab01.app.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab02.app.controller.MegasenaActivity;
import br.com.luizlindner.quaddro100h.lab03.app.controller.TictactoeActivity;
import br.com.luizlindner.quaddro100h.lab04.app.controller.EnderecoActivity;
import br.com.luizlindner.quaddro100h.lab05.app.controller.AnimacaoActivity;

/**
 * Created by Luiz on 04/07/2017.
 */

public class MainActivity extends QuaddroActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_view);

        setOnClickActivity(R.id.btn_megasena, MegasenaActivity.class);
        setOnClickActivity(R.id.btn_tictactoe, TictactoeActivity.class);
        setOnClickActivity(R.id.btn_endereco, EnderecoActivity.class);
        setOnClickActivity(R.id.btn_animacao, AnimacaoActivity.class);
    }

}
