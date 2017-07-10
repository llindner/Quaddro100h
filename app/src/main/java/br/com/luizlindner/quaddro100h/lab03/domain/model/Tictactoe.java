package br.com.luizlindner.quaddro100h.lab03.domain.model;

import java.lang.reflect.Array;
import java.util.Random;

/**
 * Created by Luiz on 09/07/2017.
 */

public final class Tictactoe {
    private Tictactoe(){
        super();
    }


    public static String sortearInicio() {
        Random r = new Random();
        if(r.nextBoolean()){
            return "U";
        }else{
            return "PC";
        }
    }

    public static String trocarTurno(String turno) {
        if(turno == "U"){
            return "PC";
        }else{
            return "U";
        }
    }

    public static Boolean verificaVitoria(String[] casas, String simbolo) {
        if(casas[0] == simbolo && casas[1] == simbolo && casas[2] == simbolo){
            return true;
        }
        if(casas[3] == simbolo && casas[4] == simbolo && casas[5] == simbolo){
            return true;
        }
        if(casas[6] == simbolo && casas[7] == simbolo && casas[8] == simbolo){
            return true;
        }
        if(casas[0] == simbolo && casas[3] == simbolo && casas[6] == simbolo){
            return true;
        }
        if(casas[1] == simbolo && casas[4] == simbolo && casas[7] == simbolo){
            return true;
        }
        if(casas[2] == simbolo && casas[5] == simbolo && casas[8] == simbolo){
            return true;
        }
        if(casas[0] == simbolo && casas[4] == simbolo && casas[8] == simbolo){
            return true;
        }
        if(casas[2] == simbolo && casas[4] == simbolo && casas[6] == simbolo){
            return true;
        }
        return false;

    }
}
