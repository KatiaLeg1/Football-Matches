<%-- 
    Document   : RechercherJoueurSanction
    Created on : 9 déc. 2018, 04:29:45
    Author     : katia
--%>
<%@page import="entites.Joueur"%>
<%@page import="entites.Arbitre"%>
<%@page import="entites.Equipe"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/fede/cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeJoueur" scope="request" class = "java.util.List"> </jsp:useBean>
        
        <title>Sanctionner un joueur</title>
    </head>
    <body>
        
        <h1>Creer un Match</h1>
        <% List<Joueur> lesJoueur = listeJoueur;%>

        <form method ="get" action="${pageContext.request.contextPath}/gestionFed">
           
        <div class="input1">
        </br>   
        <div class ='input2'>
            <label for="jou" class='textinput'>joueur : </label>
            <select name="jou" class = 'custom-dropdown__select custom-dropdown__select--white'>
                <% for (Joueur j : lesJoueur ){%>
                <option value="<%=j.getId() %>"><%= j.getNomPersonne() %> <%= j.getPrenomPersonne() %> </option>
                <%}%>
            </select> 
        </div>
        <div class ='input2'>                      
            <br>
                <label for="dateInt" class='textinput'>Date d'interdiction : </label> 
                <input type="date" placeholder="date d'interdiction" name="dateInt" class="input"/>
                <input type ="hidden" name="action" value="SanctionJo">
                
        
        </div></div>    
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