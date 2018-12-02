/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entites.Arbitre;
import entites.Equipe;
import java.util.Date;
import javax.ejb.Local;
import java.util.Collection;


/**
 *
 * @author katia
 */
@Local
public interface gestionFederationLocal {

    void CreerEquipe(String nomE);

    void CreerArbitre(String nom, String prenom, String login, String mdp);

    void CreerEntraineur(String nom, String prenom, String login, String mdp);

    void CreerJoueur(String nom, String prenom);

    void CreerMAtch(Date dateMatch, String heure, String nomequipeUn, String nomequipeDeux, String nomarbitre,String prenomarbitre);

    Collection<Equipe> LesEquipes();

    Collection<Arbitre> LesArbitres();

    
}
