<%-- 
    Document   : Afficherdatesetequipes
    Created on : Dec 4, 2018, 12:58:16 PM
    Author     : domitille
--%>

<%@page import="entites.Match"%>
<%@page import="entites.Equipe"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeequipe" scope="request" class = "java.util.List"> </jsp:useBean>
        <jsp:useBean id="listematch" scope="request" class = "java.util.List"> </jsp:useBean>
        <title>JSP Page</title>
    </head>
    <body>
        <p> <% String attribut = (String) request.getAttribute("message");
        out.println(attribut);
        %> </p>
    <table>
        <tr>
            <td>Type</td></tr>
        <% List<Equipe> le = listeequipe;
         for(Equipe e : le) {%>
         <tr>
             <td>
                 <%=e.getNomequipe()%>
             </td>
         </tr>
         <%}%>
         <tr><td>Type</td></tr>
        <% List<Match> lm = listematch;
         for(Match m : lm) {%>
         <tr>
             <td>
                 <%=m.getMatchs2()%>
             </td>    
              <td>
                 <%=m.getMatchs1()%>
             </td> 
         </tr>
    </table>
    <hr>
    <td> <a href="AccesArticles">Retour Menu</a> </td>
    </body>
</html>
