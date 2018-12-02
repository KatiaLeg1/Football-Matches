/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entites.Arbitre;
import entites.Faute;
import entites.Joueur;
import entites.Match;
import entites.carton;
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
public class FautesFacade extends AbstractFacade<Faute> implements FautesFacadeLocal {

    @PersistenceContext(unitName = "GestionMatchs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FautesFacade() {
        super(Faute.class);
    }

    @Override
    public void CreerFaute(carton type, Joueur joueur,  Match match) {
        Faute f = new Faute();
        f.setTypeFaute(type);
        f.setJoueur(joueur);
        
        f.setMatch(match);
        em.persist(f);
    }

    @Override
    public List<Faute> AfficherFauteDate(Date dateMatch) {
        String req = "SELECT f from Faute as f where f.match.dateMatch=dateMatch";
        Query requete = em.createQuery(req);
        requete.setParameter("dateMatch",dateMatch);
        List<Faute> liste = requete.getResultList();
        return liste;
    }

    @Override
    public List<Faute> AfficherFauteArbitre(Arbitre arbitre) {
        String req = "SELECT f from Faute as f where f.match.arbitre=:arbitre ";
        Query requete = em.createQuery(req);
        requete.setParameter("arbitre",arbitre);
        List<Faute> liste = requete.getResultList();
        return liste;
    }

    @Override
    public List<Faute> afficherFauteJoueur(Joueur joueur) {
        String req = "SELECT f from Faute as f where f.joueur=:joueur ";
        Query requete = em.createQuery(req);
        requete.setParameter("joueur",joueur);
        List<Faute> liste = requete.getResultList();
        return liste;    }
    
    
    
}
