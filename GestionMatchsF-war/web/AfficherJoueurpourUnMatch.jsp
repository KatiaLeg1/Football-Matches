<%-- 
    Document   : Afficherjoueurs
    Created on : Dec 4, 2018, 9:36:52 AM
    Author     : domitille
--%>
 <%@page contentType="text/html" pageEncoding="UTF-8"%>
 <link href="${pageContext.request.contextPath}/cssMenuTous.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Afficher les joueurs pour un match</title>
    </head>
    <body>
        <h1>Afficher les joueurs pour un match</h1
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
        <p>
            <a href ="MenuTous.jsp">Menu tous</a>
        </p>
    </body>
</html>