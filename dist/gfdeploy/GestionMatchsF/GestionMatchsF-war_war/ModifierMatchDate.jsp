<%-- Document   : CreerMatch
    Created on : 1 déc. 2018, 18:57:19
    Author     : katia
--%>
<%@page import="entites.Arbitre"%>
<%@page import="entites.Equipe"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeEquipes" scope="request" class = "java.util.List"> </jsp:useBean>
        <jsp:useBean id="listeEquipess" scope="request" class = "java.util.List"> </jsp:useBean>
        <title>Modifier un Match</title>
    </head>
    <body>
        <h1>Modifier un Match</h1>
        <% List<Equipe> lesEqss = listeEquipess;%>
        <% List<Equipe> lesEqs = listeEquipes;%>
        <form method ="get" action="gestionFed">  
           
            <fieldset>
                <label for="dateMatch">Date du match<span class="requis"></span></label> 
                <input type="date" name="dateMatch" value="" size="20" maxlength="20"/>
                <br>
                <label for="nomEquUn">Equipe Une : <span class="requis"></span></label>
                <select name="nomEquUn">
                    <% for (Equipe e : lesEqs ){%>
                    <option value="<%=e.getNomequipe()%>"><%=e.getNomequipe()%> </option>
                    <%}%>
                </select> 
            
            <br>
               <label for="nomEquDeux">Equipe Deux : <span class="requis"></span></label>
                <select name="nomEquDeux">
                    <% for (Equipe e : lesEqss ){%>
                    <option value="<%=e.getNomequipe()%>"><%=e.getNomequipe()%> </option>
                    <%}%>
                </select> 
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
        </form>
    </body>
</html>
