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
import javax.servlet.http.HttpSession;
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
       
        String cart = request.getParameter("type");
        String j = request.getParameter("nomPersonne"); // 
        String m = request.getParameter("Match");
        
        String message ;
        if (cart.trim().isEmpty() || j.isEmpty() || m.isEmpty() )
        {    
        message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." ;
        }
        else {
            long jo = Long.valueOf(j);
            int ma = Integer.valueOf(m);
            if (cart.equals("Rouge"))
            {
                gestionArbitre.CreerFauteJoueur(carton.Rouge,jo , ma);
            }
            else
            {
                gestionArbitre.CreerFauteJoueur(carton.Jaune,jo , ma);
            }
            message= "Faute enregistrée avec succès !";
        }
        request.setAttribute("message", message);
    }
    protected void ModifPt(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String ma = request.getParameter("Match");
        String p1 = request.getParameter("pteq1"); 
        String p2 = request.getParameter("pteq2");
        String message ;
        if (ma.trim().isEmpty() || p1.trim().isEmpty() || p2.trim().isEmpty() )
        {    
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." ;
        }
        else {
            int pUn = Integer.valueOf(p1);
            int pD = Integer.valueOf(p2);
            int mat = Integer.valueOf(ma);
            gestionArbitre.ModifierMatch(pUn, pD, mat);
            
            message= "sCORE enregistré avec succès !";
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
        HttpSession sess = request.getSession(true);   
               
        String act = request.getParameter("action");
        System.out.println("action : "+ act);
        if(act==null)
        {
            jspClient = "/MenuArbitre.jsp";
            request.setAttribute("message", "pas d'infos");
        }
        else if(act.equals("authArb"))
        {
            String log = request.getParameter("Login");
            String mdp = request.getParameter("mdp");
            Arbitre a = gestionArbitre.authArb(log, mdp);
            if (a==null)
            {
                jspClient = "/Auth.jsp";
                request.setAttribute("message", "Erreur ID ou MDP");
            }
            else
            {
                jspClient = "/MenuArbitre.jsp";
                request.setAttribute("message", "Bienvenu " + a.getNomPersonne() +" "+a.getPrenomPersonne());
                sess.setAttribute("a", a);

            }
        }    
        else if (act.equals("CreerF")) // ça c'est la valeur que tu as récuperer de ta JSP dire que tu dois faire qqchose et après tu redirige via JSP client
        {
            String ma = request.getParameter("Match");
            if (!(ma.trim().isEmpty()))
            {
                int mat= Integer.valueOf(ma);
                Matchs match = gestionArbitre.matchID(mat);
                Collection <Joueur> listej = gestionArbitre.joueurMa(match);
                request.setAttribute("listeJoueurs", listej);
                jspClient="/CreerFauteJoueur.jsp";
            }   
        }
        else if(act.equals("CF"))
        {
            Arbitre a= (Arbitre)sess.getAttribute("a"); // recupère l'arbitre de sess
            Collection <Matchs> listem = gestionArbitre.TousLesMaArb(a);
            request.setAttribute("listeMatchs", listem);
            jspClient="/CreerFRecherche.jsp";
        }
        else if (act.equals("CreerFauteJoueur"))
        {
            jspClient = "/MenuArbitre.jsp";
            creerFaute(request,response);
        }
        else if (act.equals("ModifM"))
        {
            Arbitre a= (Arbitre)sess.getAttribute("a"); 
            Collection <Matchs> listem = gestionArbitre.TousLesMaArb(a);
            request.setAttribute("listeMatchs", listem);
            jspClient="/ModifierMatch.jsp";
        }
        else if (act.equals("ModifierMa"))
        {
            jspClient="/MenuArbitre.jsp";
            ModifPt(request,response);
        }
        else{
            jspClient = "/MenuArbitre.jsp";}
        
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
