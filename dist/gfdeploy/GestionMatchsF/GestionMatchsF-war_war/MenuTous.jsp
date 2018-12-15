<%-- 
    Document   : MenuTous
    Created on : Dec 4, 2018, 12:38:08 PM
    Author     : domitille
--%>
 <%@page contentType="text/html" pageEncoding="UTF-8"%>
 <link href="${pageContext.request.contextPath}/cssMenuTous.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu pour tous</title>
    </head>
    <body>
        <div id="entete">Menu pour tous</div>
        <p> 
        <!--<p><% String attribut = (String)request.getAttribute("message");
        out.println(attribut);
        %>-->
         
        <a href ="GestionTous?action=AffEqEnt"> Historique de l'entraineur </a></br>
        <a href ="GestionTous?action=AffEqJou"> Historique du joueur </a></br>
        <a href ="GestionTous?action=AfficherEqJou"> Afficher les joueurs d'une équipe </a></br>
        <a href ="GestionTous?action=AfficherClassementEq"> Afficher le classement des équipes </a></br>
        <a href ="GestionTous?action=AfficherMatchsEq"> Afficher les matchs d'une equipe avec les resultats</a></br>
        <a href ="RecherchermatchsDate.jsp"> Afficher les dates de matchs  </a></br>
    </body>
</html>