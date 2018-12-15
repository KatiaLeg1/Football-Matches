/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entites.Entraineur;
import entites.Joueur;
import java.io.IOException;
import java.io.PrintWriter;
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
import session.gestionEntraineurLocal;

/**
 *
 * @author Utilisateur
 */
@WebServlet(name = "gestionEntraineur", urlPatterns = {"/gestionEntraineur"})
public class gestionEntraineur extends HttpServlet {

    @EJB
    private gestionEntraineurLocal sessionEnt;


    

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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sess = request.getSession(true);   

        String jspClient = null;
        String act = request.getParameter("action");
        if((act==null) || (act.equals("vide"))){
            jspClient = "/MenuEntraineur.jsp";
            request.setAttribute("message", "pas d'informations");
        }
         else if(act.equals("authEnt"))
        {
            String log = request.getParameter("Login");
            String mdp = request.getParameter("mdp");
            if(!(log.trim().isEmpty())||!(mdp.trim().isEmpty()))
            {
                Entraineur ent = sessionEnt.AuthEnt(log, mdp);
                if (ent ==null)
                {
                    jspClient = "/Auth.jsp";
                    request.setAttribute("message", "Erreur ID ou MDP");
                }
                else
                {
                    jspClient = "/MenuEntraineur.jsp";
                    request.setAttribute("message", "Bienvenu " + ent.getNomPersonne() +" "+ ent.getPrenomPersonne());
                    sess.setAttribute("ent", ent);
                }
        }}
        else if(act.equals("rechercherJ")&& !(sess== null))
        {  
            Entraineur entr = (Entraineur)sess.getAttribute("ent");
            System.out.println("sess"+sess.getId());
            System.out.println("ent" + entr.getNomPersonne());
            List<Joueur> liste = sessionEnt.affichageJoueurs();
            request.setAttribute("entr", entr);                       
            request.setAttribute("listejoueurs", liste);
            jspClient="/AffecterJoueur.jsp";
        }
        else if(act.equals("affecterJ"))
        {                     
            String idj = request.getParameter("Joueurs");
            String t = request.getParameter("dateDebutHJ");                    
            String message ;
            if(idj.isEmpty() || t.isEmpty() ){
                message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires.";
            } 
            else {
                Entraineur entr = (Entraineur)sess.getAttribute("ent");
                Date dateDHJ = Date.valueOf(t);
                long id = Long.valueOf(idj);
                sessionEnt.affectationJoueur(id, entr, dateDHJ);
                message = "Joueur affecté à l'équipe !"; 
            } 
            request.setAttribute("message", message);
            jspClient="/MenuEntraineur.jsp";
        }    
        else if(act.equals("afficherJ"))
        {
            jspClient="/AfficherJoueurs.jsp";
            List <Joueur> list = sessionEnt.affichageJoueurs();
            request.setAttribute("listejoueurs", list);
            request.setAttribute("message", "Liste des joueurs existants");
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
   
