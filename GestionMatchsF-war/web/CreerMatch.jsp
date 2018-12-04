<%-- 
    Document   : CreerMatch
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
        <jsp:useBean id="listeArbitres" scope="request" class = "java.util.List"> </jsp:useBean> 
        <title>Creer un Match</title>
    </head>
    <body>
        <h1>Creer un Match</h1>
        <% List<Equipe> lesEqs = listeEquipes;%>
        <% List<Arbitre> LesArbs = listeArbitres;%>
        <form method ="get" action="gestionFed">  
           
            <fieldset>
                <label for="dateMatch">Date du match<span class="requis">*</span></label> 
                <input type="date" name="dateMatch" value="" size="20" maxlength="20"/>
            <br>
                <label for="heure">Heure du Match<span class="requis"></span></label> 
                <input type ="text" name="heure" value="" size="20" maxlength="30"/>
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
                    <% for (Equipe e : lesEqs ){%>
                    <option value="<%=e.getNomequipe()%>"><%=e.getNomequipe()%> </option>
                    <%}%>
                </select> 
               <br>
               <label for="nomA">Equipe 1<span class="requis">*</span></label>
               <select name="idA">
                   <% for (Arbitre a : LesArbs){%>
                   <option value="<%=a.getId()%>"><%=a.getNomPersonne()%> <%=a.getPrenomPersonne()%></option>
                   <%}%>
               </select> 
               <br>
            
                <input type ="hidden" name="action" value="CreerM">
        
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à 0"/>               
        </form>
    </body>
</html>
