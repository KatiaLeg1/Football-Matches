<%-- 
    Document   : AfficherFautesJoueur
    Created on : 9 déc. 2018, 03:29:27
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
        <jsp:useBean id="listeF" scope="session" class="Collection<Faute>"></jsp:useBean>
        <title>Liste fautes pour un joueur</title>
    </head>
    <body>
        <h1>Liste fautes pour un joueur</h1>
        
        <table>
                </tr>   
            <td Width =15%>date du match</td>
            <td Width =15%>Heure du match </td>
            <td Width =15%>Type de faute</td>

        </tr> 
       <%  
           for(Faute f : listeF){%>
        
           
    </tr>   
            <td Width =15%><%=f.getMatch().getDateMatch() %></td>
            <td Width =15%><%=f.getMatch().getHeure() %></td>
            <td Width =15%><%=f.getTypeFaute()%></td>

        </tr> </table><%}%>
        <td>
            </br>
            <TABLE><tr>
                <a href="gestionFed?action=vide"> Retour Menu</a></tr>
            </TABLE>

    </body>
</html>
