/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entites.Equipe;
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
public class HistoriqueJoueurFacade extends AbstractFacade<HistoriqueJoueur> implements HistoriqueJoueurFacadeLocal {

    @PersistenceContext(unitName = "GestionMatchsF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoriqueJoueurFacade() {
        super(HistoriqueJoueur.class);
    }

    
    

    @Override
    public void creerHJoueur(Date dateDebutHJ, Joueur joueur, Equipe equipe) {
       HistoriqueJoueur hj = new  HistoriqueJoueur();
       hj.setDateDebutEq(dateDebutHJ);
       hj.setJoueur(joueur);
       hj.setEquipeJoueur(equipe);
       em.persist(hj);
    }
    
    @Override
    public HistoriqueJoueur rechercherHistorique(Joueur joueur) {
        HistoriqueJoueur h = null;
        String text = "SELECT h FROM HistoriqueJoueur AS h where h.joueur=:joueur and h.dateFinEq IS NULL";
        Query requete = em.createQuery(text);
        requete.setParameter("joueur", joueur); 
        List<HistoriqueJoueur> liste =  requete.getResultList();
        if (!liste.isEmpty())
            return h = liste.get(0);
        else return null;   
}
    
    @Override
    public List<HistoriqueJoueur> HistoJoueur(int j) {
        String req = "SELECT hj from HistoriqueJoueur as hj where hj.joueur.id=:j ";
        Query requete = em.createQuery(req);
        requete.setParameter("j",j);
        List<HistoriqueJoueur> liste = requete.getResultList();
        return liste;
    }

    @Override
    public List<HistoriqueJoueur> recupHistoE(Equipe eq) {
        String req = "SELECT hj from HistoriqueJoueur as hj where hj.equipeJoueur=:eq and hj.dateFinEq is null";
        Query requete = em.createQuery(req);
        requete.setParameter("eq",eq);
        List<HistoriqueJoueur> liste = requete.getResultList();
        return liste;
    }

    @Override
    public void ModifHistoJ(HistoriqueJoueur histoJ, Date date) {
        histoJ.setDateFinEq(date);
        em.merge(histoJ);
    }
    
    
    
}
