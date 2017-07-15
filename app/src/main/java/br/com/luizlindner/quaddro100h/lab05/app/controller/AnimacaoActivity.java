package br.com.luizlindner.quaddro100h.lab05.app.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.Locale;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroActivity;

/**
 * Created by LUiz on 13/07/2017.
 */

public class AnimacaoActivity extends QuaddroActivity {

    Spinner spAnimacao;
    Spinner spInterpolacao;
    ImageView overwatch;
    Button btExecutar;
    AnimationAction aa;

    Animation[] animations;
    Interpolator[] interpolators;

    private class OnClickAction implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Log.i(TIPO_DE_LOG, String.format(Locale.getDefault(), "Clicando em %s", view.getClass().getSimpleName()));
            Interpolator i;
            Animation a;
            i = interpolators[spInterpolacao.getSelectedItemPosition()];
            a = animations[spAnimacao.getSelectedItemPosition()];

            a.setInterpolator(i);
            a.setAnimationListener(aa);
            overwatch.requestLayout();
            overwatch.setAnimation(a);
            a.start();
        }
    }

    private class AnimationAction implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {
            Log.i(TIPO_DE_LOG, "Iniciando animação: " + animation.getClass().getSimpleName());
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Log.i(TIPO_DE_LOG, "Terminando animação: " + animation.getClass().getSimpleName());
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            Log.i(TIPO_DE_LOG, "Repetindo animação: " + animation.getClass().getSimpleName());
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animacao_view);

        spAnimacao = getViewById(R.id.sp_animacao);
        spInterpolacao = getViewById(R.id.sp_interpolador);
        overwatch = getViewById(R.id.imgv_overwatch);
        btExecutar = getViewById(R.id.btn_executar);

        btExecutar.setOnClickListener(new OnClickAction());

        initAnimations();
        initInterpolators();
        aa = new AnimationAction();
    }

    private void initAnimations() {
        animations = new Animation[spAnimacao.getCount()];
        animations[0] = new AlphaAnimation(1, 0);
        animations[1] = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animations[2] = new ScaleAnimation(1, 3, 1, 3, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animations[3] = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.ABSOLUTE, 200, Animation.RELATIVE_TO_SELF, 0, Animation.ABSOLUTE, 300);
        animations[3].setDuration(1000);

        AnimationSet set = new AnimationSet(true);
        for(int i = 0; i < animations.length -2; i++){
            animations[i].setDuration(1000);
            animations[i].setRepeatMode(Animation.REVERSE);
            animations[i].setRepeatCount(1);
            set.addAnimation(animations[i]);
        }
        animations[4] = set;
    }

    private void initInterpolators() {
        interpolators = new Interpolator[] {
                new AccelerateDecelerateInterpolator(),
                new AccelerateInterpolator(),
                new AnticipateInterpolator(),
                new AnticipateOvershootInterpolator(),
                new BounceInterpolator(),
                new CycleInterpolator(2f),
                new DecelerateInterpolator(),
                new LinearInterpolator(),
                new OvershootInterpolator()
        };
    }

}
