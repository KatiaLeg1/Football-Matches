/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entites.Entraineur;
import entites.HistoriqueJoueur;
import entites.Joueur;
import entites.Matchs;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
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
import session.gestionToutLocal;

/**
 *
 * @author Utilisateur
 */
@WebServlet(name = "gestionEntraineur", urlPatterns = {"/gestionEntraineur"})
public class gestionEntraineur extends HttpServlet {

    @EJB
    private gestionToutLocal gestionTout;

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
                    request.setAttribute("message", "Bienvenue " + ent.getPrenomPersonne() +" "+ent.getNomPersonne());
                    sess.setAttribute("ent", ent);
                }
        }}
        else if(act.equals("rechercherJ")&& !(sess== null))
        {  
            Entraineur entr = (Entraineur)sess.getAttribute("ent");
            List<HistoriqueJoueur> liste = sessionEnt.listeJouAutreEnt(entr);
            /* J'aimerais afficher uniquemenent les joueurs qui ne sont pas dans l'equipe de l'entraineur connecté avec
            la méthode sessionEnt.listeJAutreEq() mais ça ne fonctionne pas, pb requête SQL */
            request.setAttribute("entr", entr);                       
            request.setAttribute("listejoueurs", liste);
            jspClient="/AffecterJoueur.jsp";
        }
        
        else if(act.equals("rechercherJL")&& !(sess== null))
        {  
            Entraineur entr = (Entraineur)sess.getAttribute("ent");
            List<Joueur> liste = sessionEnt.listeJLibres();
            /* J'aimerais afficher uniquemenent les joueurs qui ne sont pas dans l'equipe de l'entraineur connecté avec
            la méthode sessionEnt.listeJAutreEq() mais ça ne fonctionne pas, pb requête SQL */
            request.setAttribute("entr", entr);                       
            request.setAttribute("listejoueurs", liste);
            jspClient="/AffecterJoueurLibre.jsp";
        }
        
        else if(act.equals("rechercherSuppJ")&& !(sess== null))
        {  
            Entraineur entr = (Entraineur)sess.getAttribute("ent");
            List<Joueur> liste = sessionEnt.affichageJoueurs();
            request.setAttribute("entr", entr);                       
            request.setAttribute("listejoueurs", liste);
            jspClient="/SupprimerJoueur.jsp";
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
                boolean a = sessionEnt.affectationJoueur(id, entr, dateDHJ);
                if (a==true)
                {
                message = "Joueur affecté à l'équipe !"; }
                else
                {
                   message = "Entraineur sans équipe !"; 
                }
            } 
            request.setAttribute("message", message);
            jspClient="/MenuEntraineur.jsp";
        }    
        
         else if(act.equals("supprimerJ"))
        {                     
            String idj = request.getParameter("Joueurs");                 
            String message ;
            if(idj.isEmpty()){
                message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires.";
            } 
            else {
                Entraineur entr = (Entraineur)sess.getAttribute("ent");
                long id = Long.valueOf(idj);
                sessionEnt.suppressionJoueur(id);
                message = "Joueur supprimé avec succès !"; 
            } 
            request.setAttribute("message", message);
            jspClient="/MenuEntraineur.jsp";
        }    
        
        else if(act.equals("afficherJ"))
        {
            Entraineur ent = (Entraineur)sess.getAttribute("ent");
            jspClient="/AfficherJoueurs.jsp";
            List <HistoriqueJoueur> list = sessionEnt.listeJouEnt(ent);
            request.setAttribute("listejoueurs", list);
        } 
        
         else if(act.equals("afficherTJ"))
        {
            jspClient="/AfficherTousJoueurs.jsp";
            List <Joueur> list = sessionEnt.affichageJoueurs();
            /*List <HistoriqueJoueur> list2 = sessionEnt.listeHistoTousJoueurs();*/
            request.setAttribute("listejoueurs", list);
            /*request.setAttribute("histojoueurs", list2);*/
        } 
        else if (act.equals("SJ"))
        {
            jspClient="/RechercherSupp.jsp";
            List <Joueur> list = sessionEnt.affichageJoueurs();
            request.setAttribute("listejoueurs", list);            
        }
        else if (act.equals("SuppJ"))
        {
            
        }
        else if (act.equals("choisirM"))
        {
            Entraineur entr = (Entraineur)sess.getAttribute("ent");
            List<Matchs> listm = sessionEnt.listeMEq(entr);
            List<HistoriqueJoueur> listehe = sessionEnt.listeJouEnt(entr);
            request.setAttribute("listehe", listehe);
            request.setAttribute("listm", listm);
            jspClient="/RechercheMAffJ.jsp";            
        }
        else if (act.equals("affJMatch"))
        {
            String message;
            Entraineur entr = (Entraineur)sess.getAttribute("ent");
            String match = request.getParameter("Match");
            String[] compo = request.getParameterValues("compo");
            if (match.trim().isEmpty()|| compo.length==0)
            {
                message = "Vous n'avez pas rempli tous les champs";
            }
            /*if (!match.trim().isEmpty()&& compo.length==11)*/
            else
            {
                List<Joueur> jou = new ArrayList<>();
                for (String joue : compo){
                    long jouu = Long.valueOf(joue);
                    Joueur jo = sessionEnt.rechercherJoueurId(jouu);
                    jou.add(jo);                    
                }
                int ma = Integer.valueOf(match);
                sessionEnt.CreerCompo(entr, jou, ma);
                message = "composition créée";
            }
            /*else
            {
                message = "Vous n'avez pas sélectionné le bon nombre de joueurs";
            }*/
            
            

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
   
