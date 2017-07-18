package br.com.luizlindner.quaddro100h.lab04.app.controller;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.opengl.EGLExt;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroActivity;
import br.com.luizlindner.quaddro100h.lab04.domain.model.Endereco;
import br.com.luizlindner.quaddro100h.lab04.domain.model.UF;

/**
 * Created by Luiz on 06/07/2017.
 */

public class EnderecoListarActivity extends ListActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = new MenuInflater(getApplicationContext());
        i.inflate(R.menu.endereco_listar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()){
            case R.id.inserir:
                Intent i = new Intent("android.intent.action.endereco.INSERIR");
                startActivity(i);
                break;
        }

        return super.onMenuItemSelected(featureId, item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Endereco> list = new ArrayList<>();
        list.add(Endereco.of("02469120", "Rua", "Campo Comprido", "3", "Apto 24", "Vila Romero", "Sâo Paulo", UF.SP));
        list.add(Endereco.of("98280000", "Rua", "Protásio Alves", "81", "", "Centro", "Panambi", UF.RS));
        list.add(Endereco.of("", "Alameda", "Santos", "1000", "7º Andar", "Jardim Paulista", "São Paulo", UF.SP));
        // TODO Fazer a busca no banco de dados SQLite

        ArrayAdapter<Endereco> adapter = new ArrayAdapter<Endereco>(this, android.R.layout.simple_list_item_1, list);
        setListAdapter(adapter);
    }
}
