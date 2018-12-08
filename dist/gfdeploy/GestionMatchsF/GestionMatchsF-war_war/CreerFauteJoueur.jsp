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
        <jsp:useBean id="listeMatchs" scope="request" class = "java.util.List"> </jsp:useBean>
        <jsp:useBean id="listeJoueurs" scope="request" class = "java.util.List"> </jsp:useBean> 
        <%--jsp:useBean id="listeEquipes" scope="request" class = "java.util.List"> </jsp:useBean--%>
        <title>Creer fautes joueurs</title>
    </head>
    <body>
        <h1>Creer fautes joueurs:</h1>
        <% List<Matchs> leMat = listeMatchs;%>
        <% List<Joueur> LesJoue = listeJoueurs;%>
        <%-- List<Equipe> LesEqs = listeEquipes;   plus besoin --%>
        <%-- <form method ="get" action="gestionFed">  ici ta servlet pas le bon nom --%>
        <form method ="get" action="gestionArb">  

            <fieldset>
             <%--   <label for="">Date du match<span class="requis">*</span></label> 
                <input type="date" name="dateMatch" value="" size="20" maxlength="20"/>
             plus besoin --%>
            <br>
              
                <label for="nomPersonne"> Selectionner Joueur : <span class="requis"></span></label>
                <select name="nomPersonne">
                 <%--   <% for (Joueur j : LesJoue ){%>
                    <option value="<%=j.getNomPersonne()%>"><%=j.getNomPersonne()%><%=j.getPrenomPersonne()%>  </option>
                    <%}%>
                 dans option = c'est la ou tu récupère le champs, donc tu peux mettre ID (dans ta première fonction tu avais mis nom + prénom, le prénom manquait
                 la deuxième partie par contre tu peux afficher Nom et prénom

                 On va récupérer id :(plus simple :) )
                 --%>
                    <% for (Joueur j : LesJoue ){%>
                    <option value="<%=j.getId()%>"><%=j.getNomPersonne()%><%=j.getPrenomPersonne()%>  </option>
                    <%}%>
                </select> 
            <br>
              
               
            <br>
        <%-- pareil que avant pour ici on va récupérer ID, ça évite énormément d'erreur, 
        Et je crois qu'on peut pas afficher 2 fois la même liste
<label for="n">Match: Equipe 1: <span class="requis"></span></label>
                <select name="Match">
                    <% for (Matchs m : leMat ){%>
                    <option value="<%=m.getEquipeUn()%>"><%=m.getEquipeUn()%> </option>
                    <%}%>
                </select> 
             <br>
               <label for="n">Match: Equipe 2: <span class="requis"></span></label>
                <select name="Match">
                    <% for (Matchs m : leMat ){%>
                    <option value="<%=m.getEquipeDeux()%>"><%=m.getEquipeDeux()%> </option>
                    <%}%>
                </select> 
        --%>
            <label for="Match">Choisir Match: <span class="requis"></span></label>
                <select name="Match">
                    <% for (Matchs m : leMat ){%>
                    <option value="<%=m.getId()%>"><%=m.getEquipeUn().getNomequipe() %> VS <%=m.getEquipeDeux().getNomequipe()%> </option>
                    <%}%>
                </select> 
<%-- 
                <input type ="hidden" name="action" value="CreerFauteJoueur"> --> Tu dois récuperer qu'à la fin 
                --%> 
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

