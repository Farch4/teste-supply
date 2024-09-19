package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Endereco {

  @Id
  private String id;

  @ManyToOne
  private Contato contato;

  private String endereco;

  private String bairro;

  private String cidade;

  private String uf;

  private String cep;

  public String getCep() {
    return this.cep;
  }

  public String getId() {
    return this.id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public Contato getContato() {
    return this.contato;
  }

  public void setContato(final Contato contato) {
    this.contato = contato;
  }

  public String getEndereco() {
    return this.endereco;
  }

  public void setEndereco(final String endereco) {
    this.endereco = endereco;
  }

  public String getBairro() {
    return this.bairro;
  }

  public void setBairro(final String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return this.cidade;
  }

  public void setCidade(final String cidade) {
    this.cidade = cidade;
  }

  public String getUf() {
    return this.uf;
  }

  public void setUf(final String uf) {
    this.uf = uf;
  }

}
