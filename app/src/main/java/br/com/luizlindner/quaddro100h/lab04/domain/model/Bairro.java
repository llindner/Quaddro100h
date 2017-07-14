package br.com.luizlindner.quaddro100h.lab04.domain.model;

import java.io.Serializable;
import java.util.Locale;

/**
 * Created by Luiz on 12/07/2017.
 */

public class Bairro implements Serializable {
    private String nome;
    private Municipio municipio;

    public Bairro() {
        super();
        this.municipio = new Municipio();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public void setUf(UF uf) {
        getMunicipio().setUf(uf);
    }

    public void setMunicipioNome(String nome) {
        getMunicipio().setNome(nome);
    }

    @Override
    public String toString() {
        return "Bairro{" +
                "nome='" + nome + '\'' +
                ", municipio=" + municipio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bairro bairro = (Bairro) o;

        if (getNome() != null ? !getNome().equals(bairro.getNome()) : bairro.getNome() != null)
            return false;
        return getMunicipio() != null ? getMunicipio().equals(bairro.getMunicipio()) : bairro.getMunicipio() == null;

    }

    @Override
    public int hashCode() {
        int result = getNome() != null ? getNome().hashCode() : 0;
        result = 31 * result + (getMunicipio() != null ? getMunicipio().hashCode() : 0);
        return result;
    }
}
