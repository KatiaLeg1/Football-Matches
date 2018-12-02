/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entites.Arbitre;
import entites.Equipe;
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
import session.gestionFederationLocal;

/**
 *
 * @author katia
 */
@WebServlet(name = "gestionFed", urlPatterns = {"/gestionFed"})
public class gestionFed extends HttpServlet {

    @EJB
    private gestionFederationLocal gestionFederation;

    protected void creerEq(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String nomEquipe = request.getParameter("nomEquipe");
        
        String message = "";
        if (nomEquipe.trim().isEmpty())
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour créer une Equipe"+
                    "</br> <a href=\"CreerEquipe.jsp\">cliquez ici </a>pour retourner au formulaire";
        }
        else {
            gestionFederation.CreerEquipe(nomEquipe);
            message = "Equipe créée";          
        }
        request.setAttribute("message", message);
        
    }

    protected void creerEnt(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String nomE= request.getParameter("nomEntraineur");
        String prenomE = request.getParameter("prenomEntraineur");
        String loginE = request.getParameter("loginEntraineur");
        String mdpE = request.getParameter("mdpEntraineur");
        
        String message = "";
        if (nomE.trim().isEmpty()||prenomE.trim().isEmpty()||loginE.trim().isEmpty()||mdpE.trim().isEmpty())
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour creer un Entraineur";
        }
        else {
            gestionFederation.CreerEntraineur(nomE, prenomE, loginE, mdpE);
            message = "Entraineur créé";          
        }
        request.setAttribute("message", message);
        
    }
    
    protected void creerA(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String nomA= request.getParameter("nomArbitre");
        String prenomA = request.getParameter("prenomArbitre");
        String loginA = request.getParameter("loginArbitre");
        String mdpA = request.getParameter("mdpArbitre");
        
        String message = "";
        if (nomA.trim().isEmpty()||prenomA.trim().isEmpty()||loginA.trim().isEmpty()||mdpA.trim().isEmpty())
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour creer un Entraineur";
        }
        else {
            gestionFederation.CreerArbitre(nomA, prenomA, loginA, mdpA);
            message = "Arbitre créé";          
        }
        request.setAttribute("message", message);
        
    }
    protected void creerJ(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String nomJ= request.getParameter("nomJoueur");
        String prenomJ = request.getParameter("prenomJoueur");
        
        
        String message = "";
        if (nomJ.trim().isEmpty()||prenomJ.trim().isEmpty())
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour creer un Entraineur";
        }
        else {
            gestionFederation.CreerJoueur(nomJ, prenomJ);
            message = "Joueur créé";          
        }
        request.setAttribute("message", message);
        
    }
    protected void creerM(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        //String h = request.getParameter(heure);
        String E1 = request.getParameter("nomE1");
        String idA = request.getParameter("idA");
        String E2 = request.getParameter("nomE2");
        String date = request.getParameter("date");
        Date d = Date.valueOf(date);
        Date today = (Date) new java.util.Date();
//        String heure = request.getParameter("heure");
       
        String message = "";
        if (E1.trim().isEmpty() || E2.isEmpty() || date.isEmpty() || idA.isEmpty())
        {
           
            message = "Erreur, vous n'avez pas rempli tous les champs" + "<br><a href=\"CreerA.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un arbitre";
        }
        else if (d.before(today)){
            message = "La date n'est pas supérieure à aujourd'hui";
        }
        else {
             long id = Long.valueOf(idA);
          
     
            //gestionFederation.CreerArbitre(date, h, E2, date, idA);
            message = "Match créé avec succès !";          
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
        //HttpSession sess = request.getSession(true);
        //String ident
        response.setContentType("text/html;charset=UTF-8");
        String message="";
        String jspClient = null;
               
        String act = request.getParameter("action");
        act =null;
        if(act==null)
        {
            jspClient = "/Federation/MenuFederation.jsp";
            request.setAttribute("message", "pas d'infos");
        }
        else if (act.equals("CreerEquipe") ) /* auth de fédé*/
        {
            creerEq(request,response);
            jspClient = "/MenuFederation.jsp";

        }
        else if (act.equals("CreerEntraineur") ) /* auth de fédé*/
        {
            jspClient = "/MenuFederation.jsp";
            creerEnt(request,response);
        }
        else if (act.equals("CreerJoueur") ) /* auth de fédé*/
        {
            jspClient = "/MenuFederation.jsp";
            creerJ(request,response);
        }
        else if (act.equals("CreerM"))
        {
            Collection <Equipe> listee = gestionFederation.LesEquipes();
            Collection <Arbitre> listea = gestionFederation.LesArbitres();
            request.setAttribute("listeEquipes", listee);
            request.setAttribute("listeArbitres", listea);
            jspClient="/CreerMatch.jsp";
        }
        
        RequestDispatcher Rd;
        Rd = getServletContext().getRequestDispatcher(jspClient);
        Rd.forward(request, response);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet gestionFed</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet gestionFed at " + request.getContextPath() + "</h1>");
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
