
 <%@page import="entites.Joueur"%>
<%@page import="java.util.List"%>
<%@page import="entites.Matchs"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="match" scope="request" class="Matchs"></jsp:useBean>
         <title>Un Match</title>
    </head>
    <body>
        <h1>	Afficher la liste des joueurs pour un match </h1>
            <div style="overflow-x:auto;">

                 <div class="input1">
                     <div class='textinput'>Match  le <%=match.getDateMatch().getDate() %> / <%= match.getDateMatch().getMonth()%> <%= match.getDateMatch().getYear()%>
            <%=match.getEquipeUn().getNomequipe()%> VS <%=match.getEquipeDeux().getNomequipe()%>
            </div>
            </br></br>
            <div style="overflow-x:auto;">
             <%  List<Joueur> lesJ = match.getComposition1();
            for(Joueur cp : lesJ){%>
            <table>
                <tr>
                    <td> ID joueur</td>
                    <td> Nom joueur</td>
                    <td> Prénom joueur</td>
                </tr>
                <tr> 
                    <td><%=cp.getId()%></td>
                    <td><%=cp.getNomPersonne()%></td>
                    <td><%=cp.getPrenomPersonne()%></td>		
                </tr><%}%>
            </table>
            </br></br>
            <table>
            <div style="overflow-x:auto;">                
            <%  List<Joueur> lesJ2=match.getComposition2();
            for(Joueur cp : lesJ2){%>
            <table>
                <tr>
                    <td> ID joueur</td>
                    <td> Nom joueur</td>
                    <td> Prénom joueur</td>
                </tr>
                <tr> 
                    <td><%=cp.getId()%></td>
                    <td><%=cp.getNomPersonne()%></td>
                    <td><%=cp.getPrenomPersonne()%></td>		
		</tr><%}%>
            </table>
        <div class ='retour'>
            <a href="MenuTous.jsp"  class="bouton1"> Retour Menu</a>
        </div>
    </body>
</html>