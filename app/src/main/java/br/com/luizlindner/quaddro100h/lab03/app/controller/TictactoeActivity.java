package br.com.luizlindner.quaddro100h.lab03.app.controller;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
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
    private Integer dificuldade;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe_view);

        //inicio();
        verificarDificuldade();
    }

    private void inicio() {
        turno = Tictactoe.sortearInicio();

        if(turno == "U") {
            toast = Toast.makeText(getApplicationContext(), "Quem começa é VOCÊ!", Toast.LENGTH_LONG);
        }else{
            toast = Toast.makeText(getApplicationContext(), "Quem começa SOU EU!", Toast.LENGTH_LONG);
            jogadaPC();
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
            msgFinal("Você venceu!");
        }else{
            jogadaPC();
        }
    }

    private void jogadaPC() {
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        if(Tictactoe.verificaEmpate(casas)){
                            msgFinal("Empate!");
                        }else{
                            Integer posicao = Tictactoe.move(casas);
                            Log.i("------------------>", "Posição que veio:"+posicao);
                            casas[posicao] = "X";
                            ImageView v2 = (ImageView)findViewById(getResources().getIdentifier("img_casa" + posicao, "id", getPackageName()));
                            v2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.x));
                            if(Tictactoe.verificaVitoria(casas, "X")){
                                msgFinal("Eu venci!");
                            }else if(Tictactoe.verificaEmpate(casas)){
                                msgFinal("Empate!");
                            }else{
                                turno = "U";
                            }
                        }
                    }
                }, 1000
        );
    }

    private void msgFinal(String mensagem){
        toast = Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_LONG);
        toast.show();
        turno = "GO";
    }

    public void reiniciar(View v){
        for (int i = 0; i < casas.length; i++) {
            ImageView v2 = (ImageView)findViewById(getResources().getIdentifier("img_casa" + i, "id", getPackageName()));
            v2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vazio));
            casas[i] = "";
        }
        //inicio();
        verificarDificuldade();
    }

    private void verificarDificuldade(){
        Log.i("--->", "veio verificar a dificuldade");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.txt_dificuldade);
        builder.setItems(R.array.dificuldade, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dificuldade = which;
                inicio();
            }
        });
        AlertDialog dialog = builder.create();
        builder.show();
    }

}
