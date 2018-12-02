/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entites.Entraineur;
import entites.Equipe;
import entites.Joueur;
import entites.Match;
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
public class EquipesFacade extends AbstractFacade<Equipe> implements EquipesFacadeLocal {

    @PersistenceContext(unitName = "GestionMatchs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipesFacade() {
        super(Equipe.class);
    }

    @Override
    public void CreerEquipe(String nomEquipe) {
        Equipe eq = new Equipe();
        int point = 0 ;
        List JoueurHListe = new ArrayList<Joueur>();
        List EntraineurHListe = new ArrayList<Entraineur>();
        eq.setNomequipe(nomEquipe);
        eq.setPointEquipe(point);
        eq.setHistoriqueEntraineurs(EntraineurHListe);
        eq.setHistoriqueJoueurs(EntraineurHListe);
        em.persist(eq);
    }

    @Override
    public Collection<Equipe> ToutesLesEquipes() {
        List<Equipe> e;
        String text ="SELECT e FROM Fournisseur AS e";
        Query req = getEntityManager().createQuery(text);
        e = req.getResultList();
        return e;
    }

    @Override
    public Equipe RechercherEquipe(String nomequipe) {
        Equipe eq;
        String tx= "SELECT eq from Equipe as eq where e.nomequipe=:nomE";
        Query req = getEntityManager().createQuery(tx);
        req.setParameter("nomE", nomequipe);       
        eq=(Equipe)req.getSingleResult();
        if (!(eq==null)) {
                return eq;
        } else {
            return null ;
        }    }
    
            
}
