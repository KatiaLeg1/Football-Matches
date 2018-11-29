/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entites.Arbitre;
import entites.Equipe;
import entites.Match;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author katia
 */
@Local
public interface MatchFacadeLocal {

    void create(Match match);

    void edit(Match match);

    void remove(Match match);

    Match find(Object id);

    List<Match> findAll();

    List<Match> findRange(int[] range);

    int count();

    void CreerMatch(Date date, String heure, Equipe equipeUn, Equipe equipeDeux, Arbitre aribtre);

    void ModifierPoint(int butEquipeUn, int butEquipeDeux, long idMatch);
    
}
