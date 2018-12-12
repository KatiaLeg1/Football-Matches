<%-- 
    Document   : AfficherMatchs
    Created on : 11 déc. 2018, 23:27:51
    Author     : katia
--%>

<%@page import="entites.Matchs"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="entites.Faute"%>
<link href="${pageContext.request.contextPath}/fede/cssfede.css" rel="stylesheet" type="text/css">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeMaa" scope="request" class="List<Matchs>"></jsp:useBean>
        <title>Liste Matchs pour une date</title>
    </head>
    <body>
        <h1>Liste fautes pour une date</h1>
                <div style="overflow-x:auto;">

        <table>
             <tr>   

                 <td Width =15%>date</td>
                 <td Width =15%>heure</td>
                 <td Width =15%>Equipe 1</td>
                 <td Width =15%>Equipe 2</td>
             </tr>
         <% for(Matchs m : listeMaa){%>
         <tr>   
            <td Width =15%><%=m.getDateMatch().getDate() %>/<%=m.getDateMatch().getMonth() %>/<%=m.getDateMatch().getYear()%></td>
            <td Width =15%><%=m.getHeure() %></td>
            <td Width =15%><%=m.getEquipeUn().getNomequipe() %></td>
            <td Width =15%><%=m.getEquipeDeux().getNomequipe()%></td>
        </tr><%}%> </table>
            
</div>
        </br>
        </br>
        <div class='retour'>
        </div>

    </body>
</html>

