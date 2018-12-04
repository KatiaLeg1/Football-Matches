/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entites.Entraineur;
import entites.Equipe;
import entites.HistoriqueEntraineur;
import entites.HistoriqueJoueur;
import entites.Joueur;
import facade.EquipesFacadeLocal;
import facade.HistoriqueJoueurFacadeLocal;
import javax.ejb.Stateless;
import facade.JoueursFacade;
import facade.JoueursFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author katia
 */
@Stateless
public class gestionEntraineur implements gestionEntraineurLocal {

    @EJB
    private EquipesFacadeLocal equipesFacade;

    @EJB
    private HistoriqueJoueurFacadeLocal historiqueJoueurFacade;

    @EJB
    private JoueursFacadeLocal joueursFacade;

    
    
    @Override
    public void affectationJoueur(String nom, String prenom, Entraineur en, String nome, Date dateDebutHJ) {
        Joueur j = null;
        joueursFacade.RechercherJoueur(nom, prenom);
        Equipe e = null;
        nome = en.getNomPersonne();
        e = equipesFacade.RechercherEquipeParEntraineur(nome);
   
        if(j!=null){
        HistoriqueJoueur h = null;
        h = historiqueJoueurFacade.rechercherHistorique(j);
        
            if(h==null){
                Date dateFinHJ = null;
                historiqueJoueurFacade.creerHJoueur(dateDebutHJ, dateFinHJ, j, e);   
                
            }
        }
        
        else{
            
            System.out.println("Joueur sous contrat");
                 
                }
        /*if(h!=null){
                Equipe eq;
                eq = h.getEquipeJoueur();
                Date dateDebut;
                dateDebut = h.getDateDebutEq();
                joueursFacade.affecterJoueur(h, eq, dateDebut);
            
        }*/   
    }

    @Override
    public Equipe rechercheEquipeParEntraineur(String nom) {
        return null;
    }
        
    
    @Override
    public void transfertJoueur(String nom, String prenom) {
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
                Date dateFin;
                dateFin = h.getDateFinEq();
                joueursFacade.transfererJoueur(h, eq, dateDebut, dateFin);
            }
        }
    }

    @Override
    public Joueur rechercherJoueurId(long id) {
        Joueur j = null;
        j = joueursFacade.rechercherJoueurId(id);
        return j;
    }

    @Override
    public List<Joueur> affichageJoueurs() {
        return joueursFacade.recupJoueur();
    }
   
    
   
}
