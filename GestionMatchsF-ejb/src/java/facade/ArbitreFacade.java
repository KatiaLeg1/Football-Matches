/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entites.Arbitre;
import entites.Match;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author katia
 */
@Stateless
public class ArbitreFacade extends AbstractFacade<Arbitre> implements ArbitreFacadeLocal {

    @PersistenceContext(unitName = "GestionMatchs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArbitreFacade() {
        super(Arbitre.class);
    }

    @Override
    public void CreerArbitre(String nom, String prenom, String login, String mdp) {
        List matchsArbitreListe = new ArrayList<Match>();
        Arbitre a = new Arbitre();
        a.setNomPersonne(nom);
        a.setPrenomPersonne(prenom);
        a.setLogin(login);
        a.setMdp(mdp);
        a.setMatchsArbitre(matchsArbitreListe);
        em.persist(a);
    }

    @Override
    public Collection<Arbitre> TouslesArbitres() {
        List<Arbitre> a;
        String tex = "SELECT a from Arbitre as a";
        Query req = getEntityManager().createQuery(tex);
        a = req.getResultList();
        return a;
    }

    @Override
    public Arbitre RechercherArbitre(String nomPersonne, String prenomPersonne) {
        String req = "SELECT a from Arbitre as a where a.nomPersonne=:n AND a.npreomPersonne=:p ";      
        Query requete = em.createQuery(req);
        requete.setParameter("n", nomPersonne);
        requete.setParameter("p", prenomPersonne);
        Arbitre a = (Arbitre) requete.getSingleResult();
        if (!(a==null)) {
                return a;
        } else {
            return null ;
        }        
    }

   
    }

    
    
    
    
    
