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
    public void CreerFaute(carton type, Joueur joueur, Arbitre arbitre, Match match) {
        Faute f = new Faute();
        f.setTypeFaute(type);
        f.setJoueur(joueur);
        //A rechercher l'arbitre
        f.setArbitre(arbitre);
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
    public List<Faute> AfficherFauteArbitre(String nom, String prenom) {
       String req = "SELECT f from Faute as f where f.match.arbitre.nom=:nom and f.match.arbitre.prenom=:prenom ";
        Query requete = em.createQuery(req);
        requete.setParameter("nom",nom);
        requete.setParameter("prenom",prenom);
        List<Faute> liste = requete.getResultList();
        return liste;
    }

    @Override
    public List<Faute> afficherFauteJoueur(String nom, String prenom) {
String req = "SELECT f from Faute as f where f.joueur.nom=:nom and f.joueur.prenom=:prenom ";
        Query requete = em.createQuery(req);
        requete.setParameter("nom",nom);
        requete.setParameter("prenom",prenom);
        List<Faute> liste = requete.getResultList();
        return liste;    }
    
}
