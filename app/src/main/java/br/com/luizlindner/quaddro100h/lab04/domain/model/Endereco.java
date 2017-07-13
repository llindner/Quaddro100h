package br.com.luizlindner.quaddro100h.lab04.domain.model;

import java.io.Serializable;

/**
 * Created by Luiz on 12/07/2017.
 */

public class Endereco implements Serializable {
    // Alameda Santos, 1000, andar 7 , Jardim Paulista, 00000-000, São Paulo, SP

    private String numero;
    private String complemento;
    private CEP cep;
    private Logradouro logradouro;

    public Endereco(){
        super();
        this.cep = new CEP();
        this.logradouro = new Logradouro();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public CEP getCep() {
        return cep;
    }

    public void setCep(CEP cep) {
        this.cep = cep;
    }

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    public void setUf(UF uf) {
        getLogradouro().setUf(uf);
    }

    public void setMunicipioNome(String nome) {
        getLogradouro().setMunicipioNome(nome);
    }

    public void setBairroNome(String nome) {
        getLogradouro().setBairroNome(nome);
    }

    public void setLogradouroTipo(String tipo) {
        getLogradouro().setTipo(tipo);
    }

    public void setLogradouroNome(String nome) {
        getLogradouro().setNome(nome);
    }

    public void setCEPCodigo(String codigo) {
        getCep().setCodigo(codigo);
    }

    public static Endereco of(String cep, String logradouroTipo, String logradouroNome, String numero, String complemento, String bairro, String municipio, UF uf) {
        Endereco e = new Endereco();

        e.setCEPCodigo(cep);
        e.setLogradouroTipo(logradouroTipo);
        e.setLogradouroNome(logradouroNome);
        e.setNumero(numero);
        e.setComplemento(complemento);
        e.setBairroNome(bairro);
        e.setMunicipioNome(municipio);
        e.setUf(uf);

        return e;
    }
}
