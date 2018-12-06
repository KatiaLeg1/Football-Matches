<%-- 
    Document   : AfficherJoueurs
    Created on : 4 déc. 2018, 15:19:18
    Author     : Utilisateur
--%>

<%@page import="entites.Joueur"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listejoueurs" scope="request" class="java.util.List"></jsp:useBean>
        <title>Joueurs</title>
    </head>
    <body>
        <h1>Afficher joueurs</h1>
        <p><%
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %>
        </p>
        <table border width="50%">
            <tr> <td>Numéro</td>
                 <td>Nom</td>
                 <td>Prénom</td>
                 <% List <Joueur> lesJoueurs = listejoueurs;
                 for(Joueur jo : lesJoueurs){%>
            <tr> <td Width=15%><%=jo.getId()%></td>
                 <td Width=15%><%=jo.getNomPersonne()%></td>
                 <td Width=15%><%=jo.getPrenomPersonne()%></td>
            </tr><%}%>
        </table></hr>
    <td Width=25%><a href="gestionEntraineur?action=vide">Retour Menu</a></td>
    <hr>
    </body>
</html>

