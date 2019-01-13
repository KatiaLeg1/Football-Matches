<%-- 
    Document   : AffihcherFautesDate
    Created on : 9 déc. 2018, 02:54:24
    Author     : katia
--%>

<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="entites.Faute"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeFa" scope="request" class="Collection<Faute>"></jsp:useBean>
        <title>Liste fautes pour une date</title>
    </head>
    <body>
        <h1>Liste fautes pour une date</h1>
                <div style="overflow-x:auto;">

        <table>
             <tr>   
                 <td>Nom</td>
                 <td>Prenom</td>
                 <td>Equipe</td>
                 <td>Type de faute</td>
                 <td>Date de la faute </td>
             </tr>
         <% for(Faute f : listeFa){%>
         <tr>   
            <td><%=f.getJoueur().getNomPersonne() %></td>
            <td><%=f.getJoueur().getPrenomPersonne() %></td>
            <td><%=f.getJoueur().getHistoriqueJoueurs().get(listeFa.size()-1).getEquipeJoueur().getNomequipe() %></td> 
            <td><%= f.getTypeFaute()%></td>
            <td><%= f.getMatch().getDateMatch().getDate()%> / <%= f.getMatch().getDateMatch().getMonth() +1%> / <%= f.getMatch().getDateMatch().getYear()+1900%> </td>
        </tr><%}%> </table>
            
</div>
        </br>
        <div class='retour'>
            <a href ="MenuFederation.jsp"> Retour Menu </a>
        </div>

    </body>
</html>
