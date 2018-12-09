<%-- 
    Document   : CreerArbitre
    Created on : 30 nov. 2018, 03:56:33
    Author     : katia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Créer Un Arbitre</title>
    </head>
    <body>
        <h1>Créer un Arbitre</h1>
        <form method ="get" action="../gestionFed">
            <table>
                <tr>
                    <td>            
                        <label for="nomArbitre">Nom de l'arbitre<span class="requis"></span></label> 
                    </td>
                    <td>
                        <input type ="text" name="nomArbitre" value="" size="20" maxlength="30"/>
                    </td>
                </tr>
                <tr>
                    <td>            
                        <label for="prenomArbitre">Prénom de l'arbitre<span class="requis"></span></label> 
                    </td>
                    <td>
                        <input type ="text" name="prenomArbitre" value="" size="20" maxlength="30"/>
                    </td>
                </tr>
                <tr>
                    <td>            
                        <label for="loginArbitre">Login de l'arbitre<span class="requis"></span></label> 
                    </td>
                    <td>
                        <input type ="text" name="loginArbitre" value="" size="20" maxlength="30"/>
                    </td>
                </tr>
                <tr>
                    <td>            
                        <label for="mdpArbitre">Mdp de l'arbitre<span class="requis"></span></label> 
                    </td>
                    <td>
                        <input type ="text" name="mdpArbitre" value="" size="20" maxlength="30"/>
                    </td>
                </tr>
            </table>
            <input type ="hidden" name="action" value="CreerArbitre">
        
            <input type="submit" value="Valider"/>
            <input type="reset" value="Reset"/>          
            </br>
            <a href ="/MenuFederation.jsp"> Retour Menu </a>
            
        </form>
    </body>
</html>
