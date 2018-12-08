<%-- 
    Document   : AuthArb
    Created on : 9 déc. 2018, 05:49:58
    Author     : katia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Connexion Federation</title>
    </head>
    <body>
        <h1>Connexion Federation</h1>

        <form method ="get" action="GestionTous">  
           
            <fieldset>
                 <label for="Login">Login<span class="requis">*</span></label> 
                <input type="text" name="Login" value="" size="20" maxlength="20"/>
                 <br><br>
                <label for="mdp">Mdp<span class="requis">*</span></label> 
                <input type="password" name="mdp" value="" size="20" maxlength="20"/>
            <br>
                
            <br>
               
            
               <br>
            
                <input type ="hidden" name="action" value="authArb">
        
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à 0"/>     <br>
                        <a href ="Auth.jsp"> Retour Authentification </a>

        </form>
    </body>
</html>