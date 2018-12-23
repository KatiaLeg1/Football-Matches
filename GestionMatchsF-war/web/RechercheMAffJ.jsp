<%-- 
    Document   : RechercheMAffJ
    Created on : 23 déc. 2018, 20:05:43
    Author     : katia
--%>

<%@page import="entites.HistoriqueJoueur"%>
<%@page import="java.util.List"%>
<%@page import="entites.Matchs"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <jsp:useBean id="listm" scope="request" class = "java.util.List"> </jsp:useBean>
     <jsp:useBean id="listehe" scope="request" class = "java.util.List"> </jsp:useBean>
        <title>Modifier un Match</title>
    </head>
    <body>
        <h1>Modifier un Match</h1>
        <% List<Matchs> leMat = listm;
        List <HistoriqueJoueur> He = listehe;%>
        <form method ="get" action="gestionEntraineur">  
           
            <label for="Match">Choisir Match: <span class="requis"></span></label>
                <select name="Match">
                    <% for (Matchs m : leMat ){%>
                    <option value="<%=m.getId()%>"><%=m.getEquipeUn().getNomequipe() %> VS <%=m.getEquipeDeux().getNomequipe()%> </option>
                    <%}%>
                </select> 
            <label for="compo">Composition de l'équipe :</label>
            <table>
                <tr>
                    <td> Joueur numéro </td>
                    <td> Nom </td>
                    <td> prénom</td>
                    <td> check </td>                        
                </tr>
                <% for (HistoriqueJoueur h : He ) { %>
                <tr>
                    <td> <%= h.getJoueur().getId()%> </td>
                    <td>  <%= h.getJoueur().getNomPersonne()%> </td>
                    <td>  <%= h.getJoueur().getPrenomPersonne()%></td>
                    <td> <input type="checkbox" name="compo" value="<%= h.getJoueur().getId()%>" </td>                        
                </tr>
                <%}%>
            </table>
             
                <input type ="hidden" name="action" value="affJMatch">
        
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à 0"/>               
        </form>
    </body>
</html>
