<%-- 
    Document   : saisirDateRecherche
    Created on : 9 déc. 2018, 02:34:47
    Author     : katia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <title>Saisir une date </title>
    </head>
    <body>
        <h1>Saisir une date pour afficher tous les matchs</h1>
       
        <form method ="get" action="gestionFed">
           
           <div class="input1">
            </br>   
            <div class ='input2'>
                <label for="dateMatch" class='textinput'>Date des matchs</label> 
                <input type="date" placehlder='date des matchs' id="dateMatch" name="dateMatch" class='input'/>
            
                <input type ="hidden" name="action" value="SaisirDateM">
            </div></div>
            
            <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Remise à 0"/>       
            </div>
            </br>
 <div class='retour'>
            <a href ="MenuTous.jsp"> Retour Menu </a>
            </div>
        </form>
    </body>
</html>
