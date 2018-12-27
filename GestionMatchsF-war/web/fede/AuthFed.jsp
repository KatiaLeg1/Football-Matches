<%-- 
    Document   : AuthFed
    Created on : 9 déc. 2018, 05:49:25
    Author     : katia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>

<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Connexion Federation</title>
    </head>
    <body>
        <h1>Connexion Federation</h1>

        <form method ="get" action="${pageContext.request.contextPath}/gestionFed">
           
           <div class="input1">
            </br>
                <input type="password" placeholder='Mdp' name="mdp" class='input'/>

                <input type ="hidden" name="action" value="authFed">
        
            </div>
            <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Remise à 0"/>       
            </div>
            </br>
            <div class='retour'>
            <a href ="${pageContext.request.contextPath}/Auth.jsp"> Retour Menu </a>
            </div>
        </form>
    </body>
</html>