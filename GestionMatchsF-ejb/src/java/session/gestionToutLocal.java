/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entites.Equipe;
import entites.Joueur;
import entites.Match;
import facade.EquipesFacade;
import facade.JoueursFacade;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author katia
 */
@Local
public interface gestionToutLocal {

    List<Joueur> AfficherTousLesJoueurs();

    Match AfficherJoueursMatch(Equipe nomEq1, Equipe nomEq2, Date date);

     List<Match> AfficherTousLesMatchs();

    Collection<Equipe> AfficherToutesLesEquipes();
    
      Match AfficherJoueursMatch(Long ident, Date date);      
}
