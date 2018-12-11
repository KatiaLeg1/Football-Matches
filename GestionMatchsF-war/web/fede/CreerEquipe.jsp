<%-- 
    Document   : CreerEquipe
    Created on : 30 nov. 2018, 01:36:09
    Author     : katia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Créer Une Equipe</title>
    </head>
    <body>
        <h1>Créer une Equipe</h1>
        <form method ="get" action="../gestionFed">
            <div class="input1">
            </br>                
            <input type ="text" placeholder="Nom de l'équipe" name="nomEquipe" class='input'/>
            <input type ="hidden" name="action" value="CreerEquipe">
            </div>
            <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Remise à 0"/>       
            </div>
            </br>
 <div class='retour'>
            <a href ="${pageContext.request.contextPath}/fede/MenuFederation.jsp"> Retour Menu </a>
            </div>            
        </form>
    </body>
</html>
