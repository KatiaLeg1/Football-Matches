/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entites.Arbitre;
import entites.Entraineur;
import entites.Equipe;
import entites.HistoriqueEntraineur;
import entites.Joueur;
import entites.Matchs;
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
    List<Joueur> AfficherTousLesJoueurs() ;
    Matchs AfficherJoueursMatch(Equipe nomEq1, Equipe nomEq2, Date date);
    Matchs AfficherJoueursMatch(Long ident, Date date);
    List<Matchs> AfficherTousLesMatchs();
    Collection<Equipe> AfficherToutesLesEquipes();

    Entraineur AuthEntr(String log, String mdp);

    Arbitre AuthArb(String log, String mdp);

    Collection<Entraineur> TousLesEntraineurs();

    List<HistoriqueEntraineur> AfficherHistoEnt(int idE);
}
