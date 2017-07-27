package br.com.luizlindner.quaddro100h.lab04.app.controller;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.opengl.EGLExt;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroActivity;
import br.com.luizlindner.quaddro100h.lab04.domain.model.Endereco;
import br.com.luizlindner.quaddro100h.lab04.domain.model.UF;
import br.com.luizlindner.quaddro100h.lab04.repository.util.EnderecoSQLiteHelper;

/**
 * Created by Luiz on 06/07/2017.
 */

public class EnderecoListarActivity extends ListActivity {
    private EnderecoSQLiteHelper sqlite;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = new MenuInflater(this);
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

        sqlite = EnderecoSQLiteHelper.with(this);
        registerForContextMenu(getListView());
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater i = new MenuInflater(this);
        i.inflate(R.menu.endereco_contexto, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final AdapterView.AdapterContextMenuInfo info;
        info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){
            case R.id.endereco_alterar:
                Log.i(QuaddroActivity.TIPO_DE_LOG, "Alterar!!");
                Intent i = new Intent(this, EnderecoAlterarActivity.class);
                i.putExtra("_id", info.id);
                startActivity(i);
                break;
            case R.id.endereco_excluir:
                Log.i(QuaddroActivity.TIPO_DE_LOG, "Excluir!!");
                AlertDialog alert;
                alert = new AlertDialog.Builder(this)
                        .setTitle("Atenção!")
                        .setMessage("Tem certeza que deseja excluir?")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                try {
                                    sqlite.apagar(info.id);
                                    Log.i(QuaddroActivity.TIPO_DE_LOG, "Endereço Excluído");
                                    Toast.makeText(getApplicationContext(), "Endereço Excluído", Toast.LENGTH_SHORT).show();
                                    onResume();
                                } catch (Exception e){
                                    Log.e(QuaddroActivity.TIPO_DE_LOG, "Não conseguiu excluir o endereço", e);
                                    Toast.makeText(getApplicationContext(), "OPS...", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("Não", null)
                        .create();
                alert.show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        sqlite.abrirDB();
    }

    @Override
    protected void onStop() {
        super.onStop();
        sqlite.fecharDB();
    }

    @Override
    protected void onResume() {
        super.onResume();

        try {
            ArrayList<Endereco> list = sqlite.listarTodos();
            Cursor c = sqlite.listarTodosPorCursor();
            SimpleCursorAdapter sca = new SimpleCursorAdapter(this, R.layout.endereco_item_view, c, new String[] { "logradouro_tipo", "logradouro_nome", "numero", "bairro", "municipio", "uf", "cep" }, new int[] {R.id.endereco_item_logradouro_tipo, R.id.endereco_item_logradouro_nome, R.id.endereco_item_numero, R.id.endereco_item_bairro, R.id.endereco_item_municipio, R.id.endereco_item_uf, R.id.endereco_item_cep}, 0);

            ArrayAdapter<Endereco> adapter = new ArrayAdapter<Endereco>(this, android.R.layout.simple_list_item_1, list);
            setListAdapter(sca);
        } catch (Exception e) {
            Log.e("LAB", "Ops...", e);
            Toast.makeText(this, "OPS...", Toast.LENGTH_SHORT).show();
        }
        /*list.add(Endereco.of("02469120", "Rua", "Campo Comprido", "3", "Apto 24", "Vila Romero", "Sâo Paulo", UF.SP));
        list.add(Endereco.of("98280000", "Rua", "Protásio Alves", "81", "", "Centro", "Panambi", UF.RS));
        list.add(Endereco.of("", "Alameda", "Santos", "1000", "7º Andar", "Jardim Paulista", "São Paulo", UF.SP));*/


    }
}
