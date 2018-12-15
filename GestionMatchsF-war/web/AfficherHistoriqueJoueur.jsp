<%-- 
    Document   : AfficherHistoriqueJoueur
    Created on : Dec 11, 2018, 2:07:38 PM
    Author     : domitille
--%>
 <%@page import="java.util.List"%>
<%@page import="entites.HistoriqueJoueur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <link href="${pageContext.request.contextPath}/cssMenuTous.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeHJ" scope="request" class="List <HistoriqueJoueur>"></jsp:useBean> <%-- attention aux noms + Dans scope ça devient Session--%>
         <title>JSP Page</title>
    </head>
    <body>
        <div id="entete">Historique pour un joueur</div>
        
        <table>
           </tr>   
            <th Width =15%>Nom de l'équipe</th>
            <th Width =15%>Date de début</th>
            <th Width =15%>Date de fin</th>
         </tr> 
       <%  
           for(HistoriqueJoueur hj : listeHJ){%> <%--tu parcours la liste--%>
        
           
    </tr>   
            <td ><%= hj.getEquipeJoueur().getNomequipe() %></td>
            <td ><%=hj.getDateDebutEq() %></td>
            <td><%=hj.getDateFinEq() %></td>
         </tr> <%}%></table>
        <td>
            </br>
            <TABLE>
                  <tr>
                    <a href="MenuTous.jsp"  class="bouton1"> Retour Menu</a>
                  </tr>
            </TABLE>
     </body>
</html>
