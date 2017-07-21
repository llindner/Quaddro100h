package br.com.luizlindner.quaddro100h.lab04.app.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroActivity;
import br.com.luizlindner.quaddro100h.lab04.app.dto.EnderecoDTO;
import br.com.luizlindner.quaddro100h.lab04.app.util.RetrofitHelper;
import br.com.luizlindner.quaddro100h.lab04.app.ws.EnderecoEndpoint;
import br.com.luizlindner.quaddro100h.lab04.domain.model.Endereco;
import br.com.luizlindner.quaddro100h.lab04.domain.model.UF;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Luiz on 20/07/2017.
 */

public class ConsultarCEPService extends IntentService {
    private EnderecoEndpoint endpoint;

    public ConsultarCEPService() {
        super("ConsultarCEPService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        endpoint = RetrofitHelper.with(this).createEnderecoEndpoint();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Intent i = new Intent("");
        if(intent != null) {
            try {
                String cep = intent.getStringExtra("cep");
                Call<EnderecoDTO> call = endpoint.consultarCEP(cep);
                Response<EnderecoDTO> response = call.execute();
                if (response.isSuccessful()) {
                    EnderecoDTO dto = response.body();
                    Endereco model = Endereco.of(cep, dto.getLogradouro(), dto.getBairro(), dto.getCidade(), dto.getEstado());

                    i.putExtra("encontrou", Boolean.TRUE);
                    i.putExtra("model", model);
                }
            } catch (Exception e) {
                Log.e("LAB", "Erro ao localizar o cep", e);
                i.putExtra("encontrou", Boolean.FALSE);
            }
        }else{
            i.putExtra("encontrou", Boolean.FALSE);
        }
        sendBroadcast(i);
    }
}
