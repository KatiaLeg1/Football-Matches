<%-- 
    Document   : AfficherHistoriqueJoueur
    Created on : Dec 11, 2018, 2:07:38 PM
    Author     : domitille
--%>
 <%@page import="java.util.List"%>
<%@page import="entites.HistoriqueJoueur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeHJ" scope="request" class="List <HistoriqueJoueur>"></jsp:useBean> <%-- attention aux noms + Dans scope ça devient Session--%>
         <title>JSP Page</title>
    </head>
    <body>
        <h1>Historique pour 1 joueur</h1>
        
        <table>
           </tr>   
                <%-- en tête de tes colonnes --%>
            <td Width =15%>Nom equipe</td>
            <td Width =15%>Date début</td>
            <td Width =15%>Date fin</td>
         </tr> 
       <%  
           for(HistoriqueJoueur hj : listeHJ){%> <%--tu parcours la liste--%>
        
           
    </tr>   
            <td ><%= hj.getEquipeJoueur().getNomequipe() %></td>
            <td ><%=hj.getDateDebutEq() %></td>
            <td><%=hj.getDateFinEq() %></td>
         </tr> </table><%}%>
        <td>
            </br>
            <TABLE><tr>
                <a href="MenuTous.jsp"> Retour Menu</a></tr>
            </TABLE>
     </body>
</html>
