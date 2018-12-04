/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entites.Equipe;
import entites.Joueur;
import facade.EquipesFacade;
import facade.JoueursFacade;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author katia
 */
@Local
public interface gestionToutLocal {

    List<Joueur> AfficherTousLesJoueurs();
}
