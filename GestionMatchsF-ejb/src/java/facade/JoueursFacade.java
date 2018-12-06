/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entites.Equipe;
import entites.Faute;
import entites.HistoriqueEntraineur;
import entites.HistoriqueJoueur;
import entites.Joueur;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;


/**
 *
 * @author katia
 */
@Stateless
public class JoueursFacade extends AbstractFacade<Joueur> implements JoueursFacadeLocal {

    @PersistenceContext(unitName = "GestionMatchsF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JoueursFacade() {
        super(Joueur.class);
    }


    @Override
    public void CreerJoueur(String nomJ, String prenomJ) {
        Joueur j = new Joueur();
        Date dateInterdiction =null;
        j.setNomPersonne(nomJ);
        j.setPrenomPersonne(prenomJ);
        j.setDateInterdiction(dateInterdiction);
        em.persist(j);

    }

    @Override
    public void SupprimerJoueur(String nom) {
        Joueur j = null;        
        String txt = "SELECT j FROM Joueur AS j WHERE ing.nomJ=:no";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("no", nom);        
        List<Joueur> res = req.getResultList();
        if (res.size() >= 1)
        {
              j = (Joueur) res.get(0); 
              em.remove(j);
        }
    }

    @Override
    public List<Joueur> recupJoueur() {
        String req = "SELECT j from Joueur as j";
        Query requete = em.createQuery(req);
        List<Joueur> liste = requete.getResultList();
        return liste;
    }

    @Override
    public Joueur RechercherJoueur(String nomPersonne, String prenomPersonne) {
        Joueur j = null;
        String txt = "SELECT j FROM Joueur AS j WHERE j.nomPersonne=:no and j.prenomPersonne=:preno";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("no", nomPersonne);
        req = req.setParameter("preno", prenomPersonne);
        j=(Joueur)req.getSingleResult();
        if (!(j==null)) 
        {
                return j;
        } else {
            return null ;
        } 
        
     
    
}
    @Override
    public void affecterJoueur(HistoriqueJoueur histo, Equipe eq, Date dateDebut) {
        histo.setEquipeJoueur(eq);
        histo.setDateDebutEq(dateDebut);
        em.merge(histo);
    }

    @Override
    public void transfererJoueur(HistoriqueJoueur histo, Equipe eq, Date dateDebut, Date dateFin) {
        histo.setDateFinEq(dateFin);
        em.merge(histo);
        
        affecterJoueur(histo, eq, dateDebut);
    }

    @Override
    public Joueur rechercherJoueurId(Long id) {
        Joueur j = null;
        String txt = "SELECT j FROM Joueur AS j WHERE j.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("id", id);
        j=(Joueur)req.getSingleResult();
        if (!(j==null)) 
        {
                return j;
        }
        
        else {
            return null;
        }
    }
    @Override
    public List<Joueur> AfficherTousLesJoueurs() {
        List<Joueur> j;
        String text ="SELECT j FROM Joueurs AS j";
        Query req = getEntityManager().createQuery(text);
        j = req.getResultList();
        return j;
    }

}