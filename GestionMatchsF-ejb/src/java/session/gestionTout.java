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
import entites.HistoriqueJoueur;
import entites.Joueur;
import entites.Matchs;
import facade.ArbitreFacadeLocal;
import facade.EntraineurFacadeLocal;
import facade.EquipesFacadeLocal;
import facade.HistoriqueEntraineurFacadeLocal;
import facade.HistoriqueJoueurFacadeLocal;
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
    private HistoriqueJoueurFacadeLocal historiqueJoueurFacade;

    @EJB
    private HistoriqueEntraineurFacadeLocal historiqueEntraineurFacade;

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

    @Override
    public Collection<Entraineur> TousLesEntraineurs() {
        return entraineurFacade.TousLesEnt();
    }

    @Override
    public List<HistoriqueEntraineur> AfficherHistoEnt(int idE) { // A la base tu recherches un Id entraineur dans la JSP
        return historiqueEntraineurFacade.HistoEntraineur(idE);
        //Retour à la servlet
        }
    
    @Override
    public List<Joueur> TousLesJoueurs() {
        return joueursFacade.AfficherTousLesJoueurs();
    }
     @Override
    public List<HistoriqueJoueur> AfficherHistoJou(int idJ) {
        return historiqueJoueurFacade.HistoJoueur(idJ);
    }
     @Override
    public List<Joueur> AfficherTousLesJoueursEq(int ide) {
        return joueursFacade.TousLesJouEq(ide);
    }
     @Override
    public List<Matchs> AffiicherMatchEquipe(int ide) {
        return matchFacade.AfficherMatchsEq(ide);
    }
    
    @Override
    public List<Matchs> matchDate(Date date) {
        return matchFacade.Matchdate(date);
    }

    @Override
    public List<Matchs> MatchsInt(Date date1, Date date2) {
        return matchFacade.MatchdateInt(date1, date2);
    }
    
}
