<%-- 
    Document   : CreerFRecherche
    Created on : 16 déc. 2018, 07:41:33
    Author     : katia
--%>

<%@page import="java.util.List"%>
<%@page import="entites.Matchs"%>
<%@page import="entites.Matchs"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <jsp:useBean id="listeMatchs" scope="request" class = "java.util.List"> </jsp:useBean>

        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
                <% List<Matchs> leMat = listeMatchs;%>
           <form method ="get" action="gestionArb">  

               
               <label for="Match">Choisir Match: <span class="requis"></span></label>
                <select name="Match">
                    <% for (Matchs m : leMat ){%>
                    <option value="<%=m.getId()%>"><%=m.getEquipeUn().getNomequipe() %> VS <%=m.getEquipeDeux().getNomequipe()%> </option>
                    <%}%>
                </select> 
               <input type ="hidden" name="action" value="CreerF">
                <%-- retour servlet --%>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à 0"/>               
    </body>
</html>
