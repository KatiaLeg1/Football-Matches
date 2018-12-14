<%-- 
    Document   : Auth
    Created on : 30 nov. 2018, 03:49:49
    Author     : katia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <link href="${pageContext.request.contextPath}/cssAccueil.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page d'authentification</title>
    </head>
    <body>
        <h1>Page d'authentification</h1>
        <p>
             <% String attribut = (String)request.getAttribute("message");
        out.println(attribut);
        %>

            <a href ="${pageContext.request.contextPath}/fede/AuthFed.jsp"> Menu Fédération </a><br>
            <a href ="AuthEnt.jsp"> Menu Entraineur </a><br>
            <a href ="MenuTous.jsp"> Menu Tous </a><br>
            <a href ="AuthArb.jsp"> Menu Arbitre </a><br>
                
        </p>
    </body>
</html>
