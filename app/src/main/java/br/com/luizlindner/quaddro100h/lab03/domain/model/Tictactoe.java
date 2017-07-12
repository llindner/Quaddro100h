package br.com.luizlindner.quaddro100h.lab03.domain.model;

import android.util.Log;

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

    public static int move(String[] casas) {
        Boolean empty = true;
        for (int i = 0; i < casas.length; i++) {
            if(casas[i] != ""){
                empty = false;
            }
        }

        if(empty == true){
            return (int)(Math.random() * casas.length);
        }else{
            for (int i = 0; i < casas.length; i++) {
                if(casas[i] == "X"){
                    Integer retorno = possibleClose(casas, i, "X");
                    if(retorno != -1){
                        return retorno;
                    }
                }
            }

            for (int i = 0; i < casas.length; i++) {
                if(casas[i] == "O"){
                    Integer retorno = possibleClose(casas, i, "O");
                    if(retorno != -1){
                        return retorno;
                    }
                }
            }

            Boolean fechou = false;
            Integer pos = -1;
            while(fechou == false){
                pos = (int)(Math.random() * casas.length);
                Log.i("---------------->", "Posição no move:"+pos);
                if(casas[pos] == ""){
                    fechou = true;
                }
            }
            return pos;
        }
    }

    public static boolean verificaEmpate(String[] casas) {
        Boolean full = true;
        for (int i = 0; i < casas.length; i++) {
            if(casas[i] == ""){
                full = false;
            }
        }
        if(full){
            return true;
        }else {
            return false;
        }
    }

    private static Integer possibleClose(String[] casas, Integer pos, String simbolo){
        switch(pos){
            case 0:
                return possibleClose0(casas, simbolo);
            case 1:
                return possibleClose1(casas, simbolo);
            case 2:
                return possibleClose2(casas, simbolo);
            case 3:
                return possibleClose3(casas, simbolo);
            case 4:
                return possibleClose4(casas, simbolo);
            case 5:
                return possibleClose5(casas, simbolo);
            case 6:
                return possibleClose6(casas, simbolo);
            case 7:
                return possibleClose7(casas, simbolo);
            case 8:
                return possibleClose8(casas, simbolo);
        }
        return -1;
    }

    private static int possibleClose0(String[] casas, String simbolo){

        if(casas[1] == simbolo && casas[2] == ""){
            return 2;
        }
        if(casas[2] == simbolo && casas[1] == ""){
            return 1;
        }
        if(casas[3] == simbolo && casas[6] == ""){
            return 6;
        }
        if(casas[6] == simbolo && casas[3] == ""){
            return 3;
        }
        if(casas[4] == simbolo && casas[8] == ""){
            return 8;
        }
        if(casas[8] == simbolo && casas[4] == ""){
            return 4;
        }
        return -1;
    }

    private static int possibleClose1(String[] casas, String simbolo){
        if(casas[0] == simbolo && casas[2] == ""){
            return 2;
        }
        if(casas[2] == simbolo && casas[0] == ""){
            return 0;
        }
        if(casas[4] == simbolo && casas[7] == ""){
            return 7;
        }
        if(casas[7] == simbolo && casas[4] == ""){
            return 4;
        }
        return -1;
    }

    private static int possibleClose2(String[] casas, String simbolo){
        if(casas[0] == simbolo && casas[1] == ""){
            return 1;
        }
        if(casas[1] == simbolo && casas[0] == ""){
            return 0;
        }
        if(casas[4] == simbolo && casas[6] == ""){
            return 6;
        }
        if(casas[6] == simbolo && casas[4] == ""){
            return 4;
        }
        if(casas[5] == simbolo && casas[8] == ""){
            return 8;
        }
        if(casas[8] == simbolo && casas[5] == ""){
            return 5;
        }
        return -1;
    }

    private static int possibleClose3(String[] casas, String simbolo){
        if(casas[0] == simbolo && casas[6] == ""){
            return 6;
        }
        if(casas[6] == simbolo && casas[0] == ""){
            return 0;
        }
        if(casas[4] == simbolo && casas[5] == ""){
            return 5;
        }
        if(casas[5] == simbolo && casas[4] == ""){
            return 4;
        }
        return -1;
    }

    private static int possibleClose4(String[] casas, String simbolo){
        if(casas[0] == simbolo && casas[8] == ""){
            return 8;
        }
        if(casas[8] == simbolo && casas[0] == ""){
            return 0;
        }
        if(casas[1] == simbolo && casas[7] == ""){
            return 7;
        }
        if(casas[7] == simbolo && casas[1] == ""){
            return 1;
        }
        if(casas[2] == simbolo && casas[6] == ""){
            return 6;
        }
        if(casas[6] == simbolo && casas[2] == ""){
            return 2;
        }
        if(casas[3] == simbolo && casas[5] == ""){
            return 5;
        }
        if(casas[5] == simbolo && casas[3] == ""){
            return 3;
        }
        return -1;
    }

    private static int possibleClose5(String[] casas, String simbolo){
        if(casas[2] == simbolo && casas[8] == ""){
            return 8;
        }
        if(casas[8] == simbolo && casas[2] == ""){
            return 2;
        }
        if(casas[4] == simbolo && casas[3] == ""){
            return 3;
        }
        if(casas[3] == simbolo && casas[4] == ""){
            return 4;
        }
        return -1;
    }

    private static int possibleClose6(String[] casas, String simbolo){
        if(casas[3] == simbolo && casas[0] == ""){
            return 0;
        }
        if(casas[0] == simbolo && casas[3] == ""){
            return 3;
        }
        if(casas[4] == simbolo && casas[2] == ""){
            return 2;
        }
        if(casas[2] == simbolo && casas[4] == ""){
            return 4;
        }
        if(casas[7] == simbolo && casas[8] == ""){
            return 8;
        }
        if(casas[8] == simbolo && casas[7] == ""){
            return 7;
        }
        return -1;
    }

    private static int possibleClose7(String[] casas, String simbolo){
        if(casas[6] == simbolo && casas[8] == ""){
            return 8;
        }
        if(casas[8] == simbolo && casas[6] == ""){
            return 6;
        }
        if(casas[4] == simbolo && casas[1] == ""){
            return 1;
        }
        if(casas[1] == simbolo && casas[4] == ""){
            return 4;
        }
        return -1;
    }

    private static int possibleClose8(String[] casas, String simbolo){
        if(casas[4] == simbolo && casas[0] == ""){
            return 0;
        }
        if(casas[0] == simbolo && casas[4] == ""){
            return 4;
        }
        if(casas[5] == simbolo && casas[2] == ""){
            return 2;
        }
        if(casas[2] == simbolo && casas[5] == ""){
            return 5;
        }
        if(casas[7] == simbolo && casas[6] == ""){
            return 6;
        }
        if(casas[6] == simbolo && casas[7] == ""){
            return 7;
        }
        return -1;
    }
}
