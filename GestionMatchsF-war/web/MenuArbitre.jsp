<%-- 
    Document   : MenuArbitre
    Created on : 4 déc. 2018, 12:05:47
    Author     : Sophie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Arbitre</title>
    </head>
    <body>
        <h1>Menu Arbitre</h1>
         <% String attribut = (String)request.getAttribute("message");
        out.println(attribut);
        %>
        
        <a href ="CreerFauteJoueur.jsp"> Créer des fautes Joueur </a>
        <a href ="ModifierMatch.jsp"> Modifier résultats d'un match </a>
    </body>
</html>
