<%-- 
    Document   : AfficherJoueurPourUneEquipe
    Created on : Dec 11, 2018, 2:52:11 PM
    Author     : domitille
--%>
 <%@page import="entites.HistoriqueJoueur"%>
<%@page import="java.util.List"%>
<%@page import="entites.Joueur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="/cssfede.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="lesJoueurs" scope="request" class="List<HistoriqueJoueur>"></jsp:useBean> <%-- attention aux noms + Dans scope ça devient Session--%>
         <title>Afficher la liste des joueurs d'une équipe</title>
    </head>
    <body>
        <h1>Afficher la liste des joueurs d'une équipe</h1>
         
        <div style="overflow-x:auto;">               
        <table>
           </tr>   
            <th Width =15%>Nom  de l'équipe</th>
            <th Width =15%>Nom  du joueur</th>
            <th Width =15%>Prénom du joueur</th>
        </tr> 
        <% for(HistoriqueJoueur j : lesJoueurs){%>       
        </tr>   
            <td ><%= j.getEquipeJoueur().getNomequipe() %></td>
            <td ><%=j.getJoueur().getNomPersonne() %></td>
            <td ><%=j.getJoueur().getPrenomPersonne()%></td>
         </tr> <%}%>
        </table>
        <div class='retour'>
            <a href="MenuTous.jsp"> Retour Menu</a>
        </div>
    </body>
</html>