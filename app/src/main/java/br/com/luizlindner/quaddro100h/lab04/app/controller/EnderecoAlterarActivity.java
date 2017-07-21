package br.com.luizlindner.quaddro100h.lab04.app.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.databinding.EnderecoAlterarViewBinding;
import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroActivity;
import br.com.luizlindner.quaddro100h.lab04.app.binding.EnderecoAction;
import br.com.luizlindner.quaddro100h.lab04.app.util.RetrofitHelper;
import br.com.luizlindner.quaddro100h.lab04.app.ws.EnderecoEndpoint;
import br.com.luizlindner.quaddro100h.lab04.domain.model.CEP;
import br.com.luizlindner.quaddro100h.lab04.domain.model.Endereco;
import br.com.luizlindner.quaddro100h.lab04.domain.model.UF;

/**
 * Created by Luiz on 06/07/2017.
 */

public class EnderecoAlterarActivity extends QuaddroActivity {

    EnderecoAlterarViewBinding binding;
    EnderecoEndpoint endpoint;
    BroadcastReceiver consultaCEP;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.endereco_alterar_view);
        binding.setController(new EnderecoAction(binding));
        endpoint = RetrofitHelper.with(this).createEnderecoEndpoint();
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
    protected void onResume() {
        super.onResume();
        binding.uf.setAdapter(new ArrayAdapter<UF>(this, android.R.layout.simple_list_item_1, UF.values()));
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
