package br.com.luizlindner.quaddro100h.lab07.app.controller;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.databinding.StarwarsInserirViewBinding;
import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroActivity;
import br.com.luizlindner.quaddro100h.lab07.app.adapter.FilmsArrayAdapter;
import br.com.luizlindner.quaddro100h.lab07.app.adapter.SpeciesArrayAdapter;
import br.com.luizlindner.quaddro100h.lab07.app.adapter.StarshipArrayAdapter;
import br.com.luizlindner.quaddro100h.lab07.app.adapter.VehiclesArrayAdapter;
import br.com.luizlindner.quaddro100h.lab07.app.binding.StarwarsAction;
import br.com.luizlindner.quaddro100h.lab07.domain.model.Film;
import br.com.luizlindner.quaddro100h.lab07.domain.model.People;
import br.com.luizlindner.quaddro100h.lab07.domain.model.Specie;
import br.com.luizlindner.quaddro100h.lab07.domain.model.Starship;
import br.com.luizlindner.quaddro100h.lab07.domain.model.Vehicle;

/**
 * Created by Luiz on 21/07/2017.
 */

public class StarwarsInserirActivity extends QuaddroActivity {

    private StarwarsInserirViewBinding binding;
    private ListView listSwFilms, listSwSpecies, listSwVehicles, listSwStarships;
    public static ProgressDialog progress;
    private LinearLayout swLayoutDados;
    private PopupWindow pw;

    BroadcastReceiver buscaId = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i(TIPO_DE_LOG, "Entrou no broadcast receiver");

            People model = (People) intent.getSerializableExtra("model");
            Log.i(TIPO_DE_LOG, "Model recebido no receiver:" + model.toString());
            if(model != null){
                binding.setPeople(model);

                /*ArrayAdapter<Film> filmAdapter = new ArrayAdapter<Film>(context, R.layout.linha_filmes_view, R.id.linha_film_episodeId, teste);
                listSwFilms.setAdapter(filmAdapter);*/
                ArrayAdapter<Film> filmAdapter = new FilmsArrayAdapter(context, 0, model.getFilms());
                listSwFilms.setAdapter(filmAdapter);

                ArrayAdapter<Specie> specieAdapter = new SpeciesArrayAdapter(context, 0, model.getSpecies());
                listSwSpecies.setAdapter(specieAdapter);

                ArrayAdapter<Vehicle> vehicleAdapter = new VehiclesArrayAdapter(context, 0, model.getVehicles());
                listSwVehicles.setAdapter(vehicleAdapter);

                ArrayAdapter<Starship> starshipAdapter = new StarshipArrayAdapter(context, 0, model.getStarships());
                listSwStarships.setAdapter(starshipAdapter);

                progress.dismiss();
                swLayoutDados.setVisibility(View.VISIBLE);
            }
        }
    };



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.starwars_inserir_view);
        binding.setController(new StarwarsAction(binding));
        listSwFilms = getViewById(R.id.list_sw_films);
        listSwSpecies = getViewById(R.id.list_sw_species);
        listSwVehicles = getViewById(R.id.list_sw_vehicles);
        listSwStarships = getViewById(R.id.list_sw_starships);
        swLayoutDados = getViewById(R.id.sw_layout_dados);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(buscaId, new IntentFilter("retornoStarwarsPeople"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(buscaId);
    }

    public void initiatePopupWindow(View v) {
        Context c = v.getContext();
        try {
            LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //Inflate the view from a predefined XML layout
            View layout = inflater.inflate(R.layout.popup_film_view, (ViewGroup)v.findViewById(R.id.layout_sw_film));
            // create a 300px width and 470px height PopupWindow
            pw = new PopupWindow(layout, 300, 470, true);
            // display the popup in the center
            pw.showAtLocation(v, Gravity.CENTER, 0, 0);

            /*TextView mResultText = (TextView) layout.findViewById(R.id.server_status_text);
            Button cancelButton = (Button) layout.findViewById(R.id.end_data_send_button);
            cancelButton.setOnClickListener(cancel_button_click_listener);*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
