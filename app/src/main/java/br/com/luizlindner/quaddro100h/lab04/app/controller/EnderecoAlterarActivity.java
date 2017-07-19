package br.com.luizlindner.quaddro100h.lab04.app.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroActivity;

/**
 * Created by Luiz on 06/07/2017.
 */

public class EnderecoAlterarActivity extends QuaddroActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endereco_alterar_view);
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
}
