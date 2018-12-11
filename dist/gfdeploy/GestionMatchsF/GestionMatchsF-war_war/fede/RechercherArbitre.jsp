<%-- 
    Document   : RechercherArbitre
    Created on : 9 déc. 2018, 04:10:50
    Author     : katia
--%>

<%@page import="entites.Arbitre"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/fede/cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeArbitre" scope="request" class = "java.util.List"> </jsp:useBean>
        
        <title>Choisir l'arbitre pour afficher les fautes</title>
    </head>
    <body>
        <h1>Choisir l'arbitre pour afficher les fautes</h1>
        <form method ="get" action="${pageContext.request.contextPath}/gestionFed">

        
            <% List<Arbitre> lesArb = listeArbitre;%>

            <div class="input1">
            </br>   
            <div class ='input2'>
                <label for="arbi" class='textinput'>Joueur  : </label>
                <select name="arbi" class = 'custom-dropdown__select custom-dropdown__select--white'>
                    <% for (Arbitre a : lesArb ){%>
                    <option value="<%=a.getId()%>"><%=a.getNomPersonne() %> <%=a.getPrenomPersonne() %> </option>
                    <%}%>
                </select> 
            </div>    
                
                <input type ="hidden" name="action" value="afficherFauteAr">
        
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
