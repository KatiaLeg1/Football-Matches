<%-- 
    Document   : MenuTous
    Created on : Dec 4, 2018, 12:38:08 PM
    Author     : domitille
--%>
 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu pour tous</title>
    </head>
    <body>
        <h1>Menu pour tous</h1> //Freedom for Slumdog
        <p> 
        <% String attribut = (String)request.getAttribute("message");
        out.println(attribut);
        %>
        <a href ="GestionTous?action=AffEqEnt"> Histo Entraineur </a></br>
        <a href ="GestionTous?action=AffEqJou"> Histo Joueur </a></br>
        <a href ="GestionTous?action=AfficherEqJou"> Histo Afficher les joueurs d'une équipe </a></br>
        <a href ="GestionTous?action=AfficherClassementEq"> Afficher le classement des équipes </a></br>
        <a href ="GestionTous?action=AfficherMatchsEq"> Afficher les matchs d'une equipe avec les resultats</a></br>
        <a href ="RecherchermatchsDate.jsp"> Matchs dates </a></br>
        
    </body>
</html>