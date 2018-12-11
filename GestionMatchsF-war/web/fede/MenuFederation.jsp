<%-- 
    Document   : MenuFederation
    Created on : 30 nov. 2018, 01:19:48
    Author     : katia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/fede/cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Federation</title>
    </head>
    <body>
       
        <h1>Menu Federation </h1>
        <div class="message"><% String attribut = (String)request.getAttribute("message");
        out.println(attribut);
        %></div>
        </br></br> 
        <div clas='menu'>  
            <div class="menubis">   <a href ="${pageContext.request.contextPath}/fede/CreerEquipe.jsp"> Créer une équipe </a> 
            </div><div class="menubis"><a href ="${pageContext.request.contextPath}/fede/CreerArbitre.jsp"> Créer un Arbitre </a>
            </div><div class="menubis"><a href ="${pageContext.request.contextPath}/fede/CreerEntraineur.jsp"> Créer un Entraineur </a>
            </div><div class="menubis"><a href ="${pageContext.request.contextPath}/fede/CreerJoueur.jsp"> Créer un Joueur </a>
            </div><div class="menubis"><a href ="gestionFed?action=CreerM"> Créer un Match </a>
            </div><div class="menubis"><a href ="gestionFed?action=ModifierM"> Modifier un Match </a>
            </div><div class="menubis"><a href ="gestionFed?action=AffecterE"> Affecter un entraineur a une équipe </a>
            </div><div class="menubis"><a href ="${pageContext.request.contextPath}/fede/saisirDateRecherche.jsp"> Afficher les fautes commises pour une date </a>
            </div><div class="menubis"><a href ="gestionFed?action=AfficherFauteJ"> Afficher les fautes d'un joueur </a>   
            </div><div class="menubis"><a href ="gestionFed?action=AfficherFauteArb"> Afficher les fautes commises par des joueurs pour un arbitre </a>
            </div><div class="menubis"><a href ="gestionFed?action=Sanction"> Sanctionner les joueurs </a>
                
                
                </div><div class="menubis"><a href ="RecherchermatchsDate.jsp"> Matchs dates </a>
                
            </div>
        </div></br></br>
<div class="retour">
    <a href ="${pageContext.request.contextPath}/Auth.jsp"> Retour Auth </a></div>

    </body>
</html>
