<%-- 
    Document   : MenuTous
    Created on : Dec 4, 2018, 12:38:08 PM
    Author     : domitille
--%>
 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu pour tous</title>
    </head>
    <body>
        <h1>Menu pour tous</h1>
        <p> 
        <div class="message"><% String attribut = (String)request.getAttribute("message");
        out.println(attribut);
        %></div>
        </br></br> 
        <div clas='menu'>  
            <div class="menubis">  <a href ="GestionTous?action=AffEqEnt"> Historique de l'entraineur </a></br>
            </div><div class="menubis"><a href ="GestionTous?action=AffEqJou"> Historique du joueur </a></br>
            </div><div class="menubis"><a href ="GestionTous?action=AfficherEqJou"> Afficher les joueurs d'une équipe </a></br>
            </div><div class="menubis"><a href ="GestionTous?action=AfficherClassementEq"> Afficher le classement des équipes </a></br>
            </div><div class="menubis"><a href ="GestionTous?action=AfficherMatchsEq"> Afficher les matchs d'une equipe avec les resultats</a></br>
            </div><div class="menubis"><a href ="RecherchermatchsDate.jsp"> Afficher les dates de matchs  </a></br>
            </div><div class="menubis"><a href ="Auth.jsp"> Retour Auth </a></div>
            </div>
        </div></br></br>
        <div class="retour">
            <a href ="${pageContext.request.contextPath}/Auth.jsp"> Retour Auth </a>
        </div>
        
    </body>
</html>