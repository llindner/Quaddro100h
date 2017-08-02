package br.com.luizlindner.quaddro100h.lab01.app.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab02.app.controller.MegasenaActivity;
import br.com.luizlindner.quaddro100h.lab03.app.controller.TictactoeActivity;
import br.com.luizlindner.quaddro100h.lab04.app.controller.EnderecoListarActivity;
import br.com.luizlindner.quaddro100h.lab05.app.controller.AnimacaoActivity;
import br.com.luizlindner.quaddro100h.lab06.app.controller.AnimacaoQuaddroActivity;
import br.com.luizlindner.quaddro100h.lab07.app.controller.StarwarsListarActivity;
import br.com.luizlindner.quaddro100h.lab08.app.controller.HotelListActivity;
import br.com.luizlindner.quaddro100h.lab09.app.controller.NotificationActivity;
import br.com.luizlindner.quaddro100h.lab11.app.controller.SensorActivity;
import br.com.luizlindner.quaddro100h.lab99.app.controller.CameraActivity;

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
        setOnClickActivity(R.id.btn_endereco, EnderecoListarActivity.class);
        setOnClickActivity(R.id.btn_animacao, AnimacaoActivity.class);
        setOnClickActivity(R.id.btn_animacao_quaddro, AnimacaoQuaddroActivity.class);
        setOnClickActivity(R.id.btn_starwars, StarwarsListarActivity.class);
        setOnClickActivity(R.id.btn_fragment, HotelListActivity.class);
        setOnClickActivity(R.id.btn_notificacao, NotificationActivity.class);
        setOnClickActivity(R.id.btn_sensores, SensorActivity.class);
        setOnClickActivity(R.id.btn_camera, CameraActivity.class);
    }

}
