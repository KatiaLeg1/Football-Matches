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
        String txt = "SELECT m FROM Match AS m WHERE m.butEquipeUn=:butEquipeUn and m.butEquipeDeux=:butEquipeDeux";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("butEquipeUn", butEquipeUn);
        req = req.setParameter("butEquipeDeux", butEquipeDeux);
        
        List<Match> res = req.getResultList();
        if (res.size() >= 1)
        {
              m = (Match) res.get(0);
              m.setButEquipeUn(butEquipeUn);
              m.setButEquipeDeux(butEquipeDeux);
              em.merge(m);
        }
    }


    
    }
