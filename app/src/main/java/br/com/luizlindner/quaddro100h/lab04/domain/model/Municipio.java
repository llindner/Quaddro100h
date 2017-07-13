package br.com.luizlindner.quaddro100h.lab04.domain.model;

/**
 * Created by Luiz on 12/07/2017.
 */

public class Municipio {
    private String nome;
    private UF uf;

    public Municipio() {
        super();
        this.uf = UF.ESCOLHA;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }
}
