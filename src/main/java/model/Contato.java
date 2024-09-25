package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Contato implements Serializable {

  @Id
  private String cpfCnpj;

  private String nome;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "contato")
  private List<Endereco> enrecos;

  public String getCpfCnpj() {
    return this.cpfCnpj;
  }

  public void setCpfCnpj(final String cpfCnpj) {
    this.cpfCnpj = cpfCnpj;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(final String nome) {
    this.nome = nome;
  }

  public List<Endereco> getEnderecos() {
    return this.enrecos;
  }

  public void setEnderecos(final List<Endereco> enrecos) {
    this.enrecos = enrecos;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (this.cpfCnpj == null ? 0 : this.cpfCnpj.hashCode());
    return result;
  }

  public Contato(String cpfCnpj, String nome, List<Endereco> enrecos) {
    this.cpfCnpj = cpfCnpj;
    this.nome = nome;
    this.enrecos = enrecos;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    final Contato other = (Contato) obj;
    if (this.cpfCnpj == null) {
      if (other.cpfCnpj != null) {
        return false;
      }
    } else if (!this.cpfCnpj.equals(other.cpfCnpj)) {
      return false;
    }
    return true;
  }

}
