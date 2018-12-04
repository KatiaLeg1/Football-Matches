<%-- 
    Document   : AffecterEntraineur
    Created on : 4 déc. 2018, 21:20:53
    Author     : katia
--%>

<%@page import="entites.Entraineur"%>
<%@page import="java.util.List"%>
<%@page import="entites.Equipe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeEquipes" scope="request" class = "java.util.List"> </jsp:useBean>
        <jsp:useBean id="listeEquipent" scope="request" class = "java.util.List"> </jsp:useBean>

        <title>Affecter Un Entraineur</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% List<Entraineur> lesEnts = listeEquipent;%>
        <% List<Equipe> lesEqs = listeEquipes;%>
        
    <form method ="get" action="gestionFed">  
        <fieldset>
                <label for="dateDebut">Date début afectation<span class="requis">*</span></label> 
                <input type="date" name="dateDebut" value="" size="20" maxlength="20"/>
            <br>
                
                <label for="ent">Entraineur : <span class="requis"></span></label>
                <select name="ent">
                    <% for (Entraineur ent : lesEnts ){%>
                    <option value="<%=ent.getId()%>"><%=ent.getNomPersonne()%><%=ent.getPrenomPersonne()%> </option>
                    <%}%>
                </select> 
            
            <br>
               <label for="equipe">Equipe : <span class="requis"></span></label>
                <select name="equipe">
                    <% for (Equipe e : lesEqs ){%>
                    <option value="<%=e.getNomequipe()%>"><%=e.getNomequipe()%> </option>
                    <%}%>
                </select> 
               <br>
               
               <br>
            
                <input type ="hidden" name="action" value="AffEnt">
        
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à 0"/>     <br>
            <a href ="MenuFederation.jsp"> Retour Menu </a>

        </form>
    </body>
</html>