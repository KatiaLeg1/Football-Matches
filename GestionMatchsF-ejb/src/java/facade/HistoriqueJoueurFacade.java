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
        String txt = "SELECT h FROM HistoriqueJoueur AS h WHERE h.joueur:=joueur ";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("joueur", joueur);
        h = (HistoriqueJoueur)req.getSingleResult();
        if (!(h==null)) 
        {
                return h;
        } else {
            return null ;
        }    
}
    
    
}
