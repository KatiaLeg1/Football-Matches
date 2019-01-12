<%-- 
    Document   : CreerArbitre
    Created on : 30 nov. 2018, 03:56:33
    Author     : katia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Créer Un Arbitre</title>
    </head>
    <body>
        <h1>Créer un Arbitre</h1>
        <form method ="get" action="gestionFed">
            <div class="input1">
                </br>
            <input type ="text" placeholder='Nom de l arbitre' name="nomArbitre" class='input'/>
            <input type ="text" placeholder='Prénom de l arbitre'name="prenomArbitre" class='input'/>
            <input type ="text" placeholder='Login de l arbitre'name="loginArbitre" class='input'/>
            <input type ="text" placeholder='Mdp de l arbitre' name="mdpArbitre" class='input'/>
            <input type ="hidden" name="action" value="CreerArbitre">
            </div>
            <div class='bouton1'>
                </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Remise à 0"/>       
            </div>
            </br>
 <div class='retour'>
            <a href ="MenuFederation.jsp"> Retour Menu </a>
            </div>            
        </form>
    </body>
</html>
