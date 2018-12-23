<%-- 
    Document   : AfficherUnFournisseur
    Created on : 20 nov. 2017, 10:17:40
    Author     : guilaine.talens
--%>
 <%@page import="entites.Joueur"%>
<%@page import="java.util.List"%>
<%@page import="entites.Matchs"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="match" scope="request" class="Matchs"></jsp:useBean>
         <title>Un Match</title>
    </head>
    <body>
        <h1>Afficher Fournisseur</h1>
	        <div style="overflow-x:auto;">
                <table>
		<tr> 
			<td Width=15%><%=match.getId()%></td>
			<td Width=30%><%=match.getDateMatch()%></td>
			<td Width=15%><%=match.getHeure()%></td>		
			<td Width=15%><%=match.getEquipeUn().getNomequipe()%></td>
                        <td Width=15%><%=match.getEquipeDeux().getNomequipe()%></td>
		</tr>
                 <%  List<Joueur> lesJ=match.getComposition1();
	for(Joueur cp : lesJ){%>
		<tr> 
			<td Width=15%><%=cp.getId()%></td>
			<td Width=30%><%=cp.getNomPersonne()%></td>
			<td Width=15%><%=cp.getPrenomPersonne()%></td>		
			
                        </br>
		</tr><%}%>
        <hr>
        <%  List<Joueur> lesJ2=match.getComposition2();
	for(Joueur cp : lesJ2){%>
		<tr> 
			<td Width=15%><%=cp.getId()%></td>
			<td Width=30%><%=cp.getNomPersonne()%></td>
			<td Width=15%><%=cp.getPrenomPersonne()%></td>		
			
                        </br>
		</tr><%}%>
                </table>
        <div class ='retour'>
            <a href="MenuTous.jsp"  class="bouton1"> Retour Menu</a>
        </div>
	
</tr></TABLE>
    </body>
</html>