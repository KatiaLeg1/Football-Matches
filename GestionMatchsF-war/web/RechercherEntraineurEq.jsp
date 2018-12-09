<%-- 
    Document   : RechercherEntraineurEq
    Created on : 9 déc. 2018, 17:39:39
    Author     : katia
--%>

<%@page import="entites.Entraineur"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeEnt" scope="request" class = "java.util.List"> </jsp:useBean> <%--attention au nom--%>
        
        <title>Choisir l'entraineur pour afficher Historique de ses eq</title>
    </head>
    <body>
        <h1>Choisir l'entraineur pour afficher Historique de ses eq</h1>
                <form method ="get" action="GestionTous">  

        
                <% List<Entraineur> lesEnt = listeEnt;%>
                
                 <fieldset>
                <label for="ent">Entraineur  : <span class="requis"></span></label>
                <select name="ent">
                    <% for (Entraineur e : lesEnt ){%>
                    <option value="<%=e.getId()%>"><%=e.getNomPersonne() %><%=e.getPrenomPersonne() %> </option>
                    <%}%><%-- le premier value est ce que tu récupères les 2 autres ce que tu affiches --%>
                </select> 
                
                
                <input type ="hidden" name="action" value="HistoEnt"> ><%-- action que tu renvoies à la JSP --%>
        
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à 0"/>     <br>
            <a href ="MenuFederation.jsp"> Retour Menu </a>
    </body>
</html>
