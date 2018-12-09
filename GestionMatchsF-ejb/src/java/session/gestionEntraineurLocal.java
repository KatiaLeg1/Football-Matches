/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entites.Entraineur;
import entites.Equipe;
import entites.Joueur;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author katia
 */
@Local
public interface gestionEntraineurLocal {

    void affectationJoueur(long id, String nome, String prenome, Date dateDebutHJ);

    void transfertJoueur(String nom, String prenom);

    Joueur rechercherJoueurId(long id);

    List<Joueur> affichageJoueurs();

    Equipe rechercheEquipeParEntraineur(String nom);

    Entraineur AuthEnt(String log, String mdp);
    
}
