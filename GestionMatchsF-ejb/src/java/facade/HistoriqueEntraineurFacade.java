/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entites.Entraineur;
import entites.Equipe;
import entites.HistoriqueEntraineur;
import entites.HistoriqueJoueur;
import entites.Joueur;
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
public class HistoriqueEntraineurFacade extends AbstractFacade<HistoriqueEntraineur> implements HistoriqueEntraineurFacadeLocal {

    @PersistenceContext(unitName = "GestionMatchsF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoriqueEntraineurFacade() {
        super(HistoriqueEntraineur.class);
    }

    @Override
    public void CreerHE(Date dateDebutHE, Equipe equipe, Entraineur entraineur) {
        HistoriqueEntraineur he = new HistoriqueEntraineur();
        he.setDateDebutEnt(dateDebutHE);
        he.setEntraineur(entraineur);
        he.setEquipeEntraineur(equipe);
        em.persist(he);
    }


    @Override
    public Equipe EqActuelleEnt(Entraineur entraineur) {
        Equipe e ;
        String text = "SELECT he FROM HistoriqueEntraineur AS he where he.entraineur=:entraineur and he.dateFinEnt IS NULL";
        Query requete = em.createQuery(text);
        requete.setParameter("entraineur", entraineur); 
        List<HistoriqueEntraineur> liste =  requete.getResultList();
        if (!liste.isEmpty())
            return e = liste.get(0).getEquipeEntraineur();
        else return null;    }

    @Override
    public void ModifHistoEnt(HistoriqueEntraineur historiqueE, Date datefin) {
        historiqueE.setDateFinEnt(datefin);
        em.merge(historiqueE);
    }

    @Override
    public HistoriqueEntraineur HistoActuel(Entraineur entraineur) {
        HistoriqueEntraineur he ;
        String text = "SELECT he FROM HistoriqueEntraineur AS he where he.entraineur=:entraineur and he.dateFinEnt IS NULL";
        Query requete = em.createQuery(text);
        requete.setParameter("entraineur", entraineur); 
        List<HistoriqueEntraineur> liste =  requete.getResultList();
        if (!liste.isEmpty())
            return he = liste.get(0);
        else return null;      
    }

    @Override
    public List<HistoriqueEntraineur> HistoEntraineur(int e) {
        // tu recherches la liste des historiques entraineur pour 1 entraineur
        List<HistoriqueEntraineur> he;
        String req = "SELECT he from HistoriqueEntraineur as he where he.entraineur.id=:e";
        Query requete = em.createQuery(req);
        requete.setParameter("e",e);
        he = requete.getResultList();
        return he;      
    }

 

}
    
