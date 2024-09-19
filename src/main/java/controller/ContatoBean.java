package controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import model.Contato;
import service.ContatoService;

@Named
@ViewScoped
public class ContatoBean implements Serializable {

  private static final long serialVersionUID = 1L;

  @EJB
  private ContatoService service;

  @PostConstruct
  public void posConstructor() {

  }

  public List<Contato> getContatos() {
    final Contato c = new Contato();
    c.setCpfCnpj("11122233344");
    return Arrays.asList(c);
  }
}
