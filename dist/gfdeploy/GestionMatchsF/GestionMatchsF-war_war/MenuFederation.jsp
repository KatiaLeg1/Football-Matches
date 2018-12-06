<%-- 
    Document   : MenuFederation
    Created on : 30 nov. 2018, 01:19:48
    Author     : katia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Federation</title>
    </head>
    <body>
        <h1>Menu Federation </h1>
        <p> 
        <% String attribut = (String)request.getAttribute("message");
        out.println(attribut);
        %>
        
        <a href ="CreerEquipe.jsp"> Créer une équipe </a> </br></br>
        <a href ="CreerArbitre.jsp"> Créer un Arbitre </a></br></br>
        <a href ="CreerEntraineur.jsp"> Créer un Entraineur </a></br></br>
        <a href ="CreerJoueur.jsp"> Créer un Joueur </a></br></br>
        <a href ="gestionFed?action=CreerM"> Créer un Match </a></br></br>
        <a href ="gestionFed?action=ModifierM"> Modifier un Match </a></br></br>
        <a href ="gestionFed?action=AffecterE"> Affecter un entraineur a une équipe </a>
        
        <%--<a href ="gestionFed?action=AfficherFautesMatch"> Afficher les fautes commises pour un match </a>
        <a href ="SanctionnerJoueur.jsp"> Sanctionner les joueurs </a>
        <a href ="gestionFed?action=AfficherFauteArbitre.jsp"> Afficher les fautes commises par des joueurs lors des matchs arbitrés par un arbitre </a>
        <a href ="gestionFed?action=AfficherFauteJoueur.jsp"> Afficher les faute d'un joueur </a>      
      
        --%>
        
                    <a href ="Auth.jsp"> Retour Auth </a>

    </body>
</html>
