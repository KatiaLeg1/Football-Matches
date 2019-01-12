<%-- 
    Document   : AffecterJoueur
    Created on : 4 déc. 2018, 10:52:10
    Author     : Utilisateur
--%>

<%@page import="entites.HistoriqueJoueur"%>
<%@page import="entites.Entraineur"%>
<%@page import="entites.Joueur"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recherche d'un joueur</title>
        <jsp:useBean id="listejoueurs" scope="request" class="java.util.List"></jsp:useBean>

    </head>
    <body>
    <h1>Rechercher joueur</h1>
    <% List<HistoriqueJoueur> lesJoueurs=listejoueurs; %>
    <form method="get" action="gestionEntraineur">
        <div class="input1">
            </br>   
            <div class ='input2'>     
                <label for="Joueurs"  class='textinput'> Joueur à affecter à l'équipe : </label>                
                <select name="Joueurs"  class='custom-dropdown__select custom-dropdown__select--white'>
                    <% for(HistoriqueJoueur hj: lesJoueurs) {%>
                    <option value="<%=hj.getJoueur() %>"><%=hj.getJoueur().getPrenomPersonne()%> <%=hj.getJoueur().getNomPersonne()%></option>
                    <%}%>
                </select>   
        <br/>
            </div>
            <div class ='input2'>     
                <label for="dateDebutHJ" class='textinput'>Date de début du contrat : </label> 
                <input type ="date" placeholder ="Date de début du contrat" name="dateDebutHJ" class='input'/>
        </div>
        </div>
            <input type ="hidden" name="action" value="affecterJ"/>
       
        <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Remise à 0"/>       
        </div>
        <div class='retour'>
            <a href ="MenuEntraineur.jsp"> Retour Menu </a>
            </div>  
    </form>
    </body>
</html>
