package br.com.luizlindner.quaddro100h.lab04.app.ws;

import br.com.luizlindner.quaddro100h.lab04.app.dto.EnderecoDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Luiz on 18/07/2017.
 */

public interface EnderecoEndpoint {

    @GET("cep/{codigo}")
    Call<EnderecoDTO> consultarCEP(@Path("codigo") String codigo);
}
