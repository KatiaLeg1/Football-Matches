<%-- 
    Document   : MenuArbitre
    Created on : 4 déc. 2018, 12:05:47
    Author     : Sophie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Arbitre</title>
    </head>
    <body>
        <h1>Menu Arbitre</h1>
         <div class="message"><% String attribut = (String)request.getAttribute("message");
        out.println(attribut);
        %></div>
        </br></br> 
        <div clas='menu'>  
            <div class="menubis"> <a href ="gestionArb?action=ModifM"> Modifier résultats d'un match </a>
            </div><div class="menubis"><a href ="gestionArb?action=CF">  Créer des fautes Joueur </a>
        </div>
        </div></br></br>
    <div class="retour">
        <a href ="${pageContext.request.contextPath}/Auth.jsp"> Retour Auth </a>
    </div>
        
    </body>
</html>
