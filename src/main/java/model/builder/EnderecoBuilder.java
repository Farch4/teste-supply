package model.builder;

import model.Contato;
import model.Endereco;

public class EnderecoBuilder {
    private String id;
    private Contato contato;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    public EnderecoBuilder id(String id) {
        this.id = id;
        return this;
    }

    public EnderecoBuilder contato(Contato contato) {
        this.contato = contato;
        return this;
    }

    public EnderecoBuilder endereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public EnderecoBuilder bairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public EnderecoBuilder cidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public EnderecoBuilder uf(String uf) {
        this.uf = uf;
        return this;
    }

    public EnderecoBuilder cep(String cep) {
        this.cep = cep;
        return this;
    }

    public Endereco build() {
        return new Endereco(id, contato, endereco, bairro, cidade, uf, cep);
    }
}
