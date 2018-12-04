<%-- 
    Document   : AffecterJoueur
    Created on : 4 déc. 2018, 10:52:10
    Author     : Utilisateur
--%>

<%@page import="entites.Joueur"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recherche d'un joueur</title>
        <jsp:useBean id="listejoueurs" scope="request" class="java.util.List"></jsp:useBean>
    </head>
    <body>
    <h1>Rechercher joueur</h1>
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
        <label for="dateDebutHJ">Date de début du contrat : <span class="requis"></span></label> 
        <input type ="date" name="datedDebutHJ" value="" size="20" maxlength="20"/><br/>
        <label for="nome">Entraineur : <span class="requis"></span></label> 
        <input type ="text" name="nome" value="" size="20" maxlength="20"/><br/>
           </fieldset>
        <br/>
         <input type="hidden" name ="action" value="affecterJ">
         <input type="submit" value="Valider">
     </div>
        </form>
    </body>
</html>
