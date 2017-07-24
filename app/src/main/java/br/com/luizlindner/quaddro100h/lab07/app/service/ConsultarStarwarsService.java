package br.com.luizlindner.quaddro100h.lab07.app.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import br.com.luizlindner.quaddro100h.lab07.app.dto.FilmDTO;
import br.com.luizlindner.quaddro100h.lab07.app.dto.PeopleDTO;
import br.com.luizlindner.quaddro100h.lab07.app.dto.PlanetDTO;
import br.com.luizlindner.quaddro100h.lab07.app.dto.SpecieDTO;
import br.com.luizlindner.quaddro100h.lab07.app.dto.StarshipDTO;
import br.com.luizlindner.quaddro100h.lab07.app.dto.VehicleDTO;
import br.com.luizlindner.quaddro100h.lab07.app.util.RetrofitHelper;
import br.com.luizlindner.quaddro100h.lab07.app.ws.StarwarsEndpoint;
import br.com.luizlindner.quaddro100h.lab07.domain.model.Film;
import br.com.luizlindner.quaddro100h.lab07.domain.model.People;
import br.com.luizlindner.quaddro100h.lab07.domain.model.Planet;
import br.com.luizlindner.quaddro100h.lab07.domain.model.Specie;
import br.com.luizlindner.quaddro100h.lab07.domain.model.Starship;
import br.com.luizlindner.quaddro100h.lab07.domain.model.Vehicle;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Luiz on 22/07/2017.
 */

public class ConsultarStarwarsService extends IntentService {
    private StarwarsEndpoint endpoint;

