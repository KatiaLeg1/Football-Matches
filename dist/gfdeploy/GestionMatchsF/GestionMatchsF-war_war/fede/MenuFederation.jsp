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
        </br></br>
        <a href ="${pageContext.request.contextPath}/fede/CreerEquipe.jsp"> Créer une équipe </a> </br></br>
        <a href ="${pageContext.request.contextPath}/fede/CreerArbitre.jsp"> Créer un Arbitre </a></br></br>
        <a href ="${pageContext.request.contextPath}/fede/CreerEntraineur.jsp"> Créer un Entraineur </a></br></br>
        <a href ="${pageContext.request.contextPath}/fede/CreerJoueur.jsp"> Créer un Joueur </a></br></br>
        <a href ="gestionFed?action=CreerM"> Créer un Match </a></br></br>
        <a href ="gestionFed?action=ModifierM"> Modifier un Match </a></br></br>
        <a href ="gestionFed?action=AffecterE"> Affecter un entraineur a une équipe </a></br></br>
        <a href ="${pageContext.request.contextPath}/fede/saisirDateRecherche.jsp"> Afficher les fautes commises pour une date </a></br></br>
        <a href ="gestionFed?action=AfficherFauteJ"> Afficher les fautes d'un joueur </a> </br></br>      
        <a href ="gestionFed?action=AfficherFauteArb"> Afficher les fautes commises par des joueurs pour un arbitre </a></br></br> 
        <a href ="gestionFed?action=Sanction"> Sanctionner les joueurs </a></br></br> 
      
        
        <a href ="/${pageContext.request.contextPath}/Auth.jsp"> Retour Auth </a>

    </body>
</html>
