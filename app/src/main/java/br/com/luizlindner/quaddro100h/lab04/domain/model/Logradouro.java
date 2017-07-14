package br.com.luizlindner.quaddro100h.lab04.domain.model;

import java.io.Serializable;
import java.util.Locale;

/**
 * Created by Luiz on 12/07/2017.
 */

public class Logradouro implements Serializable {
    private String tipo;
    private String nome;
    private Bairro bairro;

    public Logradouro() {
        super();
        this.bairro = new Bairro();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public void setUf(UF uf) {
        getBairro().setUf(uf);
    }

    public void setMunicipioNome(String nome) {
        getBairro().setMunicipioNome(nome);
    }

    public void setBairroNome(String nome) {
        getBairro().setNome(nome);
    }

    @Override
    public String toString() {
        return "Logradouro{" +
                "tipo='" + tipo + '\'' +
                ", nome='" + nome + '\'' +
                ", bairro=" + bairro +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Logradouro that = (Logradouro) o;

        if (getTipo() != null ? !getTipo().equals(that.getTipo()) : that.getTipo() != null)
            return false;
        if (getNome() != null ? !getNome().equals(that.getNome()) : that.getNome() != null)
            return false;
        return getBairro() != null ? getBairro().equals(that.getBairro()) : that.getBairro() == null;

    }

    @Override
    public int hashCode() {
        int result = getTipo() != null ? getTipo().hashCode() : 0;
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (getBairro() != null ? getBairro().hashCode() : 0);
        return result;
    }
}