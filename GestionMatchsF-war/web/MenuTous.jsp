%-- 
    Document   : MenuTous
    Created on : Dec 4, 2018, 12:38:08 PM
    Author     : domitille
--%>
 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu pour tous</title>
    </head>
    <body>
        <h1>Menu pour tous</h1>
        <p> 
        <% String attribut = (String)request.getAttribute("message");
        out.println(attribut);
        %>
        <a href ="GestionTous?action=Afficherdateequipe">Afficherjoueurspourunmatch</a>
    </body>
</html>