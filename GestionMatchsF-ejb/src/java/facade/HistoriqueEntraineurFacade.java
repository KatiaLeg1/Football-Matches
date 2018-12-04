/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entites.Entraineur;
import entites.Equipe;
import entites.HistoriqueEntraineur;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author katia
 */
@Stateless
public class HistoriqueEntraineurFacade extends AbstractFacade<HistoriqueEntraineur> implements HistoriqueEntraineurFacadeLocal {

    @PersistenceContext(unitName = "GestionMatchsF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoriqueEntraineurFacade() {
        super(HistoriqueEntraineur.class);
    }

    @Override
    public void CreerHE(Date dateDebutHE, Equipe equipe, Entraineur entraineur) {
       HistoriqueEntraineur he = new  HistoriqueEntraineur();
       Date dateFinHE = null;
       he.setDateDebutEnt(dateDebutHE);
       he.setDateFinEnt(dateFinHE);
       he.setEntraineur(entraineur);
       he.setEquipeEntraineur(equipe);
       em.persist(he);
    }
    
}
