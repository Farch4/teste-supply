package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
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
  private List<Contato> contatos = new ArrayList<>();

  @PostConstruct
  public void posConstructor() throws IOException {

    if(contatos.isEmpty())service.feedBase();
    contatos= service.getContatos();
  }

  public List<Contato> getContatos() {
    return contatos;
  }

}
