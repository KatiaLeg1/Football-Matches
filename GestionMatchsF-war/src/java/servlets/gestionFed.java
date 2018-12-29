/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entites.Arbitre;
import entites.Entraineur;
import entites.Equipe;
import entites.Faute;
import entites.Joueur;
import entites.Matchs;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
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
        
        String message ;
        if (nomEquipe.trim().isEmpty())
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour créer une Equipe";        }
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
        
        
        String message ;
        if (nomE.trim().trim().isEmpty()||prenomE.trim().isEmpty()||loginE.trim().isEmpty()||mdpE.trim().isEmpty())
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
        
        String message ;
        if (nomA.trim().isEmpty()||prenomA.trim().isEmpty()||loginA.trim().isEmpty()||mdpA.trim().isEmpty())
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour creer un Arbitre";
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
        
        
        String message ;
        if (nomJ.trim().isEmpty()||prenomJ.trim().isEmpty())
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour creer un Joueur";
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
        String message ;
        if (h.trim().isEmpty()||E1.trim().isEmpty() || E2.trim().isEmpty() || t.trim().isEmpty() || idA.trim().isEmpty())
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour creer un match";
        }
        else {
            int id = Integer.valueOf(idA);
            Date date = Date.valueOf(t); 
            boolean d =gestionFederation.CreerMAtch(date, h, E1, E2, id);            
            if (d==true)
            {
            message = "Match créé avec succès !";          
            }
            else 
            {
             message = "Une équipe ou arbitre n'est pas libre ";          
            }
        }
        request.setAttribute("message", message);   
    }
    protected void ModifierMa(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String E1 = request.getParameter("idM");
        String h = request.getParameter("heure");
        String t1 = request.getParameter("dateM1");
        String message ;
        if (E1.trim().isEmpty() || h.trim().isEmpty() || t1.trim().isEmpty() )
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour modifier le match";
        }
        else {
            int idMa= Integer.valueOf(E1);
            Date date1 = Date.valueOf(t1);
            
            gestionFederation.ModifierMatch(idMa, date1, h);
            message = "Match modifié avec succès !";          
        }
        request.setAttribute("message", message);   
    }    
        protected void Affecter(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String eq = request.getParameter("equipe");
        String t = request.getParameter("dateDebut");
        String ide = request.getParameter("ent");
        String message;
        
        if (ide.trim().isEmpty() || eq.trim().isEmpty() || t.trim().isEmpty() )
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour affecter un entraineur";
        }
        else {
            int id = Integer.valueOf(ide);
            Date date = Date.valueOf(t); 
            gestionFederation.AffecterHisoEntr(date, id, eq);
            message = "entraineur affecté";
        }
        request.setAttribute("message", message);  
    }    

        protected void Sanctionner(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String j = request.getParameter("jou");
        String ti = request.getParameter("dateInt");
        String message;
        if (j.trim().isEmpty() || ti.trim().isEmpty() )
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour sanctionner un joueur" ;
        }
        else {
            int id = Integer.valueOf(j);

            Date date = Date.valueOf(ti);                    
            gestionFederation.Sanctionner(id, date);
            message = "Sanction créée avec succès !";          
        }
        request.setAttribute("message", message);   
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        response.setContentType("text/html;charset=UTF-8");
        String message;
        String jspClient = null;
               
        String act = request.getParameter("action");
        System.out.println("ACTION : "+ act);
        
        if(act==null|| act.equals("vide"))
        {
            jspClient = "/fede/MenuFederation.jsp";
            request.setAttribute("message", "");
        }
        else if (act.equals("authFed")) {
            String mdp = request.getParameter("mdp");
            if (mdp.equals("fede")) {
                request.setAttribute("message", "Bienvenue Fede");                
                jspClient = "/fede/MenuFederation.jsp";
            } else {
                request.setAttribute("message", "mauvais MDP");
                jspClient = "/Auth.jsp";
            }}
        else if (act.equals("CreerEquipe") ) /* auth de fédé*/
        {
            creerEq(request,response);
            jspClient = "/fede/MenuFederation.jsp";

        }
        else if (act.equals("CreerEntraineur") ) /* auth de fédé*/
        {
            jspClient = "/fede/MenuFederation.jsp";
            creerEnt(request,response);
        }
        else if (act.equals("CreerJoueur") ) /* auth de fédé*/
        {
            jspClient = "/fede/MenuFederation.jsp";
            creerJ(request,response);
        }
        else if (act.equals("CreerArbitre") ) /* auth de fédé*/
        {
            jspClient = "/fede/MenuFederation.jsp";
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
            jspClient="/fede/CreerMatch.jsp";
        }
        else if (act.equals("CreerMa"))
        {
            jspClient = "/fede/MenuFederation.jsp";
            CreerMa(request,response);
        }
        else if (act.equals("ModifierM"))
        {
            Collection <Matchs> listem = gestionFederation.TousLesMAtchs();
            request.setAttribute("listeMatch", listem);
            jspClient="/fede/ModifierMatchDate.jsp";
        }
        else if (act.equals("ModifierMa"))
        {
            jspClient = "/fede/MenuFederation.jsp";
            ModifierMa(request,response);
        }
        else if (act.equals("AffecterE"))
        {
            Collection <Equipe> listee = gestionFederation.LesEquipes();
            Collection <Entraineur> listeent = gestionFederation.TousLesEntraineurs();
            request.setAttribute("listeEquipes", listee);
            request.setAttribute("listeEquipent", listeent);
            jspClient="/fede/AffecterEntraineur.jsp";
        }
        else if (act.equals("AffEnt"))
        {
            jspClient = "/fede/MenuFederation.jsp";
            Affecter(request,response);
        }
         else if (act.equals("SaisirDateM"))
        {
            String d = request.getParameter("dateMatch") ;
            if (!(d.trim().isEmpty()))
            {
               Date da = Date.valueOf(d);
               Collection <Faute> fa = gestionFederation.AfficherFauteDate(da);
               jspClient = "/fede/AffihcherFautesDate.jsp";
               request.setAttribute("listeFa", fa);
            }
            else{
            jspClient = "/fede/MenuFederation.jsp";}
            
        }
        else if (act.equals("AfficherFauteJ"))
        {
            System.out.println("1");
            Collection <Joueur> listej = gestionFederation.TousLesJoueurs();
            request.setAttribute("listeJoueur", listej);
            jspClient="/fede/RechercherJoueur.jsp";
        }
         else if (act.equals("afficherFauteJo"))
        {
                        System.out.println("é");
            String j = request.getParameter("jo") ;

            if (!(j.trim().isEmpty()))
            {
                int l = Integer.valueOf(j);
               Collection <Faute> f = gestionFederation.AfficherFauteJoueur(l);
               jspClient = "/fede/AfficherFautesJoueur.jsp";
               request.setAttribute("listeF", f);
                           System.out.println("3");
            }
        }
            else if (act.equals("AfficherFauteArb"))
        {
            Collection <Arbitre> listea = gestionFederation.LesArbitres();
            request.setAttribute("listeArbitre", listea);
            jspClient="/fede/RechercherArbitre.jsp";
        }
         else if (act.equals("afficherFauteAr"))
        {
            String a = request.getParameter("arbi") ;
            if (!(a.trim().isEmpty()))
            {
                int l = Integer.valueOf(a);
               Collection <Faute> f = gestionFederation.AfficherFauteArbitre(l);
               jspClient = "/fede/AfficherFautesArbitre.jsp";
               request.setAttribute("listeFaa", f);
            }
        }
            else if (act.equals("Sanction"))
        {
            Collection <Joueur> listej = gestionFederation.TousLesJoueurs();
            request.setAttribute("listeJoueur", listej);
            jspClient="/fede/Sanction.jsp";
        }
         else if (act.equals("SanctionJo"))
        {            
            Sanctionner(request,response);
            jspClient = "/fede/MenuFederation.jsp";
        
        }
        
            else{
            jspClient = "/fede/MenuFederation.jsp";}
        
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
