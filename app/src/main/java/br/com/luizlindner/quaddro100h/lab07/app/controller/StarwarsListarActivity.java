package br.com.luizlindner.quaddro100h.lab07.app.controller;

import android.app.ListActivity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Date;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroActivity;
import br.com.luizlindner.quaddro100h.lab07.domain.model.Film;
import br.com.luizlindner.quaddro100h.lab07.domain.model.People;
import br.com.luizlindner.quaddro100h.lab07.domain.model.Planet;
import br.com.luizlindner.quaddro100h.lab07.domain.model.Specie;
import br.com.luizlindner.quaddro100h.lab07.domain.model.Starship;
import br.com.luizlindner.quaddro100h.lab07.domain.model.Vehicle;

/**
 * Created by Luiz on 21/07/2017.
 */

public class StarwarsListarActivity extends ListActivity {

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = new MenuInflater(this);
        i.inflate(R.menu.starwars_listar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()){
            case R.id.inserir_starwars:
                Intent i = new Intent(this, StarwarsInserirActivity.class);
                startActivity(i);
                break;
        }

        return super.onMenuItemSelected(featureId, item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Planet homeworld = Planet.of("Tatooine", "23", "304", "10465", "arid", "1 standard", "desert", "1", "200000");

        ArrayList<Film> films = new ArrayList<>();
        films.add(Film.of("A New Hope", "4", "It is a period of civil war.", "George Lucas", "Gary Kurtz, Rick McCallum", "1977-05-25"));

        ArrayList<Specie> species = new ArrayList<>();
        species.add(Specie.of("Human", "Mammal", "Sentient", "180", "caucasian, black, asian, hispanic", "blonde, brown, black, red", "brown, blue, green, hazel, grey, amber", "120", "Galactic Basic"));

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(Vehicle.of("Snowspeeder", "t-47 airspeeder", "Incom corporation", "unknown", "4.5", "650", "2", "0", "10", "none", "airspeeder"));

        ArrayList<Starship> starships = new ArrayList<>();
        starships.add(Starship.of("Death Star", "DS-1 Orbital Battle Station", "Imperial Department of Military Research, Sienar Fleet Systems", "1000000000000", "120000", "n/a", "342953", "843342", "1000000000000", "3 years", "4.0", "10", "Deep Space Mobile Battlestation"));

        ArrayList<People> list = new ArrayList<>();
        list.add(People.of("Luke Skywalker", "172", "77", "blond", "fair", "blue", "19BBY", "male", homeworld, films, species, vehicles, starships));

        ArrayAdapter<People> adapter = new ArrayAdapter<People>(this, android.R.layout.simple_list_item_1, list);
        setListAdapter(adapter);
    }
}
