<%-- 
    Document   : RechercherJoueurEq
    Created on : Dec 11, 2018, 2:00:47 PM
    Author     : domitille
--%>
 <%@page import="java.util.List"%>
<%@page import="entites.Joueur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <jsp:useBean id="listeJou" scope="request" class = "java.util.List"> </jsp:useBean> 
         <title>Choisir le joueur pour afficher historique de ses equipes</title>
    </head>
    <body>
        <h1>Choisir le joueur pour afficher l'historique de ses équipes</h1>
                <form method ="get" action="GestionTous">  
         
                <% List<Joueur> lesJou = listeJou;%>
                
            <div class="input1">
            </br>   
            <div class ='input2'>
                <label for="jou" class='textinput'>Joueur : </label>
                <select name="jou" class ='custom-dropdown__select custom-dropdown__select--white'>
                    <% for (Joueur j : lesJou ){%>
                    <option value="<%=j.getId()%>"><%=j.getNomPersonne() %> <%=j.getPrenomPersonne() %> </option>
                    <%}%>
                </select> 
            </div>
            </div>                
                
                <input type ="hidden" name="action" value="HistoJou"> 
            <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Remise à 0"/>       
            </div>    
                </br>
        <div class='retour'>
            <a href ="MenuTous.jsp"> Retour Menu </a>
        </div>
    </body>
</html>