package service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Contato;

@Stateless
@LocalBean
public class ContatoService {

  @PersistenceContext(unitName = "sm-teste")
  private EntityManager em;

  @TransactionAttribute(TransactionAttributeType.REQUIRED)
  public void save(final Contato contato) {
    this.em.persist(contato);
  }

}
