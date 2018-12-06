<%-- 
    Document   : authFederation
    Created on : 4 déc. 2018, 21:08:01
    Author     : katia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>Page d'authentification</h1>
        <form  method ="get" action="gestionFed">
            <fieldset>  
                <label for="login">login<span class="requis">*</span></label> 
                <input type="text" name="login" value="" size="20" maxlength="20"/> <br>
                <label for="mdp">MDP <span class="requis">*</span></label> 
                <input type="password" name="mdp" value="" size="20" maxlength="20"/> <br>
               
                <input type ="hidden" name="action" value="authFed">
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à 0"/>  <br>
<a href ="MenuFederation.jsp"> Retour Menu </a>

        </form>
                    </div>
                </div>
            </div>   

    </body>
</html>
