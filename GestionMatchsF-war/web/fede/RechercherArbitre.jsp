<%-- 
    Document   : RechercherArbitre
    Created on : 9 déc. 2018, 04:10:50
    Author     : katia
--%>

<%@page import="entites.Arbitre"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                
                 <fieldset>
                <label for="arbi">Joueur  : <span class="requis"></span></label>
                <select name="arbi">
                    <% for (Arbitre a : lesArb ){%>
                    <option value="<%=a.getId()%>"><%=a.getNomPersonne() %><%=a.getPrenomPersonne() %> </option>
                    <%}%>
                </select> 
                
                
                <input type ="hidden" name="action" value="afficherFauteAr">
        
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à 0"/>     <br>
            <a href ="MenuFederation.jsp"> Retour Menu </a>
    </body>
</html>
