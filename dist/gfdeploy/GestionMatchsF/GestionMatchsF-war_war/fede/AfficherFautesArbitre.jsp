<%-- 
    Document   : AfficherFautesArbitre
    Created on : 9 déc. 2018, 04:12:52
    Author     : katia
--%>


<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="entites.Faute"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/fede/cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeFaa" scope="request" class="Collection<Faute>"></jsp:useBean>
        <title>Liste fautes pour un arbitre</title>
    </head>
    <body>
        <h1>Liste fautes pour un arbitre</h1>
        <div style="overflow-x:auto;">

        <table>
        <tr>   
            <td Width =15%>date du match</td>
            <td Width =15%>Heure du match</td>
            <td Width =15%>Type de faute</td>
            <td Width =15%> Nom Joueur </td>
            <td Width =15%> Prénom Joueur</td>
        </tr> 
        <% for(Faute f : listeFaa){%>
        <tr>   
            <td Width =15%><%=f.getMatch().getDateMatch().getDate() %> / <%=f.getMatch().getDateMatch().getMonth() %> / <%=f.getMatch().getDateMatch().getYear()+1900 %></td>
            <td Width =15%><%=f.getMatch().getHeure() %></td>
            <td Width =15%><%=f.getTypeFaute()%></td>
            <td Width =15%><%=f.getJoueur().getNomPersonne() %></td>
            <td Width =15%><%=f.getJoueur().getPrenomPersonne() %></td>

        </tr> <%}%></table>
        </div>
            
        
        </br>
        <div class='retour'>
            <a href ="${pageContext.request.contextPath}/fede/MenuFederation.jsp"> Retour Menu </a>
        </div>

    </body>
</html>