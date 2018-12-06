/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entites.Arbitre;
import entites.Faute;
import entites.Joueur;
import entites.Matchs;
import entites.carton;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author katia
 */
@Local
public interface FautesFacadeLocal {

    void create(Faute fautes);

    void edit(Faute fautes);

    void remove(Faute fautes);

    Faute find(Object id);

    List<Faute> findAll();

    List<Faute> findRange(int[] range);

    int count();

    void CreerFaute(carton type, Joueur joueur,  Matchs match);

    List<Faute> AfficherFauteDate(Date dateMatch);

    List<Faute> AfficherFauteArbitre(Arbitre arbitre);

    List<Faute> afficherFauteJoueur(Joueur joueur);
    
}
