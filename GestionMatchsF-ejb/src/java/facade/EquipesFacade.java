/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entites.Equipe;
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
        eq.setNomequipe(nomEquipe);
        eq.setPointEquipe(point);
        em.persist(eq);
    }
            
}
