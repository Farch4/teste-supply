package model.builder;

import model.Contato;
import model.Endereco;

import java.util.ArrayList;
import java.util.List;

public class ContatoBuilder {
    private String cpfCnpj;
    private String nome;
    private List<Endereco> enderecos = new ArrayList<>();

    public ContatoBuilder cpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
        return this;
    }

    public ContatoBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public ContatoBuilder enderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
        return this;
    }

    public Contato build() {
        return new Contato(cpfCnpj, nome, enderecos);
    }
}

