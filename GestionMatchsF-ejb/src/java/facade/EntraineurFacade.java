/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entites.Entraineur;
import entites.Equipe;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author katia
 */
@Stateless
public class EntraineurFacade extends AbstractFacade<Entraineur> implements EntraineurFacadeLocal {

    @PersistenceContext(unitName = "GestionMatchs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntraineurFacade() {
        super(Entraineur.class);
    }

    @Override
    public void CreerEntraineur(String nomE, String prenomE, String login, String mdp) {
        Entraineur e = new Entraineur();
        List entraineurEqListe = new ArrayList<Equipe>();
        e.setNomPersonne(nomE);
        e.setPrenomPersonne(prenomE);
        e.setLogin(login);
        e.setMdp(mdp);
        e.setHistoriqueEntraineurs(entraineurEqListe);
        em.persist(e);
    }
    
}
