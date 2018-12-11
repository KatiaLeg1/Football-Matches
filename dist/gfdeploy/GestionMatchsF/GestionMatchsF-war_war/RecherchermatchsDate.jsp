<%-- 
    Document   : RecherchermatchsDate
    Created on : 9 déc. 2018, 02:34:47
    Author     : katia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/fede/cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <title>Saisir une date </title>
    </head>
    <body>
        <h1>Saisir une date pour afficher tous les matchs</h1>
       
        <form method ="get" action="${pageContext.request.contextPath}/gestionFed">
           
           <div class="input1">
            </br>   
            <div class ='input2'>
                <label for="date" class='textinput'>Date des matchs (obligatoire)</label> 
                <input type="date" placeholder='date ' id="dateMatch" name="date" class='input'/>
            
            </div>
           <div class ='input2'>
                <label for="date1" class='textinput'>Date des matchs (pas obligatoire)</label> 
                <input type="date" placeholder='date 1' id="dateMatch" name="date1" class='input'/>
            
            </div>
           </div>
            
            
            
                            <input type ="hidden" name="action" value="MatchsDate">

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
