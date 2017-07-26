package br.com.luizlindner.quaddro100h.lab04.app.controller;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroActivity;
import br.com.luizlindner.quaddro100h.lab04.app.dto.EnderecoDTO;
import br.com.luizlindner.quaddro100h.lab04.app.util.RetrofitHelper;
import br.com.luizlindner.quaddro100h.lab04.app.ws.EnderecoEndpoint;
import br.com.luizlindner.quaddro100h.lab04.domain.model.CEP;
import br.com.luizlindner.quaddro100h.lab04.domain.model.Endereco;
import br.com.luizlindner.quaddro100h.lab04.domain.model.UF;
import br.com.luizlindner.quaddro100h.lab04.repository.util.EnderecoSQLiteHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Luiz on 06/07/2017.
 */

public class EnderecoInserirActivity extends QuaddroActivity {
    EditText cepView, logradouroView, numeroView, complementoView, bairroView, municipioView;
    Spinner ufView;
    CEP cepModel;
    EnderecoEndpoint endpoint;
    EnderecoSQLiteHelper sqlite;

    TextView.OnEditorActionListener editorAction = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            Endereco endereco = Endereco.of(cepView.getText().toString(), logradouroView.getText().toString(), numeroView.getText().toString(), complementoView.getText().toString(), bairroView.getText().toString(), municipioView.getText().toString(), (UF)ufView.getSelectedItem());
            boolean ok = Boolean.TRUE;

            return validar(endereco);
        }
    };

    private Boolean validar(Endereco endereco) {
        boolean ok = true;
        try {
            endereco.validarCEP();
        } catch (Exception e){
            cepView.setError(e.getMessage());
            ok = false;
        }

        try {
            endereco.validarLogradouro();
        } catch (Exception e){
            logradouroView.setError(e.getMessage());
            ok = false;
        }

        try {
            endereco.validarBairro();
        } catch (Exception e){
            bairroView.setError(e.getMessage());
            ok = false;
        }

        try {
            endereco.validarMunicipio();
        } catch (Exception e){
            municipioView.setError(e.getMessage());
            ok = false;
        }

        return ok;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endereco_inserir_view);

        cepModel = CEP.getInstance();
        endpoint = RetrofitHelper.with(this).createEnderecoEndpoint();

        cepView = getViewById(R.id.cep);
        logradouroView = getViewById(R.id.logradouro);
        numeroView = getViewById(R.id.numero);
        complementoView = getViewById(R.id.complemento);
        bairroView = getViewById(R.id.bairro);
        municipioView = getViewById(R.id.municipio);
        ufView = getViewById(R.id.uf);
        sqlite = new EnderecoSQLiteHelper(this);
        municipioView.setOnEditorActionListener(editorAction);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ufView.setAdapter(new ArrayAdapter<UF>(this, android.R.layout.simple_list_item_1, UF.values()));
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
        try {
            Endereco model = Endereco.of(cepView.getText().toString(), logradouroView.getText().toString(), numeroView.getText().toString(), complementoView.getText().toString(), bairroView.getText().toString(), municipioView.getText().toString(), (UF) ufView.getSelectedItem());
            if(validar(model)) {
                sqlite.salvar(model);
                Log.i(TIPO_DE_LOG, "Endereço salvo!");
                Toast.makeText(this, R.string.lab04_endereco_salvo, Toast.LENGTH_SHORT).show();
                finish();
            }
        }catch (Exception e){
            Log.e(TIPO_DE_LOG, "Erro de gravação", e);
            Toast.makeText(this, "OPS", Toast.LENGTH_LONG).show();
        }
    }


    public void consultarCep(final View v){
        Toast toast;

        try {
            cepModel.setCodigo(cepView.getText().toString());
            cepModel.validar();
            Log.i(TIPO_DE_LOG, "CEP válido!");
            toast = Toast.makeText(this, R.string.lab04_endereco_buscando, Toast.LENGTH_SHORT);
            Call<EnderecoDTO> call = endpoint.consultarCEP(cepModel.getCodigo());
            call.enqueue(new Callback<EnderecoDTO>() {
                @Override
                public void onResponse(Call<EnderecoDTO> call, Response<EnderecoDTO> response) {
                    Log.i(TIPO_DE_LOG, "Chamada do RetroFit deu certo!");
                    EnderecoDTO dto;
                    if(response.isSuccessful()){
                        dto = response.body();
                        Log.d(TIPO_DE_LOG, "Objeto do DTO:" + dto.toString());
                        logradouroView.setText(dto.getLogradouro());
                        complementoView.setText(dto.getComplemento());
                        bairroView.setText(dto.getBairro());
                        municipioView.setText(dto.getCidade());
                        UF uf = UF.valueOf(dto.getEstado());
                        ufView.setSelection(uf.ordinal());

                        if (v != null) {
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                        }

                        Log.i(TIPO_DE_LOG, "DTO Sucessful");
                    }
                }

                @Override
                public void onFailure(Call<EnderecoDTO> call, Throwable t) {
                    Log.w(TIPO_DE_LOG, "Chamada do RetroFit errado!", t);
                }
            });
            // TODO Preencher os campos do formulário
        } catch (Exception cause){
            Log.i(TIPO_DE_LOG, "OPS...", cause);
            toast = Toast.makeText(this, cause.getMessage(), Toast.LENGTH_LONG);
            cepView.requestFocus();
        }

        toast.show();
    }
}
