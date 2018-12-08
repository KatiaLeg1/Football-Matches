<%-- 
    Document   : AffihcherFautesDate
    Created on : 9 déc. 2018, 02:54:24
    Author     : katia
--%>

<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="entites.Faute"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeFa" scope="session" class="Collection<Faute>"></jsp:useBean>
        <title>Liste fautes pour une date</title>
    </head>
    <body>
        <h1>Liste fautes pour une date</h1>
        
           <table>
                </tr>   
            <td Width =15%>Nom</td>
            <td Width =15%>Prenom</td>
            <td Width =15%>Equipe</td>

        </tr> 
         <% for(Faute f : listeFa){%>
        </tr>   
            <td Width =15%><%=f.getJoueur().getNomPersonne() %></td>
            <td Width =15%><%=f.getJoueur().getPrenomPersonne() %></td>
          <%--  <td Width =15%><%=f.getJoueur().getHistoriqueJoueurs().get(0).getEquipeJoueur().getNomequipe() %></td> --%> 
          <td>equipe</td>

        </tr> </table><%}%>
        <td>
            
            <TABLE><tr>
                <a href="gestionFed?action=vide"> retourMenu</a></tr>
            </TABLE>

    </body>
</html>
