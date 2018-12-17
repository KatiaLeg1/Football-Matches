<%-- 
    Document   : CreerFauteJoueur
    Created on : 4 déc. 2018, 11:12:46
    Author     : Sophie
--%>

<%@page import="entites.Arbitre"%>
<%@page import="entites.Equipe"%>
<%@page import="entites.Faute"%>
<%@page import="entites.Matchs"%>
<%@page import="entites.Joueur"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeJoueurs" scope="request" class = "java.util.List"> </jsp:useBean> 
        <title>Creer fautes joueurs</title>
    </head>
    <body>
        <h1>Creer fautes joueurs:</h1>
        <% List<Joueur> LesJoue = listeJoueurs;%>
           <form method ="get" action="gestionArb">  

            <fieldset>
             
              
                <label for="nomPersonne"> Selectionner Joueur : <span class="requis"></span></label>
                <select name="nomPersonne">
                 
                    <% for (Joueur j : LesJoue ){%>
                    <option value="<%=j.getId()%>"><%=j.getNomPersonne()%><%=j.getPrenomPersonne()%>  </option>
                    <%}%>
                </select> 
            <br>
              
               
            <br>
                
                <tr><td> Type de carton:</td><td><SELECT size="1" name="type">
                            <option value="Rouge"> Rouge </option>
                            <option value="Jaune"> Jaune </option>
                        </select></td></tr>
            
                <input type ="hidden" name="action" value="CreerFauteJoueur">
                <%-- retour servlet --%>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à 0"/>               
        </form>
    </body>
</html>

