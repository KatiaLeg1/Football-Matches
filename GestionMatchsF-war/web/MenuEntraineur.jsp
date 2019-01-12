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
            </div><div class="menubis"><a href ="gestionEntraineur?action=rechercherJ"> Transférer un joueur </a>
            </div><div class="menubis"><a href ="gestionEntraineur?action=rechercherJL"> Recruter un joueur libre </a>    
            </div><div class="menubis"><a href ="gestionEntraineur?action=afficherJ"> Afficher les joueurs de l'équipe </a>
            </div><div class="menubis"><a href ="gestionEntraineur?action=afficherTJ"> Afficher tous les joueurs </a>
            </div><div class="menubis"><a href="gestionEntraineur?action=rechercherSuppJ"> Supprimer un joueur </a>    
            </div><div class="menubis"><a href="gestionEntraineur?action=choisirM"> Composition de l'équipe </a>
          </div>
        </div></br></br>
        <div class="retour">
    <a href ="Auth.jsp"> Retour Auth </a></div>
    </body>
</html>
