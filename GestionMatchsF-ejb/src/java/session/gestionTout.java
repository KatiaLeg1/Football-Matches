/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entites.Equipe;
import entites.Joueur;
import facade.EquipesFacade;
import facade.EquipesFacadeLocal;
import facade.JoueursFacade;
import facade.JoueursFacadeLocal;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author katia
 */
@Stateless
public class gestionTout implements gestionToutLocal {

    @EJB
    private EquipesFacadeLocal equipesFacade;

    @EJB
    private JoueursFacadeLocal joueursFacade;
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Joueur> AfficherTousLesJoueurs() {
        return joueursFacade.AfficherTousLesJoueurs();
    }

 
    
    
    
}
