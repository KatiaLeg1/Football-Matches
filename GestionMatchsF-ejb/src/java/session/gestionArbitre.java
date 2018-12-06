/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entites.Arbitre;
import entites.Equipe;
import entites.Joueur;
import entites.Match;
import entites.carton;
import facade.EquipesFacadeLocal;
import facade.FautesFacadeLocal;
import facade.JoueursFacadeLocal;
import facade.MatchFacadeLocal;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author katia
 */
@Stateless
public class gestionArbitre implements gestionArbitreLocal {

    @EJB
    private EquipesFacadeLocal equipesFacade;

    @EJB
    private MatchFacadeLocal matchFacade;

    @EJB
    private JoueursFacadeLocal joueursFacade;

    @EJB
    private FautesFacadeLocal fautesFacade;
    

    

    @Override
    public void CreerFauteJoueur(carton type, String nomPersonne, String prenomPersonne, String nomEq1, String nomEq2, Date date) {
    Joueur j = joueursFacade.RechercherJoueur(nomPersonne, prenomPersonne);
    Equipe e1 = equipesFacade.RechercherEquipe(nomEq1);
    Equipe e2 = equipesFacade.RechercherEquipe(nomEq2);
    Match m = matchFacade.RechercherMatch(e1,e2,date);
    fautesFacade.CreerFaute(type, j, m);
    
    
   
    }

    @Override
    public boolean ModifierMatch(Date date, int butEqUn, int butEqDeux, String nomEq1, String nomEq2) {
    boolean b = false;
    Arbitre a = null;
    
    if (a!=null)
    {
        Equipe e1 = equipesFacade.RechercherEquipe(nomEq1);
        Equipe e2 = equipesFacade.RechercherEquipe(nomEq2);
        Match m = matchFacade.RechercherMatch(e1, e2, date);
        if (m!=null && m.getArbitre().equals(a))
        {
         matchFacade.ModifierPoint(butEqDeux, butEqDeux, butEqUn);
         b=true;
        }
    }
    else System.out.println("Arbitre inexistant");
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
    public Collection<Match> LesMatchs() {
        return joueursFacade.recupJoueur();
    }
}
