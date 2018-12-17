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
        
        <%-- tu dois envoyer en valeur action que tu vas déclaré dans t  servlet<a href ="CreerFauteJoueur.jsp"> Créer des fautes Joueur </a>
         --%>   <a href ="gestionArb?action=ModifM"> Modifier résultats d'un match </a> 
        <a href ="gestionArb?action=CF">  Créer des fautes Joueur </a></br></br>
        <%-- direction Servlet gestionArb --%>
        
        <a href ="Auth.jsp"> Retour Auth </a></div>

        
    </body>
</html>
