<%-- 
    Document   : AfficherHistoriqueEnt
    Created on : 9 déc. 2018, 17:43:33
    Author     : katia
--%>

<%@page import="entites.HistoriqueEntraineur"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeHE" scope="session" class="Collection<HistoriqueEntraineur>"></jsp:useBean> <%-- attention aux noms + Dans scope ça devient Session--%>
        <title>Historique pour 1 entraineur</title>
    </head>
    <body>
        <h1>Historique pour 1 entraineur</h1>
        
        <table>
                </tr>   
                <%-- en tête de tes colonnes --%>
            <td Width =15%>Nom equipe</td>
            <td Width =15%>Date début</td>
            <td Width =15%>Date fin</td>

        </tr> 
       <%  
           for(HistoriqueEntraineur he : listeHE){%> <%--tu parcours la liste--%>
        
           
    </tr>   
            <td ><%= he.getEquipeEntraineur().getNomequipe() %></td>
            <td ><%=he.getDateDebutEnt() %></td>
            <td><%=he.getDateFinEnt() %></td>

        </tr> </table><%}%>
        <td>
            </br>
            <TABLE><tr>
                <a href="MenuTous.jsp"> Retour Menu</a></tr>
            </TABLE>

    </body>
</html>

