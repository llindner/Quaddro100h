package br.com.luizlindner.quaddro100h.lab04.app.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.databinding.EnderecoAlterarViewBinding;
import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroActivity;
import br.com.luizlindner.quaddro100h.lab04.app.binding.EnderecoAction;
import br.com.luizlindner.quaddro100h.lab04.domain.model.Endereco;
import br.com.luizlindner.quaddro100h.lab04.domain.model.UF;
import br.com.luizlindner.quaddro100h.lab04.repository.util.EnderecoSQLiteHelper;

/**
 * Created by Luiz on 06/07/2017.
 */

public class EnderecoAlterarActivity extends QuaddroActivity {

    EnderecoAlterarViewBinding binding;
    EnderecoSQLiteHelper sqlite;
    Endereco model;

    BroadcastReceiver consultaCEP = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i(TIPO_DE_LOG, "Entrou no broadcast receiver");
            Endereco model = (Endereco) intent.getSerializableExtra("model");
            if(model != null){
                binding.setEndereco(model);
            }
        }
    };

    TextView.OnEditorActionListener editorAction = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            Endereco endereco = Endereco.of(binding.cep.getText().toString(), binding.logradouro.getText().toString(), binding.numero.getText().toString(), binding.complemento.getText().toString(), binding.bairro.getText().toString(), binding.municipio.getText().toString(), (UF)binding.uf.getSelectedItem());
            boolean ok = Boolean.TRUE;

            return validar(endereco);
        }
    };

    private Boolean validar(Endereco endereco) {
        boolean ok = true;
        try {
            endereco.validarCEP();
        } catch (Exception e){
            binding.cep.setError(e.getMessage());
            ok = false;
        }

        try {
            endereco.validarLogradouro();
        } catch (Exception e){
            binding.logradouro.setError(e.getMessage());
            ok = false;
        }

        try {
            endereco.validarBairro();
        } catch (Exception e){
            binding.bairro.setError(e.getMessage());
            ok = false;
        }

        try {
            endereco.validarMunicipio();
        } catch (Exception e){
            binding.municipio.setError(e.getMessage());
            ok = false;
        }

        return ok;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.endereco_alterar_view);
        binding.setController(new EnderecoAction(binding));
        sqlite = EnderecoSQLiteHelper.with(this);
        binding.municipio.setOnEditorActionListener(editorAction);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = new MenuInflater(getApplicationContext());
        i.inflate(R.menu.endereco_salvar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        try {
            switch (item.getItemId()) {
                case R.id.endereco_salvar:
                    // TODO Salvar alteração no SQLite
                    Endereco model = binding.getEndereco();
                    Log.i(TIPO_DE_LOG, model.toString());
                    if(validar(model)) {
                        sqlite.salvar(model);
                        Log.i(TIPO_DE_LOG, "Endereço salvo!");
                        Toast.makeText(this, "Salvo!", Toast.LENGTH_LONG).show();
                        finish();
                    }
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Ops!", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        sqlite.abrirDB();
    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.uf.setAdapter(new ArrayAdapter<UF>(this, android.R.layout.simple_list_item_1, UF.values()));

        Long id = getIntent().getLongExtra("_id", 0L);
        if(model == null) {
            model = sqlite.recuperar(id);
            binding.setEndereco(model);
            binding.uf.setSelection(model.getUFOrdinal());
        }

        registerReceiver(consultaCEP, new IntentFilter("retornoCEP"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(consultaCEP);
    }

    @Override
    protected void onStop() {
        super.onStop();
        sqlite.fecharDB();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Log.i(TIPO_DE_LOG, "Alteração de endereço cancelada!");
        Toast.makeText(this, "Alteração cancelada!", Toast.LENGTH_LONG).show();
    }

}
