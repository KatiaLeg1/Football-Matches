<%-- 
    Document   : AfficherMatchsEq
    Created on : Dec 11, 2018, 4:43:03 PM
    Author     : domitille
--%>
 <%@page import="java.util.List"%>
<%@page import="entites.Matchs"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="/cssfede.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="AfficherMatch" scope="request" class="List<Matchs>"></jsp:useBean>
         <title>Afficher les matchs d'une equipe avec les resultats</title>
    </head>
    <body>
        <div id="entete">Afficher les matchs d'une équipe avec les résultats</div>
         
        <div style="overflow-x:auto;">
        <table>
            <tr> <th>Nom de l'équipe</th>
                 <th>Nom de l'adversaire</th>
                 <th>Points de l'équipe 1</th>
                 <th>Points de l'équipe 2</th>
            </tr>
                 <% List <Matchs> lesMatchs = AfficherMatch;
                 for(Matchs ma : lesMatchs ){%>
            <tr> 
                <td><%=ma.getEquipeUn().getNomequipe() %></td>
                <td><%=ma.getEquipeDeux().getNomequipe()  %></td>
                <td><%=ma.getButEquipeUn() %></td>
                <td><%=ma.getButEquipeDeux() %></td>
            </tr><%}%>
        </table>
        <div class ='retour'>
           <a href="MenuTous.jsp"  class="bouton1"> Retour Menu</a>
        </div>
    </body>
</html>