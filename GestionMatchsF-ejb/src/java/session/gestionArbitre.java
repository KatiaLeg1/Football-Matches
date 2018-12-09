/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entites.Arbitre;
import entites.Equipe;
import entites.Joueur;
import entites.Matchs;
import entites.carton;
import facade.ArbitreFacadeLocal;
import facade.EquipesFacadeLocal;
import facade.FautesFacadeLocal;
import facade.JoueursFacadeLocal;
import facade.MatchFacadeLocal;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author katia
 */
@Stateless
public class gestionArbitre implements gestionArbitreLocal {

    @EJB
    private ArbitreFacadeLocal arbitreFacade;

    @EJB
    private EquipesFacadeLocal equipesFacade;

    @EJB
    private MatchFacadeLocal matchFacade;

    @EJB
    private JoueursFacadeLocal joueursFacade;

    @EJB
    private FautesFacadeLocal fautesFacade;
    

    

    @Override
    public void CreerFauteJoueur(carton type, long id, int idM) {
    Joueur j = joueursFacade.rechercherJoueurId(id);
     
    //Equipe e1 = equipesFacade.RechercherEquipe(nomEq1);
    //Equipe e2 = equipesFacade.RechercherEquipe(nomEq2);
    //Matchs m = matchFacade.RechercherMatch(e1,e2,date); --> celle la sert pour moi car elle est demandé précisemment
    // Tu te compliques, il faut créer un fonction "rechercherMatch id", dans ton JSP comme ça tu as 1 liste déroulante ou tu récupère ID,
    //et tu peux afficher par contre "Equipe 1 VS Equipe 2"
    // Pareil pour joueur, quand tu fais une liste déroulante il est plus facile d'afficher nom / Prénom pour séléctionner mais de récuperer que l'id
    //CreerFauteJoueur(carton type, String nomPersonne, String prenomPersonne, String nomEq1, String nomEq2, Date date)
    // a changé en (voir dessus)
    
    // je t'ai créé rechercherMatchID dans matchFacade --> à voir
    
    Matchs m= matchFacade.rechercherMatchID(idM) ;
    fautesFacade.CreerFaute(type, j, m);
    
    
   
    }

    @Override
    public boolean ModifierMatch(Date date, int butEqUn, int butEqDeux, String nomEq1, String nomEq2) {
    boolean b = false;
    Arbitre a = null;
    
    if (a!=null)
    {
        // Pareil Ici --> Match selon ID
        Equipe e1 = equipesFacade.RechercherEquipe(nomEq1);
        Equipe e2 = equipesFacade.RechercherEquipe(nomEq2);
        Matchs m = matchFacade.RechercherMatch(e1, e2, date);
        if (m!=null && m.getArbitre().equals(a))
        {
         matchFacade.ModifierPoint(butEqDeux, butEqDeux, butEqUn);
         b=true;
        }
    }
    else System.out.println("Arbitre inexistant");
    return b;
    }
    
     @Override
    public Collection<Equipe> LesEquipes() {
        return equipesFacade.ToutesLesEquipes();
    }

    @Override
    public Collection<Joueur> LesJoueurs() {
        return joueursFacade.recupJoueur();
    }
   
    @Override
    public Collection<Matchs> RechercherTousLesMatchs() {
        return matchFacade.RechercherTousLesMatchs();
    }

    @Override
    public Arbitre authArb(String log, String mdp) {
        return arbitreFacade.AuthArbitre(log, mdp);
    }
    
}
