package br.com.luizlindner.quaddro100h.lab04.app.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroActivity;
import br.com.luizlindner.quaddro100h.lab04.domain.model.CEP;
import retrofit2.Retrofit;

/**
 * Created by Luiz on 06/07/2017.
 */

public class EnderecoInserirActivity extends QuaddroActivity {
    EditText cepView;
    CEP cepModel;
    Retrofit retrofit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endereco_inserir_view);

        cepView = getViewById(R.id.cep);
        cepModel = CEP.getInstance();
        retrofit = new Retrofit.Builder().baseUrl("http://api.postmon.com.br/v1/cep/").build();
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
                salvarEndereco();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Log.i(TIPO_DE_LOG, "Endereço cancelado!");
        Toast.makeText(this, R.string.lab04_endereco_cancelado, Toast.LENGTH_LONG).show();
    }

    public void salvarEndereco(){
        // TODO Inserir ou atualizar o endereço no SQLite
        Log.i(TIPO_DE_LOG, "Endereço salvo!");
        Toast.makeText(this, R.string.lab04_endereco_salvo, Toast.LENGTH_SHORT).show();
        finish();
    }


    public void consultarCep(View v){
        Toast toast;
        try {
            cepModel.setCodigo(cepView.getText().toString());
            cepModel.validar();
            Log.i(TIPO_DE_LOG, "CEP válido!");
            toast = Toast.makeText(this, R.string.lab04_endereco_buscando, Toast.LENGTH_SHORT);

            // TODO Preencher os campos do formulário
        } catch (Exception cause){
            Log.i(TIPO_DE_LOG, "OPS...", cause);
            toast = Toast.makeText(this, cause.getMessage(), Toast.LENGTH_LONG);
            cepView.requestFocus();
        }

        toast.show();
    }
}
