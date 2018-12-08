<%-- 
    Document   : RechercherJoueurSanction
    Created on : 9 déc. 2018, 04:29:45
    Author     : katia
--%>
<%@page import="entites.Joueur"%>
<%@page import="entites.Arbitre"%>
<%@page import="entites.Equipe"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeJoueur" scope="request" class = "java.util.List"> </jsp:useBean>
        
        <title>Sanctionner un joueur</title>
    </head>
    <body>
        <h1>Creer un Match</h1>
        <% List<Joueur> lesJoueur = listeJoueur;%>

        <form method ="get" action="gestionFed">  
           
            <fieldset>
                 <label for="jou">joueur : <span class="requis"></span></label>
                <select name="jou">
                    <% for (Joueur j : lesJoueur ){%>
                    <option value="<%=j.getId() %>"><%= j.getNomPersonne() %> </option>
                    <%}%>
                </select> 
                 <br><br>
                <label for="dateInt">Date d'interdiction<span class="requis">*</span></label> 
                <input type="date" name="dateInt" value="" size="20" maxlength="20"/>
            <br>
                
            <br>
               
            
               <br>
            
                <input type ="hidden" name="action" value="SanctionJo">
        
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à 0"/>     <br>
                        <a href ="MenuFederation.jsp"> Retour Menu </a>

        </form>
    </body>
</html>