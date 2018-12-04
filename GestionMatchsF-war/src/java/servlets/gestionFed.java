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
        System.out.println("nom equipe"+nomEquipe);
        
        String message = "";
        if (nomEquipe.trim().isEmpty())
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour créer une Equipe"+
                    "</br> <a href=\"CreerEquipe.jsp\">cliquez ici </a>pour retourner au formulaire";
        }
        else {
            System.out.println("nom equipe"+nomEquipe);
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
        
        System.out.println("nom entraineur"+ nomE +prenomE+ loginE + mdpE);

        
        String message = "";
        if (nomE.trim().isEmpty()||prenomE.trim().isEmpty()||loginE.trim().isEmpty()||mdpE.trim().isEmpty())
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour creer un Entraineur";
        }
        else {
                    System.out.println("nom 2"+ nomE +prenomE+ loginE + mdpE);

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
    protected void CreerMa(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String h = request.getParameter("heure");
        String E1 = request.getParameter("nomEquUn");
        String idA = request.getParameter("idA");
        String E2 = request.getParameter("nomEquDeux");
        String t = request.getParameter("dateMatch");
        String message = "";
        if (E1.trim().isEmpty() || E2.isEmpty() || t.isEmpty() || idA.isEmpty())
        {
            message = "Erreur, vous n'avez pas rempli tous les champs" + "<br><a href=\"CreerA.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un arbitre";
        }
        else {
            int id = Integer.valueOf(idA);
            Date date = Date.valueOf(t); 
            gestionFederation.CreerMAtch(date, h, E1, E2, id);            
            message = "Match créé avec succès !";          
        }
        request.setAttribute("message", message);   
    }
    protected void ModifierMa(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String E1 = request.getParameter("nomEquUn");
        String E2 = request.getParameter("nomEquDeux");
        String h = request.getParameter("heure");
        String t = request.getParameter("dateMatch");
        String t1 = request.getParameter("dateM1");
        String message = "";
        if (E1.trim().isEmpty() || E2.isEmpty() || t.isEmpty() )
        {
            message = "Erreur, vous n'avez pas rempli tous les champs" + "<br><a href=\"CreerA.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un arbitre";
        }
        else {
            Date date = Date.valueOf(t); 
            Date date1 = Date.valueOf(t1);
            gestionFederation.ModifierMatch(E1, E2, date, date1, h);
            message = "Match modifié avec succès !";          
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
        System.out.println("nom equipe"+ act);
        if(act==null)
        {
            jspClient = "/MenuFederation.jsp";
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
        else if (act.equals("CreerArbitre") ) /* auth de fédé*/
        {
            jspClient = "/MenuFederation.jsp";
            creerA(request,response);
        }
        else if (act.equals("CreerM"))
        {
            Collection <Equipe> listee = gestionFederation.LesEquipes();
            Collection <Equipe> listees = gestionFederation.LesEquipes();
            Collection <Arbitre> listea = gestionFederation.LesArbitres();
            request.setAttribute("listeEquipes", listee);
            request.setAttribute("listeEquipess", listees);

            request.setAttribute("listeArbitres", listea);
            jspClient="/CreerMatch.jsp";
        }
        else if (act.equals("CreerMa"))
        {
            jspClient = "/MenuFederation.jsp";
            CreerMa(request,response);
        }
        else if (act.equals("ModifierM"))
        {
            Collection <Equipe> listee = gestionFederation.LesEquipes();
            Collection <Equipe> listees = gestionFederation.LesEquipes();
            request.setAttribute("listeEquipes", listee);
            request.setAttribute("listeEquipess", listees);
            jspClient="/ModifierMatch.jsp";
        }
        else if (act.equals("ModifierMa"))
        {
            jspClient = "/MenuFederation.jsp";
            ModifierMa(request,response);
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
