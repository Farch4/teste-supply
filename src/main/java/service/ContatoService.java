package service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Contato;
import model.Endereco;
import model.builder.ContatoBuilder;
import model.builder.EnderecoBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Stateless
@LocalBean
public class ContatoService {

    @PersistenceContext(unitName = "sm-teste")
    private EntityManager em;
    private final String fileAddress = "teste-supply/contatos.txt";

    public void feedBase() throws IOException {
        BufferedReader br = this.extractFile();
        String linha;
        int index=0;
        while ((linha = br.readLine()) != null) {
            if(index>0)save(parseLineToContact(linha));
            index++;
        }
    }

    private BufferedReader extractFile() throws FileNotFoundException {
        return new BufferedReader(new FileReader(fileAddress));
    }

    private Contato parseLineToContact(String linha) {
        String[] campos = linha.split("\\|");
        Contato contato = new ContatoBuilder().cpfCnpj(campos[0]).nome(campos[1]).build();

        Endereco endereco = new EnderecoBuilder().endereco(campos[2]).bairro(campos[3])
                .cep(campos[4]).cidade(campos[5]).uf(campos[6]).contato(contato).build();

        contato.setEnderecos(List.of(endereco));

        return contato;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(final Contato contato) {
        try {
            if (!alreadyExitsContact(contato.getCpfCnpj())) {
                em.persist(contato);
            } else {
                em.persist(contato.getEnderecos().get(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Contato> getContatos() {
        return em.createQuery("SELECT c FROM Contato c", Contato.class).getResultList();
    }

    private boolean alreadyExitsContact(String cpfCnpj) {
        Long count = em.createQuery("SELECT COUNT(c) FROM Contato c WHERE c.cpfCnpj = :cpfCnpj", Long.class)
                .setParameter("cpfCnpj", cpfCnpj)
                .getSingleResult();
        return count > 0;
    }
}

