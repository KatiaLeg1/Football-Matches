/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entites.Arbitre;
import entites.Equipe;
import entites.Joueur;
import entites.Matchs;
import entites.carton;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.gestionArbitreLocal;


/**
 *
 * @author Sophie
 */
@WebServlet(name = "gestionArb", urlPatterns = {"/gestionArb"})
public class gestionArb extends HttpServlet {

    @EJB
    private gestionArbitreLocal gestionArbitre;

    protected void creerFaute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        //String h = request.getParameter(heure);
        String E1 = request.getParameter("nomE1");
        String E2 = request.getParameter("nomE2");
        String cart = request.getParameter("carton");
        String pj = request.getParameter("prenomj");
        String nj = request.getParameter("nomj");
        String date = request.getParameter("date");
        Date d = Date.valueOf(date);
 
       
        String message = "";
        if (E1.trim().isEmpty() || E2.isEmpty() || cart.isEmpty() || pj.isEmpty() || nj.isEmpty() || date.isEmpty())
        {   
        message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerJoueur.jsp\">Clique ici </a>pour accéder au formulaire de creation d'un joueur.";
        }
        else {
            carton car = carton.valueOf(cart);
            gestionArbitre.CreerFauteJoueur(car, pj, nj, E1, E2, d);
            message= "Faute enregistrée avec succès !";
            
        }
        request.setAttribute("message", message);
    }
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
        String message="";
        String jspClient = null;
               
        String act = request.getParameter("action");
        System.out.println("nom arbitre"+ act);
        if(act==null)
        {
            jspClient = "/MenuArbitre.jsp";
            request.setAttribute("message", "pas d'infos");
        }
    //    else if (act.equals("ModifierMatch") ) /* auth de fédé*/
     //   {
     //       ModifierMatch(request,response);
       //     jspClient = "/MenuArbitre.jsp";

       // }
        else if (act.equals("CreerF"))
        {
            Collection <Equipe> listee = gestionArbitre.LesEquipes();
            Collection <Joueur> listej = gestionArbitre.LesJoueurs();
            Collection <Matchs> listem = gestionArbitre.RechercherTousLesMatchs();
            request.setAttribute("listeEquipes", listee);
            request.setAttribute("listeJoueurs", listej);
            request.setAttribute("listeMatchs", listem);
            jspClient="/CreerFauteJoueur.jsp";
        }
        
        RequestDispatcher Rd;
        Rd = getServletContext().getRequestDispatcher(jspClient);
        Rd.forward(request, response);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet gestionArbitre</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet gestionArbitre at " + request.getContextPath() + "</h1>");
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
