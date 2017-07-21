package br.com.luizlindner.quaddro100h.lab04.app.binding;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.databinding.EnderecoAlterarViewBinding;
import br.com.luizlindner.quaddro100h.lab04.app.service.ConsultarCEPService;
import br.com.luizlindner.quaddro100h.lab04.domain.model.Endereco;
import br.com.luizlindner.quaddro100h.lab04.domain.model.UF;

/**
 * Created by Luiz on 20/07/2017.
 */

public class EnderecoAction {

    private EnderecoAlterarViewBinding binding;

    public EnderecoAction(EnderecoAlterarViewBinding binding) {
        this.binding = binding;
    }

    public void consultarCEP(View v){
        Context c = v.getContext();

        Toast.makeText(c, R.string.lab04_endereco_buscando, Toast.LENGTH_SHORT).show();

        Intent i = new Intent(c, ConsultarCEPService.class);
        i.putExtra("cep", binding.cep.getText().toString());
        c.startService(i);
    }

}
