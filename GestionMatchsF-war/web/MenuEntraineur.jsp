<%-- 
    Document   : MenuEntraineur
    Created on : 4 déc. 2018, 10:40:11
    Author     : Utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Entraineur</title>
    </head>
    <body>
        <h1>Menu Entraineur</h1>
       <div class="message"><% String attribut = (String)request.getAttribute("message");
        out.println(attribut);
        %></div>
        </br></br> 
        <div clas='menu'>  
            <div class="menubis"> 
            </div><div class="menubis"><a href ="gestionEntraineur?action=rechercherJ"> Affecter un joueur à l'équipe </a>
            </div><div class="menubis"><a href ="gestionEntraineur?action=afficherJ"> Afficher tous les joueurs </a>
            </div><div class="menubis"><a href="gestionEntraineur?action=choisirM"> Composition de l'équipe- choix du match </a>
          </div>
        </div></br></br>
        <div class="retour">
            <a href ="${pageContext.request.contextPath}/Auth.jsp"> Retour Auth </a>
        </div>
        
          

    </body>
</html>
