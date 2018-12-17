<%-- 
    Document   : MenuEntraineur
    Created on : 4 déc. 2018, 10:40:11
    Author     : Utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Entraineur</title>
    </head>
    <body>
        <h1>Menu Entraineur</h1>
        <% String attribut = (String)request.getAttribute("message");
        out.println(attribut);
        %>
        </br>
          <a href ="gestionEntraineur?action=rechercherJ"> Affecter un joueur à l'équipe </a><br/>
          <a href ="gestionEntraineur?action=afficherJ"> Afficher tous les joueurs </a><br/>
          
          
                  <a href ="Auth.jsp"> Retour Auth </a></div>

    </body>
</html>
