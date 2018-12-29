/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entites.Arbitre;
import entites.Entraineur;
import entites.Equipe;
import entites.Faute;
import entites.Joueur;
import entites.Matchs;
import java.util.Date;
import javax.ejb.Local;
import java.util.Collection;
import java.util.List;


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

    boolean CreerMAtch(Date dateMatch, String heure, String nomequipeUn, String nomequipeDeux,int ida);

    Collection<Equipe> LesEquipes();

    Collection<Arbitre> LesArbitres();

    void ModifierMatch(int idm, Date dateM1, String heure);

    void AffecterHisoEntr(Date datehisto, int id, String nomEq);

    Collection<Entraineur> TousLesEntraineurs();

    List<Faute> AfficherFauteDate(Date date);

    List<Faute> AfficherFauteJoueur(int id);

    List<Joueur> TousLesJoueurs();

    List<Faute> AfficherFauteArbitre(int arbitreid);

    void Sanctionner(int id, Date datei);

    List<Matchs> TousLesMAtchs();



    
}
