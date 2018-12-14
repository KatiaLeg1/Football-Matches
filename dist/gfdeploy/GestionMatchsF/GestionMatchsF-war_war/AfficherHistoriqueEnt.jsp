<%-- 
    Document   : AfficherHistoriqueEnt
    Created on : 9 déc. 2018, 17:43:33
    Author     : katia
--%>

<%@page import="entites.HistoriqueEntraineur"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <link href="${pageContext.request.contextPath}/cssMenuTous.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <jsp:useBean id="listeHE" scope="request" class="Collection<HistoriqueEntraineur>"></jsp:useBean> 
 <title>Historique pour 1 entraineur</title>
    </head>
    <body>
        <div id="entete">Historique de l'entraineur</div>
            <tr>
                <div class="input1"> 
                    <table>
                        <td Width =15%>Nom equipe</td>
                        <td Width =15%>Date début</td>
                        <td Width =15%>Date fin</td>
            </tr> 
            <%for(HistoriqueEntraineur he : listeHE){%>
            </tr>   
                        <td ><%= he.getEquipeEntraineur().getNomequipe() %></td>
                        <td ><%=he.getDateDebutEnt() %></td>
                        <td><%=he.getDateFinEnt() %></td>

            </tr> <%}%>
                    </table>
                </div>
                           <td>
                            </br>
                     <TABLE>
            <tr>
                 <a href="MenuTous.jsp"  class="bouton1"> Retour Menu</a>
            </tr>
                    </TABLE>
    </body>
</html>

