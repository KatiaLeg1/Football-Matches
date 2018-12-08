<%-- 
    Document   : saisirDateRecherche
    Created on : 9 déc. 2018, 02:34:47
    Author     : katia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <title>Saisir une date </title>
    </head>
    <body>
        <h1>Saisir une date  pour afficher tous les matchs</h1>
       
        <form method ="get" action="gestionFed">  
           
            <fieldset>
                <label for="dateMatch">Date des match<span class="requis">*</span></label> 
                <input type="date" id="dateMatch" name="dateMatch" value="" size="20" maxlength="20"/>
            <
                <input type ="hidden" name="action" value="SaisirDateM">
        
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à 0"/>     <br>
                        <a href ="MenuFederation.jsp"> Retour Menu </a>

        </form>
    </body>
</html>
