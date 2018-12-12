<%-- 
    Document   : RechercherJoueurEq
    Created on : Dec 11, 2018, 2:00:47 PM
    Author     : domitille
--%>
 <%@page import="java.util.List"%>
<%@page import="entites.Joueur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <jsp:useBean id="listeJou" scope="request" class = "java.util.List"> </jsp:useBean> <%--attention au nom--%>
         <title>Choisir le joueur pour afficher historique de ses equipes</title>
    </head>
    <body>
        <h1>Choisir le joueur pour afficher historique de ses equipes</h1>
                <form method ="get" action="GestionTous">  
         
                <% List<Joueur> lesJou = listeJou;%>
                
                 <fieldset>
                <label for="jou">Joueur : <span class="requis"></span></label>
                <select name="jou">
                    <% for (Joueur j : lesJou ){%>
                    <option value="<%=j.getId()%>"><%=j.getNomPersonne() %><%=j.getPrenomPersonne() %> </option>
                    <%}%><%-- le premier value est ce que tu récupères les 2 autres ce que tu affiches --%>
                </select> 
                
                
                <input type ="hidden" name="action" value="HistoJou"> ><%-- action que tu renvoies à la JSP --%>
        
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à 0"/>     <br>
            <a href ="MenuFederation.jsp"> Retour Menu </a>
    </body>
</html>