<%-- 
    Document   : RechercherJoueur
    Created on : 9 déc. 2018, 03:29:08
    Author     : katia
--%>

<%@page import="entites.Joueur"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeJoueur" scope="request" class = "java.util.List"> </jsp:useBean>
        
        <title>Choisir le joueur pour afficher les fautes</title>
    </head>
    <body>
        <h1>Choisir le joueur pour afficher les fautes</h1>
                <form method ="get" action="gestionFed">  

        
                <% List<Joueur> lesJou = listeJoueur;%>
                
                 <fieldset>
                <label for="jo">Joueur  : <span class="requis"></span></label>
                <select name="jo">
                    <% for (Joueur j : lesJou ){%>
                    <option value="<%=j.getId()%>"><%=j.getNomPersonne() %><%=j.getPrenomPersonne() %> </option>
                    <%}%>
                </select> 
                
                
                <input type ="hidden" name="action" value="afficherFauteJo">
        
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à 0"/>     <br>
            <a href ="MenuFederation.jsp"> Retour Menu </a>
    </body>
</html>
