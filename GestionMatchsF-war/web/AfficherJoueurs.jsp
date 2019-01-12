<%-- 
    Document   : AfficherJoueurs
    Created on : 4 déc. 2018, 15:19:18
    Author     : Utilisateur
--%>

<%@page import="entites.HistoriqueJoueur"%>
<%@page import="entites.Joueur"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listejoueurs" scope="request" class="java.util.List"></jsp:useBean>
             <title>Joueurs</title>
    </head>
    <body>
        <h1>Afficher joueurs</h1>
        
        <div style="overflow-x:auto;">       
        <table border width="50%">
            <tr> <td>Numéro</td>
                 <td>Nom</td>
                 <td>Prénom</td>
                 <td> Equipe actuelle </td>
                 <% List <HistoriqueJoueur> lesJoueurs = listejoueurs;
                 for(HistoriqueJoueur jo : lesJoueurs){%>
            <tr> <td Width=15%><%=jo.getJoueur().getId()%></td>
                 <td Width=15%><%=jo.getJoueur().getNomPersonne()%></td>
                 <td Width=15%><%=jo.getJoueur().getPrenomPersonne()%></td>
                 <td Width=15%><%=jo.getEquipeJoueur().getNomequipe()%></td>
            </tr>       
              <%}%>
        </table></hr>
        <div class='retour'>
            <a href ="MenuEntraineur.jsp"> Retour Menu </a>
        </div>
    </body>
</html>

