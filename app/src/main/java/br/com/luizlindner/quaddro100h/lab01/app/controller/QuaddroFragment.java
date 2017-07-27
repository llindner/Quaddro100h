package br.com.luizlindner.quaddro100h.lab01.app.controller;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Luiz on 26/07/2017.
 */

public class QuaddroFragment extends Fragment {
    public static final String TIPO_DE_LOG = "LAB";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TIPO_DE_LOG, "Passei pelo onCreate do Fragment: " + getClass().getSimpleName());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TIPO_DE_LOG, "Passei pelo onCreateView do Fragment: " + getClass().getSimpleName());
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TIPO_DE_LOG, "Passei pelo onActivityCreated do Fragment: " + getClass().getSimpleName());
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TIPO_DE_LOG, "Passei pelo onStart do Fragment: " + getClass().getSimpleName());
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TIPO_DE_LOG, "Passei pelo onResume do Fragment: " + getClass().getSimpleName());
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TIPO_DE_LOG, "Passei pelo onPause do Fragment: " + getClass().getSimpleName());
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TIPO_DE_LOG, "Passei pelo onStop do Fragment: " + getClass().getSimpleName());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TIPO_DE_LOG, "Passei pelo onDestroy do Fragment: " + getClass().getSimpleName());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TIPO_DE_LOG, "Passei pelo onDestroyView do Fragment: " + getClass().getSimpleName());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TIPO_DE_LOG, "Passei pelo onAttach do Fragment: " + getClass().getSimpleName());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TIPO_DE_LOG, "Passei pelo onDetach do Fragment: " + getClass().getSimpleName());
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        Log.i(TIPO_DE_LOG, "Passei pelo onAttachFragment do Fragment: " + getClass().getSimpleName());
    }
}
