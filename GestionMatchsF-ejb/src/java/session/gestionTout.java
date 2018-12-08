/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entites.Arbitre;
import entites.Entraineur;
import entites.Equipe;
import entites.Joueur;
import entites.Matchs;
import facade.ArbitreFacadeLocal;
import facade.EntraineurFacadeLocal;
import facade.EquipesFacadeLocal;
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
    private ArbitreFacadeLocal arbitreFacade;

    @EJB
    private EntraineurFacadeLocal entraineurFacade;

    @EJB
    private JoueursFacadeLocal joueursFacade;

    @EJB
    private EquipesFacadeLocal equipesFacade;

    @EJB
    private MatchFacadeLocal matchFacade;
    
    
    @Override
    public List<Joueur> AfficherTousLesJoueurs() {
        return joueursFacade.AfficherTousLesJoueurs();
    }
     @Override
    public Matchs AfficherJoueursMatch(Equipe nomEq1, Equipe nomEq2, Date date) {
        Matchs m = null;
        m = matchFacade.RechercherMatch(nomEq1, nomEq2, date);
        return m;
    }
    
    @Override
    public Matchs AfficherJoueursMatch(Long ident, Date date) {
        Matchs m = null;
        m = matchFacade.MatchEquipedate(ident, date);
        return m;
    }
    
    @Override
    public List<Matchs> AfficherTousLesMatchs() {
        return matchFacade.RechercherTousLesMatchs();
    }
     @Override
    public Collection<Equipe> AfficherToutesLesEquipes() {
        return equipesFacade.ToutesLesEquipes();
    }

    @Override
    public Entraineur AuthEntr(String log, String mdp) {
        return entraineurFacade.AuthEnt(log, mdp);
    }

    @Override
    public Arbitre AuthArb(String log, String mdp) {
        return arbitreFacade.AuthArbitre(log, mdp);
    }
    
    
    
    
    
}
