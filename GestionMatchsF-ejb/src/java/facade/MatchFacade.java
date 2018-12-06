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
import entites.Matchs;
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
public class MatchFacade extends AbstractFacade<Matchs> implements MatchFacadeLocal {

    @PersistenceContext(unitName = "GestionMatchsF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MatchFacade() {
        super(Matchs.class);
    }

    @Override
    public void CreerMatch(Date date, String heure, Equipe equipeUn, Equipe equipeDeux, Arbitre aribtre) {
        Matchs m = new Matchs();
        int butUn = 0;
        int butDeux = 0;
        
        m.setButEquipeUn(butUn);
        m.setButEquipeDeux(butDeux);
        m.setDateMatch(date);
        m.setHeure(heure);
        m.setEquipeUn(equipeUn);
        m.setEquipeDeux(equipeDeux);
        m.setArbitre(aribtre);
     
        em.persist(m);

    }

    @Override
    public void ModifierPoint(int butEquipeUn, int butEquipeDeux, long idMatch) {
         
        Matchs m  = null;
        String txt = "SELECT m FROM Matchs AS m WHERE m.idMatch=:idMatch";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("idMatch", idMatch);
        m =(Matchs)req.getSingleResult();
        m.setButEquipeUn(butEquipeUn);
        m.setButEquipeDeux(butEquipeDeux);
        em.merge(m);
    }

    @Override
    public List<Matchs> MatchsArbitre(Arbitre arbitre) {
        Query requete = em.createQuery("SELECT m from Matchs as m where m.arbitre=:arb");
        requete.setParameter("arb", arbitre);     
        List<Matchs> liste =  requete.getResultList();
        return liste;    
    }

    @Override
    public boolean ArbitreLibre(Arbitre arbitre, Date dateMatch) {
        boolean b=false;
        Query requete = em.createQuery("SELECT m from Matchs as m where m.arbitre=:arb And m.dateMatch=:dateMatch");
        requete.setParameter("arb", arbitre);     
        requete.setParameter("dateMatch", dateMatch);  
        List<Matchs> liste =  requete.getResultList();
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
        Query requete = em.createQuery("SELECT m from Matchs as m where m.equipeUn=:equipe And m.dateMatch=:dateMatch");
                //+ "UNION SELECT m from Matchs as m where m.EquipeDeux=:equipe And m.dateMatch=:dateMatch");
        requete.setParameter("equipe", equipe);     
        requete.setParameter("dateMatch", dateMatch);  
        List<Matchs> liste =  requete.getResultList();
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
    public void ModifierMatch(Matchs m, Date date, String heure) {
        m.setDateMatch(date);
        m.setHeure(heure);
        em.merge(m);
    }

    @Override
    public Matchs RechercherMatch(Equipe nomEq1, Equipe nomEq2, Date date) {
        Matchs m =null;
        Query req = em.createQuery("select m from Matchs as m where m.equipeUn=:nomEq1 and m.EquipeDeux=:nomEq2 and m.dateMatch=:date");
        req.setParameter("nomEq1", nomEq1);     
        req.setParameter("nomEq2", nomEq2);     
        req.setParameter("date", date);   
        m=(Matchs)req.getSingleResult();
        return m;
    }
    @Override
     public Matchs MatchEquipedate(Long ident, Date dateMatch) {
        Matchs m=null;
        Query requete = em.createQuery("SELECT m from Matchs as m where (m.equipeUn.id=:equipe OR m.EquipeDeux.id=:equipe) And m.dateMatch=:dateMatch");
        requete.setParameter("equipe", ident);     
        requete.setParameter("dateMatch", dateMatch);  
        List<Matchs> liste =  requete.getResultList();
        if (!liste.isEmpty())
        {
           m=liste.get(0);
        }
        return m;    
    }
     @Override
    public List<Matchs> RechercherTousLesMatchs() {
         List<Matchs> m;
        String text ="SELECT m FROM Matchs AS m";
        Query req = getEntityManager().createQuery(text);
        m = req.getResultList();
        return m;
    }

    @Override
    public Matchs rechercherMatchID(int id) {
        // pout toi sophie
        Matchs m ;
        Query req = em.createQuery("select m from Matchs as m where m.id=:id");
        req.setParameter("id", id);     
        m=(Matchs)req.getSingleResult();
        return m;

    }

    
    }

