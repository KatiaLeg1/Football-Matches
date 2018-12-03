/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entites.Arbitre;
import entites.Equipe;
import entites.Faute;
import entites.Joueur;
import entites.Match;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author katia
 */
@Stateless
public class MatchFacade extends AbstractFacade<Match> implements MatchFacadeLocal {

    @PersistenceContext(unitName = "GestionMatchs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MatchFacade() {
        super(Match.class);
    }

    @Override
    public void CreerMatch(Date date, String heure, Equipe equipeUn, Equipe equipeDeux, Arbitre aribtre) {
        Match m = new Match();
        int butUn = 0;
        int butDeux = 0;
        List Composition1 = new ArrayList<Joueur>();
        List Composition2 = new ArrayList<Joueur>();
        List fautes = new ArrayList<Faute>();

        m.setButEquipeUn(butUn);
        m.setButEquipeDeux(butDeux);
        m.setDateMatch(date);
        m.setHeure(heure);
        m.setEquipeUn(equipeUn);
        m.setEquipeDeux(equipeDeux);
        m.setArbitre(aribtre);
        m.setComposition1(Composition1);
        m.setComposition2(Composition2);
        m.setFautes(fautes);
        em.persist(m);

    }

    @Override
    public void ModifierPoint(int butEquipeUn, int butEquipeDeux, long idMatch) {
         
        Match m  = null;
        String txt = "SELECT m FROM Match AS m WHERE m.idMatch=:idMatch";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("idMatch", idMatch);
        m =(Match)req.getSingleResult();
        m.setButEquipeUn(butEquipeUn);
        m.setButEquipeDeux(butEquipeDeux);
        em.merge(m);
    }

    @Override
    public List<Match> MatchsArbitre(Arbitre arbitre) {
        Query requete = em.createQuery("SELECT m from Match as m where m.arbitre=:arb");
        requete.setParameter("arb", arbitre);     
        List<Match> liste =  requete.getResultList();
        return liste;    
    }

    @Override
    public boolean ArbitreLibre(Arbitre arbitre, Date dateMatch) {
        boolean b=false;
        Query requete = em.createQuery("SELECT m from Match as m where m.arbitre=:arb And m.dateMatch=:dateMatch");
        requete.setParameter("arb", arbitre);     
        requete.setParameter("dateMatch", dateMatch);  
        List<Match> liste =  requete.getResultList();
        if (liste.isEmpty())
        {
            b = true;
        }
        else
        {
            b=false;                   
        }
        return b;
    }

    @Override
    public boolean EquipeLibre(Equipe equipe, Date dateMatch) {
        boolean b=false;
        Query requete = em.createQuery("SELECT m from Match as m where m.equipe=:equipe And m.dateMatch=:dateMatch");
        requete.setParameter("equipe", equipe);     
        requete.setParameter("dateMatch", dateMatch);  
        List<Match> liste =  requete.getResultList();
        if (liste.isEmpty())
        {
            b = true;
        }
        else
        {
            b=false;                   
        }
        return b;    
    }

    @Override
    public void ModifierMatch(Match m, Date date, String heure) {
        m.setDateMatch(date);
        m.setHeure(heure);
        em.merge(m);
    }

    @Override
    public Match RechercherMatch(Equipe nomEq1, Equipe nomEq2, Date date) {
        Match m =null;
        Query req = getEntityManager().createQuery("select m from Match as m where m.equipeUn=:nomEq1 and m.EquipeDeux=:nomEq2 and m.dateMatch=:date");
        req.setParameter("nomEq1", nomEq1);     
        req.setParameter("nomEq2", nomEq2);     
        req.setParameter("date", date);     
        return m;
    }

    
    
    }
