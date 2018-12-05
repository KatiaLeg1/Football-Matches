/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entites.Equipe;
import entites.Joueur;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author katia
 */
@Local
public interface JoueursFacadeLocal {

    void create(Joueur joueurs);

    void edit(Joueur joueurs);

    void remove(Joueur joueurs);

    Joueur find(Object id);

    List<Joueur> findAll();

    List<Joueur> findRange(int[] range);

    int count();

    void CreerJoueur(String nomJ, String prenomJ);

    void SupprimerJoueur(String nom);

    List recupJoueur();    

    Joueur RechercherJoueur(String nomPersonne, String prenomPersonne);

    List<Joueur> AfficherTousLesJoueurs();
}
