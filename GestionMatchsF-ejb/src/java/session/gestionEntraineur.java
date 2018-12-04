/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entites.Equipe;
import entites.HistoriqueJoueur;
import entites.Joueur;
import facade.HistoriqueJoueurFacadeLocal;
import javax.ejb.Stateless;
import facade.JoueursFacade;
import facade.JoueursFacadeLocal;
import java.util.Date;
import javax.ejb.EJB;

/**
 *
 * @author katia
 */
@Stateless
public class gestionEntraineur implements gestionEntraineurLocal {

    @EJB
    private HistoriqueJoueurFacadeLocal historiqueJoueurFacade;

    @EJB
    private JoueursFacadeLocal joueursFacade;

    
    
    @Override
    public void affectationJoueur(String nom, String prenom) {
        Joueur j = null;
        joueursFacade.RechercherJoueur(nom, prenom);
    
        if(j!=null){
        HistoriqueJoueur h = null;
        historiqueJoueurFacade.rechercherHistorique(j);
        
            if(h!=null){
                Equipe eq;
                eq = h.getEquipeJoueur();
                Date dateDebut;
                dateDebut = h.getDateDebutEq();
                joueursFacade.affecterJoueur(h, eq, dateDebut);
            
        }
        
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    
}
    
}
