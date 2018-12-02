<%-- 
    Document   : CreerEntraineur
    Created on : 1 déc. 2018, 17:40:43
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
        <form method ="get" action="gestionFed">
            <table>
                <tr>
                    <td>            
                        <label for="nomEntraineur">Nom de l'Entraineur<span class="requis"></span></label> 
                    </td>
                    <td>
                        <input type ="text" name="nomEntraineur" value="" size="20" maxlength="30"/>
                    </td>
                </tr>
                <tr>
                    <td>            
                        <label for="prenomEntraineur">Prénom de l'Entraineur<span class="requis"></span></label> 
                    </td>
                    <td>
                        <input type ="text" name="prenomEntraineur" value="" size="20" maxlength="30"/>
                    </td>
                </tr>
                <tr>
                    <td>            
                        <label for="loginEntraineur">Login de l'Entraineur<span class="requis"></span></label> 
                    </td>
                    <td>
                        <input type ="text" name="loginEntraineur" value="" size="20" maxlength="30"/>
                    </td>
                </tr>
                <tr>
                    <td>            
                        <label for="mdpEntraineur">Mdp de l'Entraineur<span class="requis"></span></label> 
                    </td>
                    <td>
                        <input type ="text" name="mdpEntraineur" value="" size="20" maxlength="30"/>
                    </td>
                </tr>
            </table>
            <input type ="hidden" name="action" value="CreerEntraineur">
        
            <input type="submit" value="Valider"/>
            <input type="reset" value="Reset"/>               
                                <a href ="MenuFederation.jsp"> Retour Menu </a>

        </form>
    </body>
</html>
