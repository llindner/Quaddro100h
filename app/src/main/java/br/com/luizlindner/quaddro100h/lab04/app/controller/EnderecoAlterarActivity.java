package br.com.luizlindner.quaddro100h.lab04.app.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroActivity;
import br.com.luizlindner.quaddro100h.lab04.app.util.RetrofitHelper;
import br.com.luizlindner.quaddro100h.lab04.app.ws.EnderecoEndpoint;
import br.com.luizlindner.quaddro100h.lab04.domain.model.CEP;

/**
 * Created by Luiz on 06/07/2017.
 */

public class EnderecoAlterarActivity extends QuaddroActivity {
    EditText cepView, logradouroView, numeroView, complementoView, bairroView, municipioView;
    Spinner ufView;
    CEP cepModel;
    EnderecoEndpoint endpoint;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endereco_alterar_view);

        endpoint = RetrofitHelper.with(this).createEnderecoEndpoint();

        cepView = getViewById(R.id.cep);
        logradouroView = getViewById(R.id.logradouro);
        numeroView = getViewById(R.id.numero);
        complementoView = getViewById(R.id.complemento);
        bairroView = getViewById(R.id.bairro);
        municipioView = getViewById(R.id.municipio);
        ufView = getViewById(R.id.uf);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = new MenuInflater(getApplicationContext());
        i.inflate(R.menu.endereco_salvar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.endereco_salvar:
                // TODO Salvar alteração no SQLite
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Log.i(TIPO_DE_LOG, "Alteração de endereço cancelada!");
        Toast.makeText(this, "Alteração cancelada!", Toast.LENGTH_LONG).show();
    }

    public void consultarCep(View v){

    }
}
