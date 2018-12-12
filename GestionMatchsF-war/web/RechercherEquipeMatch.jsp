<%-- 
    Document   : RechercherEquipeMatch
    Created on : Dec 11, 2018, 5:04:10 PM
    Author     : domitille
--%>
 <%@page import="java.util.Collection"%>
<%@page import="entites.Equipe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="lesEquipes" scope="request" class = "java.util.List"> </jsp:useBean> <%--attention au nom--%>
         <title>JSP Page</title>
    </head>
     <body>
        <h1>Rechercher une équipe</h1>
                <form method ="get" action="GestionTous">  
         
                <% Collection<Equipe> lesEq = lesEquipes;%>
                
                 <fieldset>
                <label for="eq">Equipe : <span class="requis"></span></label>
                <select name="eq">
                    <% for (Equipe e : lesEq ){%>
                    <option value="<%=e.getId()%>"><%=e.getNomequipe() %></option><%-- je récupère l'id, j'affiche le nom d'équipe --%>
                    <%}%><%-- le premier value est ce que tu récupères les 2 autres ce que tu affiches --%>
                </select> 
                
                
                <input type ="hidden" name="action" value="AfficherEqM"> ><%-- action que tu renvoies à la JSP --%>
        
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à 0"/>     <br>
            <a href ="MenuFederation.jsp"> Retour Menu </a>
    </body>
</html>