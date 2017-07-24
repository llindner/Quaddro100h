package br.com.luizlindner.quaddro100h.lab07.app.ws;

import br.com.luizlindner.quaddro100h.lab07.app.dto.FilmDTO;
import br.com.luizlindner.quaddro100h.lab07.app.dto.PeopleDTO;
import br.com.luizlindner.quaddro100h.lab07.app.dto.PlanetDTO;
import br.com.luizlindner.quaddro100h.lab07.app.dto.SpecieDTO;
import br.com.luizlindner.quaddro100h.lab07.app.dto.StarshipDTO;
import br.com.luizlindner.quaddro100h.lab07.app.dto.VehicleDTO;
import br.com.luizlindner.quaddro100h.lab07.domain.model.Starship;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Luiz on 22/07/2017.
 */

public interface StarwarsEndpoint {

    @GET("people/{id}")
    Call<PeopleDTO> getPeople(@Path("id") String id);

    @GET("planets/{id}")
    Call<PlanetDTO> getPlanet(@Path("id") String id);

    @GET("films/{id}")
    Call<FilmDTO> getFilm(@Path("id") String id);

    @GET("species/{id}")
    Call<SpecieDTO> getSpecie(@Path("id") String id);

    @GET("vehicles/{id}")
    Call<VehicleDTO> getVehicle(@Path("id") String id);

    @GET("starships/{id}")
    Call<StarshipDTO> getStarship(@Path("id") String id);

}
