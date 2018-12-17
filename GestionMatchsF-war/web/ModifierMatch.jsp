<%-- Document   : ModifierMatch
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
        <jsp:useBean id="listeMatchs" scope="request" class = "java.util.List"> </jsp:useBean>
        <title>Modifier un Match</title>
    </head>
    <body>
        <h1>Modifier un Match</h1>
        <% List<Matchs> leMat = listeMatchs;%>
        <form method ="get" action="gestionArb">  
           
            <label for="Match">Choisir Match: <span class="requis"></span></label>
                <select name="Match">
                    <% for (Matchs m : leMat ){%>
                    <option value="<%=m.getId()%>"><%=m.getEquipeUn().getNomequipe() %> VS <%=m.getEquipeDeux().getNomequipe()%> </option>
                    <%}%>
                </select> 
            
                <label for="pteq1">Point équipe 1<span class="requis"></span></label> 
                <input type="text" name="pteq1" value="" size="20" maxlength="20"/>
                <br>
                 <label for="pteq2">Point équipe 2<span class="requis"></span></label> 
                <input type="text" name="pteq2" value="" size="20" maxlength="20"/>
                <br>
                
                <input type ="hidden" name="action" value="ModifierMa">
        
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à 0"/>               
        </form>
    </body>
</html>
