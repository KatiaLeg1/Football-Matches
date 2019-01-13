<%-- 
    Document   : AfficherHistoriqueEnt
    Created on : 9 déc. 2018, 17:43:33
    Author     : katia
--%>

<%@page import="entites.HistoriqueEntraineur"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <jsp:useBean id="listeHE" scope="request" class="Collection<HistoriqueEntraineur>"></jsp:useBean> 
 <title>Historique de l'entraineur</title>
    </head>
    <body>
        <h1>Historique de l'entraineur</h1>
        <div style="overflow-x:auto;">
            <table>
            <tr>
                <td>Nom de l'équipe</td>
                <td>Date de début</td>
                <td>Date de fin</td>
            </tr> 
            <%for(HistoriqueEntraineur he : listeHE){%>
            </tr>   
                <td ><%= he.getEquipeEntraineur().getNomequipe() %></td>
               <td ><%=he.getDateDebutEnt().getDate()%> / <%= he.getDateDebutEnt().getMonth()+1 %> / <%= he.getDateDebutEnt().getYear()+1900 %></td>
                 <td><% if(he.getDateFinEnt()==null){%> <%} 
                else {%><%=he.getDateFinEnt().getDate()%> / <%= he.getDateFinEnt().getMonth()+1 %> / <%= he.getDateFinEnt().getYear() + 1900 %> <%} %>
            </tr> <%}%>
            </table>
        </div>
            </br>            
        <div class='retour'>
            <a href ="MenuTous.jsp"> Retour Menu </a>
        </div>
    </body>
</html>

