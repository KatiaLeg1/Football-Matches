/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entites.Entraineur;
import entites.Equipe;
import java.util.ArrayList;
import java.util.Collection;
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
public class EntraineurFacade extends AbstractFacade<Entraineur> implements EntraineurFacadeLocal {

    @PersistenceContext(unitName = "GestionMatchsF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntraineurFacade() {
        super(Entraineur.class);
    }

    @Override
    public void CreerEntraineur(String nomE, String prenomE, String login, String mdp) {
        Entraineur e = new Entraineur();
        List entraineurEqListe = new ArrayList<Equipe>();
        e.setNomPersonne(nomE);
        e.setPrenomPersonne(prenomE);
        e.setLogin(login);
        e.setMdp(mdp);
        e.setHistoriqueEntraineurs(entraineurEqListe);
        em.persist(e);
    }

    @Override
    public Entraineur RechercherEntraineur(String nomPersonne, String prenomPersonne) {
        Entraineur e;
        String tx= "SELECT j from Entraineur as j where j.nomPersonne=:nom and j.prenomPersonne=:prenom";
        Query req = getEntityManager().createQuery(tx);
        req.setParameter("nom", nomPersonne);
        req.setParameter("prenom", prenomPersonne);       
        e=(Entraineur)req.getSingleResult();
        if (!(e==null)) {
                return e;
        } else {
            return null ;
        }
    }

    @Override
        public Collection<Entraineur> TousLesEnt() {
        List<Entraineur> e;
        String text ="SELECT e FROM Entraineur AS e";
        Query req = getEntityManager().createQuery(text);
        e = req.getResultList();
        return e;
    }
    @Override
    public Entraineur RechercherEntraineurId(int idE) {
        Entraineur e;
        String tx= "SELECT e from Entraineur as e where e.id=:idE ";
        Query req = getEntityManager().createQuery(tx);
        req.setParameter("idE", idE);
        e=(Entraineur)req.getSingleResult();
        if (!(e==null)) {
                return e;
        } else {
            return null ;
        }
    }

    @Override
    public Entraineur AuthEnt(String log, String mdp) {
        Query requete = em.createQuery("SELECT e from Entraineur as e where e.login=:log and e.mdp=:mdp");
        requete.setParameter("log", log);
        requete.setParameter("mdp", mdp);       
        List<Entraineur> liste =  requete.getResultList();
        if (!liste.isEmpty())
            return liste.get(0);
        else return null;    }
    
}
