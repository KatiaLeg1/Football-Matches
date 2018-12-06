/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;
 import entites.Equipe;
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