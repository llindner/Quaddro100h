package br.com.luizlindner.quaddro100h.lab06.app.controller;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.widget.ImageView;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroActivity;

/**
 * Created by Mobile on 14/07/2017.
 */

public class AnimacaoQuaddroActivity extends QuaddroActivity{

    ImageView spriteMegaman;
    AnimationDrawable a;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.animacaoquaddro_view);
        spriteMegaman = getViewById(R.id.sprite_megaman);

        a = (AnimationDrawable)spriteMegaman.getDrawable();
    }

    @Override
    protected void onResume() {
        super.onResume();
        a.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        a.stop();
    }
}
