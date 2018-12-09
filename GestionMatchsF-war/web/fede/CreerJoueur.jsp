<%-- 
    Document   : CreerJoueur
    Created on : 1 déc. 2018, 17:57:51
    Author     : katia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Créer Un Entraineur</title>
    </head>
    <body>
        <h1>Créer un Entraineur</h1>
        <form method ="get" action="../gestionFed">
            <table>
                <tr>
                    <td>            
                        <label for="nomJoueur">Nom du Joueur<span class="requis"></span></label> 
                    </td>
                    <td>
                        <input type ="text" name="nomJoueur" value="" size="20" maxlength="30"/>
                    </td>
                </tr>
                <tr>
                    <td>            
                        <label for="prenomJoueur">Prénom du Joueur<span class="requis"></span></label> 
                    </td>
                    <td>
                        <input type ="text" name="prenomJoueur" value="" size="20" maxlength="30"/>
                    </td>
                </tr>
                
            </table>
            <input type ="hidden" name="action" value="CreerJoueur">
        
            <input type="submit" value="Valider"/>
            <input type="reset" value="Reset"/>     
            </br>
            <a href ="MenuFederation.jsp"> Retour Menu </a>
            
        </form>
    </body>
</html>
