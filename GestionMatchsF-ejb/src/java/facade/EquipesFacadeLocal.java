/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entites.Entraineur;
import entites.Equipe;
import entites.Joueur;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author katia
 */
@Local
public interface EquipesFacadeLocal {

    void create(Equipe equipes);

    void edit(Equipe equipes);

    void remove(Equipe equipes);

    Equipe find(Object id);

    List<Equipe> findAll();

    List<Equipe> findRange(int[] range);

    int count();

    void CreerEquipe(String nomEquipe);

    Collection<Equipe> ToutesLesEquipes();

    Equipe RechercherEquipe(String nomequipe);
    
    Collection<Equipe> Classement();
            
    Equipe RechercherEquipeid(int idequipe);

    void AjoutPt(Equipe e, int pt);

    Equipe rechercherEquipeJoueur(Joueur joueur);
}
