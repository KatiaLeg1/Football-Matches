/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entites.Entraineur;
import entites.Equipe;
import entites.HistoriqueEntraineur;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author katia
 */
@Local
public interface HistoriqueEntraineurFacadeLocal {

    void create(HistoriqueEntraineur historiqueEntraineur);

    void edit(HistoriqueEntraineur historiqueEntraineur);

    void remove(HistoriqueEntraineur historiqueEntraineur);

    HistoriqueEntraineur find(Object id);

    List<HistoriqueEntraineur> findAll();

    List<HistoriqueEntraineur> findRange(int[] range);

    int count();

    void CreerHE(Date dateDebutHE, Date dateFinHE, Equipe equipe, Entraineur entraineur);
    
}
