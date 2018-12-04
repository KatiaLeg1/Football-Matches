/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entites.Arbitre;
import entites.Equipe;
import entites.Matchs;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author katia
 */
@Local
public interface MatchFacadeLocal {

    void create(Matchs match);

    void edit(Matchs match);

    void remove(Matchs match);

    Matchs find(Object id);

    List<Matchs> findAll();

    List<Matchs> findRange(int[] range);

    int count();

    void CreerMatch(Date date, String heure, Equipe equipeUn, Equipe equipeDeux, Arbitre aribtre);

    void ModifierPoint(int butEquipeUn, int butEquipeDeux, long idMatch);

    List<Matchs> MatchsArbitre(Arbitre arbitre);

    boolean ArbitreLibre(Arbitre arbitre, Date dateMatch);

    boolean EquipeLibre(Equipe equipe, Date dateMatch);

    void ModifierMatch(Matchs m, Date date, String heure);

    Matchs RechercherMatch(Equipe nomEq1, Equipe nomEq2, Date date);
    
}
