<%-- 
    Document   : AfficherMatchsEq
    Created on : Dec 11, 2018, 4:43:03 PM
    Author     : domitille
--%>
 <%@page import="java.util.List"%>
<%@page import="entites.Matchs"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="AfficherMatch" scope="request" class="List<Matchs>"></jsp:useBean>
         <title>Afficher les matchs d'une equipe avec les resultats</title>
    </head>
    <body>
        <h1>Afficher les matchs d'une equipe avec les resultats</h1>
         <p><%
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %>
        </p>
         <table border width="50%">
            <tr> <td>Nom equipe</td>
                 <td>Nom adversaire</td>
                 <td>Date Match</td>
                 <% List <Matchs> lesMatchs = AfficherMatch;
                 for(Matchs ma : lesMatchs ){%>
            <tr> <td Width=15%><%=ma.getEquipeUn()%></td>
                 <td Width=15%><%=ma.getEquipeDeux()%></td>
                 <td Width=15%><%=ma.getDateMatch()%></td>
            </tr><%}%>
        </table></hr>
    </body>
</html>