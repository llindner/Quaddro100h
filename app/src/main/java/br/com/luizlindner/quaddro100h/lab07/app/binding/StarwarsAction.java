package br.com.luizlindner.quaddro100h.lab07.app.binding;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.PopupWindow;

import br.com.luizlindner.quaddro100h.databinding.StarwarsInserirViewBinding;
import br.com.luizlindner.quaddro100h.lab07.app.controller.StarwarsInserirActivity;
import br.com.luizlindner.quaddro100h.lab07.app.service.ConsultarStarwarsService;

/**
 * Created by Luiz on 22/07/2017.
 */

public class StarwarsAction {
    private StarwarsInserirViewBinding binding;

    public StarwarsAction(StarwarsInserirViewBinding binding) {
        this.binding = binding;
    }

    public void buscarId(View v){
        Context c = v.getContext();

        StarwarsInserirActivity.progress = new ProgressDialog(c);
        StarwarsInserirActivity.progress.setTitle("Carregando");
        StarwarsInserirActivity.progress.setMessage("Estamos buscando essa informção em uma galáxia muito distante...");
        StarwarsInserirActivity.progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        StarwarsInserirActivity.progress.show();

        Intent i = new Intent(c, ConsultarStarwarsService.class);
        i.putExtra("id", binding.swTxtPersonId.getText().toString());

        c.startService(i);
        v.requestFocus();
    }

}
