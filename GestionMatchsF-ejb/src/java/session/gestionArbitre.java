/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entites.Arbitre;
import entites.Equipe;
import entites.Joueur;
import entites.Matchs;
import entites.carton;
import facade.ArbitreFacadeLocal;
import facade.EquipesFacadeLocal;
import facade.FautesFacadeLocal;
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
public class gestionArbitre implements gestionArbitreLocal {

    @EJB
    private ArbitreFacadeLocal arbitreFacade;

    @EJB
    private EquipesFacadeLocal equipesFacade;

    @EJB
    private MatchFacadeLocal matchFacade;

    @EJB
    private JoueursFacadeLocal joueursFacade;

    @EJB
    private FautesFacadeLocal fautesFacade;
    

    

    @Override
    public void CreerFauteJoueur(carton type, long id, int idM) {
    Joueur j = joueursFacade.rechercherJoueurId(id);
    Matchs m= matchFacade.rechercherMatchID(idM) ;
    fautesFacade.CreerFaute(type, j, m); 
    }

    @Override
    public boolean ModifierMatch(int butEqUn, int butEqDeux, int idm) {
    boolean b = false;
        Matchs m = matchFacade.rechercherMatchID(idm);
        if (m!=null)
        {
            Equipe e1 = m.getEquipeUn();
            Equipe e2 = m.getEquipeDeux();   
            matchFacade.ModifierPoint(butEqUn, butEqDeux, m);
            b=true;
            equipesFacade.AjoutPt(e1, butEqUn);
            equipesFacade.AjoutPt(e2, butEqDeux);
        }
        return b;
    }
    
     @Override
    public Collection<Equipe> LesEquipes() {
        return equipesFacade.ToutesLesEquipes();
    }

    @Override
    public Collection<Joueur> LesJoueurs() {
        return joueursFacade.recupJoueur();
    }
   
    @Override
    public Collection<Matchs> RechercherTousLesMatchs() {
        return matchFacade.RechercherTousLesMatchs();
    }

    @Override
    public Arbitre authArb(String log, String mdp) {
        return arbitreFacade.AuthArbitre(log, mdp);
    }

    @Override
    public Collection<Matchs> TousLesMaArb(Arbitre a) {
        return matchFacade.Matcharb(a);
    }

    @Override
    public Matchs matchID(int idm) {
        return matchFacade.rechercherMatchID(idm);
    }

    @Override
    public List<Joueur> joueurMa(Matchs m) {
        return joueursFacade.joueurMatch(m);
    }
    
}
