 <%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="entites.Equipe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="AfficherClassement" scope="request" class="Collection<Equipe>"></jsp:useBean>
        <title>Afficher le classement des equipes</title>
    </head>
    <body>
        <h1>Afficher le classement des équipes</h1>       
    
   <% int i =0 ;%>
        <div style="overflow-x:auto;">
        <table>
                <tr>
                    <td>Classement </td>
                    <td>Nom de l'équipe</td>
                    <td>Points </td>
                </tr>  
                <tr><% Collection<Equipe> lesEquipes = AfficherClassement;
                for(Equipe eq : lesEquipes){%>    <% i++;%>
                    <td> <%=i%>     
                    <td><%=eq.getNomequipe() %></td>
                    <td ><%=eq.getPointEquipe() %></td>
                </tr><%}%>
        </table>
        
        </div>
        <div class ='retour'>
            <a href="MenuTous.jsp"  class="bouton1"> Retour Menu</a>
        </div>
     </body>
    </body>
</html>