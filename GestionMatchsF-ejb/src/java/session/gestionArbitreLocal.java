/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entites.Arbitre;
import entites.Equipe;
import entites.Joueur;
import entites.Matchs;
import entites.carton;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author katia
 */
@Local
public interface gestionArbitreLocal {

   

    void CreerFauteJoueur(carton type, long id, int idM);

    boolean ModifierMatch(int butEqUn, int butEqDeux, int idm);

    Collection<Equipe> LesEquipes();
    
    Collection<Joueur> LesJoueurs();
    
    Collection<Matchs> RechercherTousLesMatchs();

    Arbitre authArb(String log, String mdp);

    Collection<Matchs> TousLesMaArb(Arbitre a);

    Matchs matchID(int idm);

    List<Joueur> joueurMa(Matchs m);
    
    
}
