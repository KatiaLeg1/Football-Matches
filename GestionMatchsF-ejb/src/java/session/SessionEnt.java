/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entites.Entraineur;
import entites.Equipe;
import entites.HistoriqueJoueur;
import entites.Joueur;
import entites.Matchs;
import facade.EntraineurFacadeLocal;
import facade.EquipesFacadeLocal;
import facade.HistoriqueEntraineurFacadeLocal;
import facade.HistoriqueJoueurFacadeLocal;
import javax.ejb.Stateless;
import facade.JoueursFacade;
import facade.JoueursFacadeLocal;
import facade.MatchFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author katia
 */
@Stateless
public class SessionEnt implements gestionEntraineurLocal {

     
    @EJB
    private MatchFacadeLocal matchFacade;

    @EJB
    private HistoriqueEntraineurFacadeLocal historiqueEntraineurFacade;

    @EJB
    private EntraineurFacadeLocal entraineurFacade;

    @EJB
    private EquipesFacadeLocal equipesFacade;

    @EJB
    private HistoriqueJoueurFacadeLocal historiqueJoueurFacade;

    @EJB
    private JoueursFacadeLocal joueursFacade;
    
    
    @Override
    public boolean affectationJoueur(long id, Entraineur e, Date dateDebutHJ) {
        boolean a;
        Joueur j = joueursFacade.rechercherJoueurId(id);
        HistoriqueJoueur hj = historiqueJoueurFacade.rechercherHistorique(j);
        Equipe eq = historiqueEntraineurFacade.EqActuelleEnt(e);

        if (!(eq==null)){        
            if(hj!=null){
                historiqueJoueurFacade.ModifHistoJ(hj, dateDebutHJ);
                historiqueJoueurFacade.creerHJoueur(dateDebutHJ, j, eq);   
                a=true;
            }
            else
            {
                historiqueJoueurFacade.creerHJoueur(dateDebutHJ, j, eq);   
                a=true;
            }
        }
        else{
            System.out.println("Pas d'équipe pour l'entraineur");
            a = false;
        } 
        return a;
            
    }

    @Override
    public Equipe rechercheEquipeParEntraineur(Entraineur e) {
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
    

    @Override
    public Entraineur AuthEnt(String log, String mdp) {
        return entraineurFacade.AuthEnt(log, mdp);
    }

    @Override
    public void CreerCompo(Entraineur ent, List<Joueur> jou, int ma) {
                System.out.println("creer compo sess 1");
        
        Matchs m = matchFacade.rechercherMatchID(ma);
                        System.out.println("creer compo sess 2" +m);

        Equipe e = historiqueEntraineurFacade.EqActuelleEnt(ent);
                                System.out.println("creer compo sess 3" +e);

        matchFacade.CreerComposition1(m, e, jou);
                                        System.out.println("compo créée");

    }
    
    
    @Override
    public List<HistoriqueJoueur> listeJouEnt(Entraineur ent) {
        Equipe e = historiqueEntraineurFacade.EqActuelleEnt(ent) ;
        return historiqueJoueurFacade.recupHistoE(e);
    }   
    
    @Override
    public List<HistoriqueJoueur> listeJouAutreEnt(Entraineur ent) {
        Equipe e = historiqueEntraineurFacade.EqActuelleEnt(ent) ;
        return historiqueJoueurFacade.recupHistoAutreE(e);
    }   
    
    public List<HistoriqueJoueur> listeHistoTousJoueurs(){
        return historiqueJoueurFacade.TousHistoJoueurs();
    }
    
    
    @Override
    public List<Matchs> listeMEq(Entraineur ent) {
        Equipe e = historiqueEntraineurFacade.EqActuelleEnt(ent) ;
        return matchFacade.AfficherMatchsEQj(e);
        
    }   

    @Override
    public void suppressionJoueur(long id) {
        HistoriqueJoueur hj = historiqueJoueurFacade.supprimerHistoJ(id);
        Joueur j = joueursFacade.SupprimerJoueur(id); 
    }

    @Override
    public List<Joueur> listeJLibres() {
        return joueursFacade.TousLesJouLibres();
    }
   
    
}
