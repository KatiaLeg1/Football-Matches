%-- 
    Document   : AfficherClassement
    Created on : Dec 11, 2018, 3:56:14 PM
    Author     : domitille
--%>
 <%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="entites.Equipe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="AfficherClassement" scope="request" class="Collection<Equipe>"></jsp:useBean> <%-- attention aux noms + Dans scope ça devient Session--%>
         <title>Afficher le classement des equipes</title>
    </head>
    <body>
        <h1>Afficher le classement des equipes</h1>
         <p><%
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %>
        </p>
    
        <table>
                <tr>   
                <%-- en tête de tes colonnes --%>
            <td Width =15%>Nom equipe</td>
            <td Width =15%>Point Equipe</td>
         </tr>  
     <tr>    <% Collection<Equipe> lesEquipes = AfficherClassement;
                 for(Equipe eq : lesEquipes){%>        
           
       
            <td><%=eq.getNomequipe() %></td>
            <td ><%=eq.getPointEquipe() %></td>
         </tr><%}%></table>
        
            </br>
            <TABLE><tr>
                <a href="MenuTous.jsp"> Retour Menu</a></tr>
            </TABLE>
     </body>
    </body>
</html>