<%-- 
    Document   : AfficherMatchs
    Created on : 11 déc. 2018, 23:27:51
    Author     : katia
--%>

<%@page import="entites.Matchs"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="entites.Faute"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <link href="${pageContext.request.contextPath}/cssMenuTous.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeMaa" scope="request" class="List<Matchs>"></jsp:useBean>
        <title>Liste des matchs pour une date</title>
    </head>
    <body>
        <div id="entete">Liste des matchs pour une date</div>
                <div style="overflow-x:auto;">

        <table>
             <tr>   

                 <th Width =15%>Date du match</th>
                 <th Width =15%>Heure</th>
                 <th Width =15%>Equipe 1</th>
                 <th Width =15%>Equipe 2</th>
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
           <TABLE>
            <tr>
                 <a href="MenuTous.jsp"  class="bouton1"> Retour Menu</a>
            </tr>
                    </TABLE>

    </body>
</html>

