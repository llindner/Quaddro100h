package br.com.luizlindner.quaddro100h.lab05.app.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.Spinner;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroActivity;

/**
 * Created by LUiz on 13/07/2017.
 */

public class AnimacaoActivity extends QuaddroActivity {

    Spinner spAnimacao;
    Spinner spInterpolacao;
    ImageView overwatch;
    View layoutOverwatch;

    Animation[] animations;
    Interpolator[] interpolators;

    private class OnClickAction implements View.OnClickListener {

        @Override
        public void onClick(View view) {

        }
    }

    private class AnimationAction implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animacao_view);

        spAnimacao = getViewById(R.id.sp_animacao);
        spInterpolacao = getViewById(R.id.sp_interpolador);
        overwatch = getViewById(R.id.imgv_overwatch);
        layoutOverwatch = getViewById(R.id.layout_overwatch);

        layoutOverwatch.setOnClickListener(new OnClickAction());

        animations[0].setAnimationListener(new AnimationAction());

    }

}
