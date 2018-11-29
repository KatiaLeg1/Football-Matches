/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import facade.ArbitreFacadeLocal;
import facade.EntraineurFacadeLocal;
import facade.EquipesFacadeLocal;
import facade.FautesFacadeLocal;
import facade.HistoriqueEntraineurFacadeLocal;
import facade.MatchFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author katia
 */
@Stateless
public class gestionFederation implements gestionFederationLocal {

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

    

    
}
