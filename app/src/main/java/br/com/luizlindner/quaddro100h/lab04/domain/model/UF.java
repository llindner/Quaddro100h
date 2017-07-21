package br.com.luizlindner.quaddro100h.lab04.domain.model;

import java.io.Serializable;

/**
 * Created by Luiz on 12/07/2017.
 */

public enum UF implements Serializable {
    ESCOLHA("--"), AC, AL, AP, AM, BA, CE, DF, ES, GO, MA, MT, MS, MG, PA, PB, PR, PE, PI, RJ, RN, RS, RO, RR, SC, SP, SE, TO;

    private String descricao;

    UF(){
        this.descricao = super.toString();
    }

    UF(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
