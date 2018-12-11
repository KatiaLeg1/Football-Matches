<%-- 
    Document   : RechercherJoueur
    Created on : 9 déc. 2018, 03:29:08
    Author     : katia
--%>

<%@page import="entites.Joueur"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/fede/cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeJoueur" scope="request" class = "java.util.List"> </jsp:useBean>
        
        <title>Choisir le joueur pour afficher les fautes</title>
    </head>
    <body>
        <h1>Choisir le joueur pour afficher les fautes</h1>
        <form method ="get" action="${pageContext.request.contextPath}/gestionFed">

        
                <% List<Joueur> lesJou = listeJoueur;%>
                
                  <div class="input1">
            </br>   
            <div class ='input2'>
                <label for="jo" class='textinput'>Joueur  : <span class="requis"></span></label>
                <select name="jo" class = 'custom-dropdown__select custom-dropdown__select--white'>
                    <% for (Joueur j : lesJou ){%>
                    <option value="<%=j.getId()%>"><%=j.getNomPersonne() %> <%=j.getPrenomPersonne() %> </option>
                    <%}%>
                </select> 
            </div>
            <input type ="hidden" name="action" value="afficherFauteJo">
        
            <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Remise à 0"/>       
            </div>
            </br>
 <div class='retour'>
            <a href ="${pageContext.request.contextPath}/fede/MenuFederation.jsp"> Retour Menu </a>
            </div>    </body>
</html>
