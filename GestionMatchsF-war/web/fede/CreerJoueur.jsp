<%-- 
    Document   : CreerJoueur
    Created on : 1 déc. 2018, 17:57:51
    Author     : katia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Créer un joueur</title>
    </head>
    <body>
        <h1>Créer un joueur</h1>
        <form method ="get" action="../gestionFed">
            <div class="input1">
                </br>
                <input type ="text" placeholder='Nom du Joueur' name="nomJoueur" class='input'/>
                <input type ="text" placeholder='Préom du Joueur'name="prenomJoueur"  class='input'/>
                <input type ="hidden" name="action" value="CreerJoueur">
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
