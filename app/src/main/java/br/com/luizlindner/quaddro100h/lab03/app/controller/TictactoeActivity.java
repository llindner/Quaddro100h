package br.com.luizlindner.quaddro100h.lab03.app.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroActivity;
import br.com.luizlindner.quaddro100h.lab03.domain.model.Tictactoe;

/**
 * Created by Mobile on 06/07/2017.
 */

public class TictactoeActivity extends QuaddroActivity {

    private String turno;
    private Toast toast;
    private String[] casas = {"", "", "", "", "", "", "", "", ""};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe_view);

        turno = Tictactoe.sortearInicio();

        if(turno == "U") {
            toast = Toast.makeText(getApplicationContext(), "Quem começa é VOCÊ!", Toast.LENGTH_LONG);
        }else{
            toast = Toast.makeText(getApplicationContext(), "Quem começa SOU EU!", Toast.LENGTH_LONG);
        }
        toast.show();
    }

    public void jogar(View v){
        Integer position = Integer.parseInt(v.getResources().getResourceEntryName(v.getId()).substring(8, 9));
        if(turno != "U" || casas[position] != ""){
            return;
        }

        casas[position] = "O";
        ((ImageView) v).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.o));
        turno = Tictactoe.trocarTurno(turno);
        if(Tictactoe.verificaVitoria(casas, "O")){
            toast = Toast.makeText(getApplicationContext(), "Você venceu!", Toast.LENGTH_LONG);
            toast.show();
        }else{
            //setTimeout(move, 1000);
        }
    }
}
