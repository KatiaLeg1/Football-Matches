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
            
}
