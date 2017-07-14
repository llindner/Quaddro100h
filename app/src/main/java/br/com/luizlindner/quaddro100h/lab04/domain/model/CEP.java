package br.com.luizlindner.quaddro100h.lab04.domain.model;

import java.io.Serializable;
import java.util.Locale;

/**
 * Created by Luiz on 12/07/2017.
 */

public class CEP implements Serializable {
    private String codigo;

    private CEP() {
    }

    public static CEP getInstance(){
        return new CEP();
    }

    public static CEP of(String c){
        CEP cep = getInstance();
        cep.setCodigo(c);
        return cep;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "CEP{" +
                "codigo='" + codigo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CEP cep = (CEP) o;

        return getCodigo() != null ? getCodigo().equals(cep.getCodigo()) : cep.getCodigo() == null;

    }

    @Override
    public int hashCode() {
        return getCodigo() != null ? getCodigo().hashCode() : 0;
    }
}
