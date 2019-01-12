/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entites.Arbitre;
import entites.Entraineur;
import entites.Equipe;
import entites.Faute;
import entites.HistoriqueEntraineur;
import entites.Joueur;
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
import java.util.List;
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
    public boolean CreerMAtch(Date dateMatch, String heure, String nomequipeUn, String nomequipeDeux, int ida) {
       boolean d;
        Equipe equipeUn = equipesFacade.RechercherEquipe(nomequipeUn);
        Equipe equipeDeux = equipesFacade.RechercherEquipe(nomequipeDeux);
        Arbitre arbitre = arbitreFacade.rechercherArbitreId(ida);
 
        boolean a = matchFacade.ArbitreLibre(arbitre, dateMatch);
        boolean b = matchFacade.EquipeLibre(equipeUn, dateMatch);
        boolean c = matchFacade.EquipeLibre(equipeDeux, dateMatch);
        if (a==true && b==true && c==true)
        {
            matchFacade.CreerMatch(dateMatch, heure, equipeUn, equipeDeux, arbitre);
            return d = true;
        }
        else
            return d = false;

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
    public void ModifierMatch(int idm, Date dateM1, String heure) {
        
        
        Matchs m = matchFacade.rechercherMatchID(idm);
        matchFacade.ModifierMatch(m, dateM1, heure);
    }

    @Override
    public void AffecterHisoEntr(Date datehisto, int id, String nomEq) {
        Entraineur e = entraineurFacade.RechercherEntraineurId(id);
        Equipe eq = equipesFacade.RechercherEquipe(nomEq);
        HistoriqueEntraineur he = historiqueEntraineurFacade.HistoActuel(e);
        if (he != null)
        {
            historiqueEntraineurFacade.ModifHistoEnt(he, datehisto);
            historiqueEntraineurFacade.CreerHE(datehisto, eq, e);
        }
        else
        {
            historiqueEntraineurFacade.CreerHE(datehisto, eq, e);
        }    
    }

    @Override
    public Collection<Entraineur> TousLesEntraineurs() {
        return entraineurFacade.TousLesEnt();
    }

    @Override
    public List<Faute> AfficherFauteDate(Date date) {
        return fautesFacade.AfficherFauteDate(date);
    }

    @Override
    public List<Faute> AfficherFauteJoueur(int id) {
        return fautesFacade.afficherFauteJoueur(id);
        }

    @Override
    public List<Joueur> TousLesJoueurs() {
        return joueursFacade.AfficherTousLesJoueurs();
    }

    @Override
    public List<Faute> AfficherFauteArbitre(int arbitreid) {
        Arbitre a = arbitreFacade.rechercherArbitreId(arbitreid);
        return fautesFacade.AfficherFauteArbitre(a);
    }

    @Override
    public void Sanctionner(int id, Date datei) {
        joueursFacade.SanctionJ(id, datei);
    }

    @Override
    public List<Matchs> TousLesMAtchs() {
        return matchFacade.RechercherTousLesMatchs();
    }

    
    
    
    
}
