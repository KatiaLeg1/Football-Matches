<%-- 
    Document   : CreerEquipe
    Created on : 30 nov. 2018, 01:36:09
    Author     : katia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Créer Une Equipe</title>
    </head>
    <body>
        <h1>Créer une Equipe</h1>
        <form method ="get" action="../gestionFed">
            <fieldset>
                <label for="nomEquipe">Nom de l'équipe<span class="requis"></span></label> 
                <input type ="text" name="nomEquipe" value="" size="20" maxlength="20"/>
                    
            <input type ="hidden" name="action" value="CreerEquipe">
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Reset"/>  
            </br>
            <a href ="MenuFederation.jsp"> Retour Menu </a>
            
        </form>
    </body>
</html>
