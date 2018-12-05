/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entites.Equipe;
import entites.Joueur;
import entites.Match;
import facade.EquipesFacade;
import facade.EquipesFacadeLocal;
import facade.JoueursFacade;
import facade.JoueursFacadeLocal;
import facade.MatchFacadeLocal;
import java.util.Collection;
import java.util.Date;
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
    private MatchFacadeLocal matchFacade;

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

    @Override
    public Match AfficherJoueursMatch(Equipe nomEq1, Equipe nomEq2, Date date) {
        Match m = null;
        m = matchFacade.RechercherMatch(nomEq1, nomEq2, date);
        return m;
    }
    
@Override
    public Match AfficherJoueursMatch(Long ident, Date date) {
        Match m = null;
        m = matchFacade.MatchEquipedate(ident, date);
        return m;
    }
    
    @Override
    public List<Match> AfficherTousLesMatchs() {
        return matchFacade.RechercherTousLesMatchs();
    }

    @Override
    public Collection<Equipe> AfficherToutesLesEquipes() {
        return equipesFacade.ToutesLesEquipes();
    }
    
    
    
    
}


 
    
    
    
