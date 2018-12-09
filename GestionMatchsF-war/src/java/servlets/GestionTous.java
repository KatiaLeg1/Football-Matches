/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;
import entites.Arbitre;
import entites.Entraineur;
 import entites.Equipe;
import entites.HistoriqueEntraineur;
import entites.Matchs;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.sql.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.gestionToutLocal;
 /**
 *
 * @author domitille
 */
@WebServlet(name = "GestionTous", urlPatterns = {"/GestionTous"})
public class GestionTous extends HttpServlet {
     @EJB
    private gestionToutLocal gestionTout;    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void rechercheMatch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String ident = request.getParameter( "NomEquipe" );
         String jdat = request.getParameter("datematch");
         String message;
        
    if (ident.trim().isEmpty() || jdat.trim().isEmpty())
        {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. ";
                    
        } else {
     
            message = "recherche en cours !";
         Long id = Long.valueOf(ident);
        Date dm = Date.valueOf(jdat);
        Matchs m =gestionTout.AfficherJoueursMatch(id, dm);
        request.setAttribute( "match", m );
                }
        
        request.setAttribute( "message", message );
 }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String message="";
        String jspClient = null;
               
        String act = request.getParameter("action");
        System.out.println("nom equipe"+ act);
        if ((act==null) || (act.equals("retour")))
        {
            jspClient = "/MenuTous.jsp";
            request.setAttribute("message", "pas d'infos");
        }
        else if (act.equals("authFed")) {
            String log = request.getParameter("Login");
            String mdp = request.getParameter("mdp");
            if (mdp.equals("fede")&&(log.equals("fede"))) {
                request.setAttribute("message", "Bienvenu Fede");                
                jspClient = "/MenuFederation.jsp";
            } else {
                request.setAttribute("message", "mauvais ID ou MDP");
                jspClient = "/Auth.jsp";
            }}
       
        else if(act.equals("authArb"))
        {
            String log = request.getParameter("Login");
            String mdp = request.getParameter("mdp");
            Arbitre a = gestionTout.AuthArb(log, mdp);
            if (a==null)
            {
                jspClient = "/Auth.jsp";
                request.setAttribute("message", "Erreur ID ou MDP");
                
            }
            else
            {
                jspClient = "/MenuArbitre.jsp";
                request.setAttribute("message", "Bienvenu " + a.getNomPersonne() +" "+a.getPrenomPersonne());

            }
        }    
                
        else if (act.equals("Afficherdateequipe") ) /* auth de fédé*/
        {
          //  List<Matchs> lm = gestionTout.AfficherTousLesMatchs();
           Collection<Equipe> le = gestionTout.AfficherToutesLesEquipes();
         //   request.setAttribute("listematch", lm);
            request.setAttribute("listeequipe", le);
            jspClient = "/saisirEquipeDate.jsp";
        
        }else if (act.equals("rechercherdateequip") ) /* auth de fédé*/
        {
            rechercheMatch(request, response);
            jspClient="/AfficherFrais.jsp";
        }
        
         else if (act.equals("AffEqEnt")) // valeur action que tu récupères de la JSP Menu Tout
        {
            // Tu dois d'abord rechercher 1 entraineur précis, pour ça tu fais envoie la liste des entraineurs à la JSP
            // Comme ça tu auras un liste déroulante dans la JSP
            // Pour ça tu dois mettre la methode dans le bean session 
            Collection <Entraineur> listeent = gestionTout.TousLesEntraineurs();
            request.setAttribute("listeEnt", listeent);
            // tu rediriges vers la JSP ou tu recherches ton entraineur
            jspClient="/RechercherEntraineurEq.jsp";
        }
         else if (act.equals("HistoEnt"))
        {
            HttpSession sess = request.getSession(true);
            String ent = request.getParameter("ent") ;

            if (!(ent.trim().isEmpty()))
            {
                int l = Integer.valueOf(ent);
                // La tu as récupéré l'ID de ton entraineur, maintenant faut afficher l'historique, 
                //donc HistoriqueEntraineurFacade  + Session
               Collection <HistoriqueEntraineur> he = gestionTout.AfficherHistoEnt(l) ;
               // la tu as ta liste d'historique, donc tu vas l'enregistrer pour l'envoyer à la JSP par "sess"
               sess.setAttribute("listeHE", he);
               //Et tu rediriges vers la JSP afficher
               jspClient = "/AfficherHistoriqueEnt.jsp";
            }
        }
        RequestDispatcher Rd;
 Rd = getServletContext().getRequestDispatcher(jspClient);
Rd.forward(request, response);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GestionTous</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GestionTous at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
     /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
     /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
 }