    public ConsultarStarwarsService() {
        super("ConsultarStarwarsService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        endpoint = RetrofitHelper.with(this).createStarwarsEndpoint();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i("LAB", "recebeu o serviço!");
        Intent i = new Intent("retornoStarwarsPeople");
        Boolean encontrou = Boolean.TRUE;
        if (intent != null) {
            try {
                String peopleId = intent.getStringExtra("id");
                Call<PeopleDTO> peopleCall = endpoint.getPeople(peopleId);
                Response<PeopleDTO> peopleResponse = peopleCall.execute();
                if (peopleResponse.isSuccessful()) {
                    PeopleDTO peopleDTO = peopleResponse.body();

                    Planet planetModel = Planet.getInstance();
                    if(!peopleDTO.getHomeworld().isEmpty()) {
                        try {
                            Log.i("LAB", "Homeworld String:" + peopleDTO.getHomeworld());
                            String[] plannetArr = peopleDTO.getHomeworld().split("/");
                            String planetId = plannetArr[plannetArr.length - 1];
                            Log.i("LAB", "Planet ID:" + planetId);

                            Call<PlanetDTO> planetCall = endpoint.getPlanet(planetId);
                            Response<PlanetDTO> planetResponse = planetCall.execute();
                            if (planetResponse.isSuccessful()) {
                                PlanetDTO planetDTO = planetResponse.body();
                                planetModel = Planet.of(planetId, planetDTO.getName(), planetDTO.getRotation_period(), planetDTO.getOrbital_period(), planetDTO.getDiameter(), planetDTO.getClimate(), planetDTO.getGravity(), planetDTO.getTerrain(), planetDTO.getSurface_water(), planetDTO.getPopulation());
                            }
                        } catch (Exception e) {
                            Log.e("LAB", "Erro ao localizar o Planeta", e);
                            encontrou = Boolean.FALSE;
                        }
                    }

                    ArrayList<Film> arrayListFilm = new ArrayList<Film>();
                    if(!peopleDTO.getFilms().isEmpty()){
                        try {

                            Log.i("LAB", "Flims ArrayList:" + peopleDTO.getFilms());
                            ArrayList<String> filmsArr = (ArrayList)peopleDTO.getFilms();
                            for(String filmStr: filmsArr) {
                                String[] filmIdArr = filmStr.split("/");
                                String filmId = filmIdArr[filmIdArr.length - 1];
                                Log.i("LAB", "Film ID:" + filmId);

                                Call<FilmDTO> filmCall = endpoint.getFilm(filmId);
                                Response<FilmDTO> filmResponse = filmCall.execute();
                                if (filmResponse.isSuccessful()) {
                                    FilmDTO filmDTO = filmResponse.body();
                                    Film filmModel = Film.of(filmId, filmDTO.getTitle(), filmDTO.getEpisode_id(), filmDTO.getOpening_crawl(), filmDTO.getDirector(), filmDTO.getProducer(), filmDTO.getRelease_date());
                                    arrayListFilm.add(filmModel);
                                }
                            }
                        } catch (Exception e) {
                            Log.e("LAB", "Erro ao localizar o Filme", e);
                            encontrou = Boolean.FALSE;
                        }
                    }

                    ArrayList<Specie> arrayListSpecie = new ArrayList<Specie>();
                    if(!peopleDTO.getSpecies().isEmpty()){
                        try {

                            Log.i("LAB", "Species ArrayList:" + peopleDTO.getSpecies());
                            ArrayList<String> speciesArr = (ArrayList)peopleDTO.getSpecies();
                            for(String specieStr: speciesArr) {
                                String[] specieIdArr = specieStr.split("/");
                                String specieId = specieIdArr[specieIdArr.length - 1];
                                Log.i("LAB", "Specie ID:" + specieId);

                                Call<SpecieDTO> specieCall = endpoint.getSpecie(specieId);
                                Response<SpecieDTO> specieResponse = specieCall.execute();
                                if (specieResponse.isSuccessful()) {
                                    SpecieDTO specieDTO = specieResponse.body();
                                    Specie specieModel = Specie.of(specieId, specieDTO.getName(), specieDTO.getClassification(), specieDTO.getDesignation(), specieDTO.getAverage_height(), specieDTO.getSkin_colors(), specieDTO.getHair_colors(), specieDTO.getEye_colors(), specieDTO.getAverage_lifespan(), specieDTO.getLanguage());
                                    arrayListSpecie.add(specieModel);
                                }
                            }
                        } catch (Exception e) {
                            Log.e("LAB", "Erro ao localizar o Specie", e);
                            encontrou = Boolean.FALSE;
                        }
                    }

                    ArrayList<Vehicle> arrayListVehicle = new ArrayList<Vehicle>();
                    if(!peopleDTO.getVehicles().isEmpty()){
                        try {

                            Log.i("LAB", "Vehicle ArrayList:" + peopleDTO.getVehicles());
                            ArrayList<String> vehicleArr = (ArrayList)peopleDTO.getVehicles();
                            for(String vehicleStr: vehicleArr) {
                                String[] vehicleIdArr = vehicleStr.split("/");
                                String vehicleId = vehicleIdArr[vehicleIdArr.length - 1];
                                Log.i("LAB", "Vehicle ID:" + vehicleId);

                                Call<VehicleDTO> vehicleCall = endpoint.getVehicle(vehicleId);
                                Response<VehicleDTO> vehicleResponse = vehicleCall.execute();
                                if (vehicleResponse.isSuccessful()) {
                                    VehicleDTO vehicleDTO = vehicleResponse.body();
                                    Vehicle vehicleModel = Vehicle.of(vehicleId, vehicleDTO.getName(), vehicleDTO.getModel(), vehicleDTO.getManufacturer(), vehicleDTO.getCost_in_credits(), vehicleDTO.getLength(), vehicleDTO.getMax_atmosphere_speed(), vehicleDTO.getCrew(), vehicleDTO.getPassengers(), vehicleDTO.getCargo_capacity(), vehicleDTO.getConsumables(), vehicleDTO.getVehicle_class());
                                    arrayListVehicle.add(vehicleModel);
                                }
                            }
                        } catch (Exception e) {
                            Log.e("LAB", "Erro ao localizar o Vehicle", e);
                            encontrou = Boolean.FALSE;
                        }
                    }

                    ArrayList<Starship> arrayListStarship = new ArrayList<Starship>();
                    if(!peopleDTO.getStarships().isEmpty()){
                        try {

                            Log.i("LAB", "Starship ArrayList:" + peopleDTO.getStarships());
                            ArrayList<String> starshipArr = (ArrayList)peopleDTO.getStarships();
                            for(String starshipStr: starshipArr) {
                                String[] starshipIdArr = starshipStr.split("/");
                                String starshipId = starshipIdArr[starshipIdArr.length - 1];
                                Log.i("LAB", "Starship ID:" + starshipId);

                                Call<StarshipDTO> starshipCall = endpoint.getStarship(starshipId);
                                Response<StarshipDTO> starshipResponse = starshipCall.execute();
                                if (starshipResponse.isSuccessful()) {
                                    StarshipDTO starshipDTO = starshipResponse.body();
                                    Starship starshipModel = Starship.of(starshipId, starshipDTO.getName(), starshipDTO.getModel(), starshipDTO.getManufacturer(), starshipDTO.getCostInCredits(), starshipDTO.getLength(), starshipDTO.getMaxAtmosphericSpeed(), starshipDTO.getCrew(), starshipDTO.getPassengers(), starshipDTO.getCargoCapacity(), starshipDTO.getConsumables(), starshipDTO.getHyperdriveRating(), starshipDTO.getMglt(), starshipDTO.getStarshipClass());
                                    arrayListStarship.add(starshipModel);
                                }
                            }
                        } catch (Exception e) {
                            Log.e("LAB", "Erro ao localizar o Starship", e);
                            encontrou = Boolean.FALSE;
                        }
                    }

                    People model = People.of(peopleId, peopleDTO.getName(), peopleDTO.getHeight(), peopleDTO.getMass(), peopleDTO.getHair_color(), peopleDTO.getSkin_color(), peopleDTO.getEye_color(), peopleDTO.getBirth_year(), peopleDTO.getGender(), planetModel, arrayListFilm, arrayListSpecie, arrayListVehicle, arrayListStarship);

                    i.putExtra("model", model);
                }
            } catch (Exception e) {
                Log.e("LAB", "Erro ao localizar o Personagem", e);
                encontrou = Boolean.FALSE;
            }
        } else {
            encontrou = Boolean.FALSE;
        }
        sendBroadcast(i);
    }
}
