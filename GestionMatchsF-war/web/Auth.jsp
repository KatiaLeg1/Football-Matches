<%-- 
    Document   : Auth
    Created on : 30 nov. 2018, 03:49:49
    Author     : katia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page d'authentification</title>
    </head>
    <body>
        <h1>Page d'authentification</h1>
        
        <div class="message"><% String attribut = (String)request.getAttribute("message");
        out.println(attribut);
        %></div>
        </br></br> 
        <div clas='menu'>  
            <div class="menubis">
            </div><div class="menubis"><a href ="${pageContext.request.contextPath}/fede/AuthFed.jsp"> Menu Fédération </a>
            </div><div class="menubis"><a href ="AuthEnt.jsp"> Menu Entraineur </a>
            </div><div class="menubis"><a href ="MenuTous.jsp"> Menu Tous </a>
            </div><div class="menubis"><a href ="AuthArb.jsp"> Menu Arbitre </a>
            </div></div>
                
    </body>
</html>
