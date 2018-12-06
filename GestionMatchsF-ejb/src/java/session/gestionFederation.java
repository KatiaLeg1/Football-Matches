/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entites.Arbitre;
import entites.Entraineur;
import entites.Equipe;
import entites.HistoriqueEntraineur;
import entites.Matchs;
import facade.ArbitreFacadeLocal;
import facade.EntraineurFacadeLocal;
import facade.EquipesFacadeLocal;
import facade.FautesFacadeLocal;
import facade.HistoriqueEntraineurFacadeLocal;
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
public class gestionFederation implements gestionFederationLocal {

    @EJB
    private JoueursFacadeLocal joueursFacade;

    @EJB
    private HistoriqueEntraineurFacadeLocal historiqueEntraineurFacade;

    @EJB
    private MatchFacadeLocal matchFacade;

    @EJB
    private FautesFacadeLocal fautesFacade;

    @EJB
    private EquipesFacadeLocal equipesFacade;

    @EJB
    private EntraineurFacadeLocal entraineurFacade;

    @EJB
    private ArbitreFacadeLocal arbitreFacade;

    
    @Override
    public void CreerEquipe(String nomE) {
        equipesFacade.CreerEquipe(nomE);
    }

    @Override
    public void CreerArbitre(String nom, String prenom, String login, String mdp) {
        arbitreFacade.CreerArbitre(nom, prenom, login, mdp);
    }

    @Override
    public void CreerEntraineur(String nom, String prenom, String login, String mdp) {
        entraineurFacade.CreerEntraineur(nom, prenom, login, mdp);
    }

    @Override
    public void CreerJoueur(String nom, String prenom) {
        joueursFacade.CreerJoueur(nom, prenom);
    }

    @Override
    public void CreerMAtch(Date dateMatch, String heure, String nomequipeUn, String nomequipeDeux, int ida) {
       
        Equipe equipeUn = equipesFacade.RechercherEquipe(nomequipeUn);
        Equipe equipeDeux = equipesFacade.RechercherEquipe(nomequipeDeux);
        Arbitre arbitre = arbitreFacade.rechercherArbitreId(ida);
        
        System.out.println("eq1" + equipeUn);
        System.out.println("eq2" + equipeDeux);
        System.out.println("arb" + arbitre);
        
        
        boolean a = matchFacade.ArbitreLibre(arbitre, dateMatch);
        boolean b = matchFacade.EquipeLibre(equipeUn, dateMatch);
        boolean c = matchFacade.EquipeLibre(equipeDeux, dateMatch);
        if (a==true || b==true|| c==true)
        {
            matchFacade.CreerMatch(dateMatch, heure, equipeUn, equipeDeux, arbitre);
        }
    }

    @Override
    public Collection<Equipe> LesEquipes() {
        return equipesFacade.ToutesLesEquipes();
    }

    @Override
    public Collection<Arbitre> LesArbitres() {
        return arbitreFacade.TouslesArbitres();
    }

    @Override
    public void ModifierMatch(String nomEq1, String nomEq2, Date dateMatch, Date dateM1, String heure) {
        Equipe equipeUn = equipesFacade.RechercherEquipe(nomEq1);
        Equipe equipeDeux = equipesFacade.RechercherEquipe(nomEq2);
        
        Matchs m = matchFacade.RechercherMatch(equipeUn, equipeDeux, dateMatch);
        matchFacade.ModifierMatch(m, dateM1, heure);
    }

    @Override
    public void AffecterHisoEntr(Date datehisto, int id, String nomEq) {
        Entraineur e = entraineurFacade.RechercherEntraineurId(id);
        
        HistoriqueEntraineur he = historiqueEntraineurFacade.HistoActuel(e);
        if (he != null)
        {
            historiqueEntraineurFacade.ModifHistoEnt(he, datehisto);
            Equipe eq = equipesFacade.RechercherEquipe(nomEq);
            historiqueEntraineurFacade.CreerHE(datehisto, eq, e);
        }
        else
        {
            Equipe eq = equipesFacade.RechercherEquipe(nomEq);
            historiqueEntraineurFacade.CreerHE(datehisto, eq, e);
        }    
    }

    @Override
    public Collection<Entraineur> TousLesEntraineurs() {
        return entraineurFacade.TousLesEnt();
    }
    
}
