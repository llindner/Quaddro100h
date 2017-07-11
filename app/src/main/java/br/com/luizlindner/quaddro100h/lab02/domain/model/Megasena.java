package br.com.luizlindner.quaddro100h.lab02.domain.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Luiz on 07/07/2017.
 */

public final class Megasena {
    private Megasena(){
        super();
    }

    public static String sortear() {
        final Byte[] jogo = {0, 0, 0, 0, 0, 0};

        int sorteadas = 0;
        Byte next;
        while(sorteadas < 6){
            next = (byte) (1 + Math.random() * 60);
            if(!Arrays.asList(jogo).contains(next)) {
                jogo[sorteadas] = next;
                sorteadas++;
            }
        }

        Collections.sort(Arrays.asList(jogo));
        return String.format("%02d  %02d  %02d  %02d  %02d  %02d", jogo);
    }

    public static ArrayList<String> sortear(int jogos){
        ArrayList<String> lista = new ArrayList<>();

        int jogosFeitos = 0;
        String sorteada;
        while(jogosFeitos < jogos) {
            sorteada = sortear();
            if(!lista.contains(sorteada)){
                lista.add(sorteada);
            }
            jogosFeitos++;
        }

        Collections.sort(lista);
        return lista;
    }
}
