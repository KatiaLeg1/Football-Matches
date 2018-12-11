<%-- 
    Document   : CreerEntraineur
    Created on : 1 déc. 2018, 17:40:43
    Author     : katia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Créer Un Entraineur</title>
    </head>
    <body>
        <h1>Créer un Entraineur</h1>
        <form method ="get" action="../gestionFed">
            <div class="input1">
            </br>
                <input type ="text" placeholder='Nom de l entraineur' name="nomEntraineur" class='input'/>
                <input type ="text" placeholder='Prénom de l entraineur'name="prenomEntraineur" class='input'/>
                <input type ="text" placeholder='login' name="loginEntraineur" class='input'/>
                <input type ="text" placeholder='mdp' name="mdpEntraineur" class='input'/>
                            <input type ="hidden" name="action" value="CreerEntraineur">

            </div>
            <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Remise à 0"/>       
            </div>
            </br>
            <a href ="${pageContext.request.contextPath}/fede/MenuFederation.jsp"> Retour Menu </a>

        </form>
    </body>
</html>
