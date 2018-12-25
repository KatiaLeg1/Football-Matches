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
import entites.HistoriqueJoueur;
import entites.Joueur;
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
        System.out.println("Action : "+ act);
        if ((act==null) || (act.equals("retour")))
        {
            jspClient = "/Auth.jsp";
            request.setAttribute("message", "");
        }
         else if (act.equals("AffEqEnt")) 
        {
            Collection <Entraineur> listeent = gestionTout.TousLesEntraineurs();
            request.setAttribute("listeEnt", listeent);
            jspClient="/RechercherEntraineurEq.jsp";
        }
         else if (act.equals("HistoEnt"))
        {
            String ent = request.getParameter("ent") ;

            if (!(ent.trim().isEmpty()))
            {
                int l = Integer.valueOf(ent);
                Collection <HistoriqueEntraineur> listeHE = gestionTout.AfficherHistoEnt(l) ;
                request.setAttribute("listeHE", listeHE);
               jspClient = "/AfficherHistoriqueEnt.jsp";
            }
        }
            else if (act.equals("AffEqJou")) 
        {
            List<Joueur> lesJou = gestionTout.AfficherTousLesJoueurs();
            request.setAttribute("listeJou", lesJou);
            jspClient="/RechercherJoueurEq.jsp";
        }
        else if (act.equals("HistoJou"))
        {
            String jou = request.getParameter("jou") ;
             if (!(jou.trim().isEmpty()))
            {
                int j = Integer.valueOf(jou);
               List<HistoriqueJoueur>hj = gestionTout.AfficherHistoJou(j);
               request.setAttribute("listeHJ", hj);
               jspClient = "/AfficherHistoriqueJoueur.jsp";
            }
        }
        
         else if (act.equals("AfficherEqJou"))
        {
             Collection<Equipe> lesEquipes = gestionTout.AfficherToutesLesEquipes();
            request.setAttribute("lesEquipes", lesEquipes);
            jspClient="/RechercherEquipe.jsp";
         }
        else if (act.equals("AfficherJou"))
        {
            String eq = request.getParameter("eq") ;
             if (!(eq.trim().isEmpty()))
            {
                int j = Integer.valueOf(eq); 
                List<HistoriqueJoueur> AfficheLesJoueursEq = gestionTout.AfficherTousLesJoueursEq(j);
                request.setAttribute("lesJoueurs", AfficheLesJoueursEq);
                jspClient = "/AfficherJoueurPourUneEquipe.jsp";
            }
        }
        
         else if (act.equals("AfficherClassementEq"))
        {
                Collection<Equipe> AfficherClassement= gestionTout.classement();
                request.setAttribute("AfficherClassement", AfficherClassement);
                jspClient = "/AfficherClassement.jsp";
            
        }
         else if (act.equals("AfficherMatchsEq"))
        {
             Collection<Equipe> lesEquipes = gestionTout.AfficherToutesLesEquipes();
            request.setAttribute("lesEquipes", lesEquipes);
            jspClient="/RechercherEquipeMatch.jsp";
         }
        
         else if (act.equals("AfficherEqM"))
        {
            
            String eq = request.getParameter("eq") ;
             if (!(eq.trim().isEmpty()))
            {
                int ide = Integer.valueOf(eq); 
                List<Matchs> ListeMatchs= gestionTout.AffiicherMatchEquipe(ide);
                request.setAttribute("AfficherMatch", ListeMatchs);
                jspClient = "/AfficherMatchsEq.jsp";
            }
        }
             else if (act.equals("MatchsDate"))
         {
             
            String d = request.getParameter("date") ;
            String d1 = request.getParameter("date1") ;
            if (!(d.trim().isEmpty())&&!(d1.trim().isEmpty()))
            {
                 Date da = Date.valueOf(d);
                 Date da1 = Date.valueOf(d1);
                 List <Matchs> fa = gestionTout.MatchsInt(da, da1);
                  jspClient = "/AfficherMatchsInt.jsp";
               request.setAttribute("listeMa", fa);
            }
            else if(!(d.trim().isEmpty()))
            {
                Date da = Date.valueOf(d);
               List <Matchs> fa = gestionTout.matchDate(da);
               jspClient = "/AfficherMatchs.jsp";
               request.setAttribute("listeMaa", fa);
            }
            else{
            jspClient = "/MenuTous.jsp";
         }}
             else{
            request.setAttribute("message", "Bienvenue");                 
                 jspClient = "MenuTous";
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