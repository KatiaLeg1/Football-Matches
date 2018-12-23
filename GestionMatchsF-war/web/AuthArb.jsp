<%-- 
    Document   : AuthArb
    Created on : 9 déc. 2018, 05:49:58
    Author     : katia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>

<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Connexion Arbitre</title>
    </head>
    <body>
        <h1>Connexion Arbitre</h1>

        <form method ="get" action="gestionArb">  
           
        <div class="input1">
            </br>
                <input type="text" placeholder='Login' name="Login" class='input'/>
                <input type="password" placeholder='mdp' name="mdp" class='input'/>
            <br>  
            <br>
            <br>
        </div>
            
            
                <input type ="hidden" name="action" value="authArb">
            <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Remise à 0"/>       
            </div>
            </br>
            <div class='retour'>
                <a href ="Auth.jsp"> Retour Authentification </a>
            </div>

        </form>
    </body>
</html>