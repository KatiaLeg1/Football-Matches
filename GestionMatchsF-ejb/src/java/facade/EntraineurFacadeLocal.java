/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entites.Entraineur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author katia
 */
@Local
public interface EntraineurFacadeLocal {

    void create(Entraineur entraineur);

    void edit(Entraineur entraineur);

    void remove(Entraineur entraineur);

    Entraineur find(Object id);

    List<Entraineur> findAll();

    List<Entraineur> findRange(int[] range);

    int count();

    void CreerEntraineur(String nomE, String prenomE, String login, String mdp);

    Entraineur RechercherEntraineur(String nomPersonne, String prenomPersonne);

    
    
}
