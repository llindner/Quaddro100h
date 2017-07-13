package br.com.luizlindner.quaddro100h.lab04.domain.model;

import org.junit.Test;

/**
 * Created by Mobile on 12/07/2017.
 */

public class EnderecoTest {

    @Test
    public void instanciaTest(){
        Endereco e = Endereco.of("02469-120", "Rua", "Campo Comprido", "3", "Apto 24", "Vila Romero", "São Paulo", UF.SP);

        //...
        System.out.println(e);
    }

}
