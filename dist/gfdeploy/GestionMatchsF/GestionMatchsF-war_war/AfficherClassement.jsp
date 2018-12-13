 <%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="entites.Equipe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <link href="${pageContext.request.contextPath}/cssMenuTous.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="AfficherClassement" scope="request" class="Collection<Equipe>"></jsp:useBean>
        <title>Afficher le classement des equipes</title>
    </head>
    <body>
        <div id="entete">Afficher le classement des equipes</div>
         <p><%
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %>
        </p>
    
        <table>
            <tr>
                <th Width =15%>Nom equipe</th>
                <th Width =15%>Point Equipe</t>
            </tr>  
            <tr>    <% Collection<Equipe> lesEquipes = AfficherClassement;
                 for(Equipe eq : lesEquipes){%>        
                <td><%=eq.getNomequipe() %></td>
                <td ><%=eq.getPointEquipe() %></td>
            </tr><%}%>
        </table>
            </br>
            <TABLE>
                <tr>
                <a href="MenuTous.jsp"  class="bouton1"> Retour Menu</a>
                </tr>
            </TABLE>
     </body>
    </body>
</html>