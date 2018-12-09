<%-- Document   : CreerMatch
    Created on : 1 déc. 2018, 18:57:19
    Author     : katia
--%>
<%@page import="entites.Matchs"%>
<%@page import="entites.Arbitre"%>
<%@page import="entites.Equipe"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeMatch" scope="request" class = "java.util.List"> </jsp:useBean>

        <title>Modifier un Match</title>
    </head>
    <body>
        <h1>Modifier un Match</h1>
        <% List<Matchs> lesM = listeMatch;%>
        <form method ="get" action="${pageContext.request.contextPath}/gestionFed">
           
            <fieldset>
                
                
                <br>
                <label for="idM">Equipe Une : <span class="requis"></span></label>
                <select name="idM">
                    <% for (Matchs m : lesM ){%>
                    <option value="<%=m.getId()%>">Date : <%= m.getDateMatch().getDay()  %>/<%= m.getDateMatch().getMonth()%>/<%= m.getDateMatch().getYear() %> Equipes :<%=m.getEquipeUn().getNomequipe()  %> VS <%=m.getEquipeDeux().getNomequipe() %>   </option>
                    <%}%>
                </select> 
            
            <br>
               <br>
               <label for="dateM1">Date du match à changer <span class="requis"></span></label> 
                <input type="date" name="dateM1" value="" size="20" maxlength="20"/>
                <br>
                <label for="heure">Heure du Match<span class="requis"></span></label> 
                <input type ="text" name="heure" value="" size="20" maxlength="30"/>
                <br>
               <br>
            
                <input type ="hidden" name="action" value="ModifierMa">
        
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à 0"/>               
            <%--  <a href ="${pageContext.request.contextPath}/fede/MenuFederation"> Retour Menu </a> --%>

        </form>
    </body>
</html>
