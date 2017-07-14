package br.com.luizlindner.quaddro100h.lab04.domain.model;

import java.io.Serializable;
import java.util.Locale;

/**
 * Created by Luiz on 12/07/2017.
 */

public class Municipio implements Serializable {
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

    @Override
    public String toString() {
        return "Municipio{" +
                "nome='" + nome + '\'' +
                ", uf=" + uf +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Municipio municipio = (Municipio) o;

        if (getNome() != null ? !getNome().equals(municipio.getNome()) : municipio.getNome() != null)
            return false;
        return getUf() == municipio.getUf();
    }

    @Override
    public int hashCode() {
        int result = getNome() != null ? getNome().hashCode() : 0;
        result = 31 * result + (getUf() != null ? getUf().hashCode() : 0);
        return result;
    }
}
