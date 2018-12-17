<%-- 
    Document   : RechercherSupp
    Created on : 17 déc. 2018, 01:33:51
    Author     : katia
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
       <h1>Rechercher joueur A SUPPRIMER</h1>
    <% List<Joueur> lesJoueurs=listejoueurs; %>
    <form method="get" action="gestionEntraineur">
    <div>
    <fieldset>
        <select name="Joueurs">
            <% for(Joueur j:lesJoueurs) {%>
            <option value="<%=j.getId()%>"><%=j.getPrenomPersonne()%> <%=j.getNomPersonne()%></option>
            <%}%>
        </select>   
        <br/>

        <input type ="hidden" name="action" value="SuppJ">

           </fieldset>
        <br/>
         <input type="submit" value="Valider">
     </div>
        </form>
    </body>

</html>


