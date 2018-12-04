/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entites.Joueur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.gestionEntraineurLocal;

/**
 *
 * @author Utilisateur
 */
@WebServlet(name = "gestionEntraineur", urlPatterns = {"/gestionEntraineur"})
public class gestionEntraineur extends HttpServlet {

    @EJB
    private gestionEntraineurLocal gestionEntraineur;
    
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sess = request.getSession(true);   
        response.setContentType("text/html;charset=UTF-8");
        String jspClient = null;
        String act = request.getParameter("action");
        if((act==null) || (act.equals("vide"))){
            jspClient = "/MenuEntraineur.jsp";
            request.setAttribute("message", "pas d'informations");
        }
             else if(act.equals("rechercherJ"))
                    {  
                       List<Joueur> liste = gestionEntraineur.affichageJoueurs();
                       request.setAttribute("listejoueurs", liste);
                       jspClient="/AffecterJoueur.jsp";
   
                    }
            else if(act.equals("affecterJ"))
                    {                     
                        jspClient="/MenuEntraineur.jsp";
                        doActionAffecterJ(request, response);   
                    }
                    
            RequestDispatcher Rd;
            Rd = getServletContext().getRequestDispatcher(jspClient);
            Rd.forward(request, response); 

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet gestionEntraineur</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet gestionEntraineur at " + request.getContextPath() + "</h1>");
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
    
    protected void doActionAffecterJ(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nome");
        String date = request.getParameter("date");
        String message;
        if( nom.trim().isEmpty() || date.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires."
                    
            + "<br /><a href=\"CreerFournisseur.jsp\"> Cliquez ici </a> pour accéder au formulaire de création d'un fournisseur";            
        } else { // convertir ty dans l'ENUM   
            
        /*gestionEntraineur.affectationJoueur(nom, nom, en, nom, dateDebutHJ);
        message = "<h2>Fournisseur créé avec succès !<h2>"; 
                    }
        request.setAttribute("message", message); */
        
    }
    }
    
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
   
