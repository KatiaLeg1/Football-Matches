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
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author katia
 */
@Local
public interface gestionEntraineurLocal {

    boolean affectationJoueur(long id, Entraineur e,  Date dateDebutHJ);

    void transfertJoueur(String nom, String prenom);

    Joueur rechercherJoueurId(long id);

    List<Joueur> affichageJoueurs();

    Equipe rechercheEquipeParEntraineur(Entraineur e);

    Entraineur AuthEnt(String log, String mdp);

    void CreerCompo(Entraineur ent, List<Joueur> jou, int ma);
    
    List<HistoriqueJoueur> listeJouEnt(Entraineur ent);

    List<Matchs> listeMEq(Entraineur ent);

    void suppressionJoueur(long id);
    
    List<HistoriqueJoueur> listeJouAutreEnt(Entraineur ent);
    
    List<Joueur> listeJLibres();

    public List<HistoriqueJoueur> listeHistoTousJoueurs();

}

