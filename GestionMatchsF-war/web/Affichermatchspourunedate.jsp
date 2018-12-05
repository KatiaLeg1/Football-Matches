<%-- 
    Document   : Affichermatchspourunedate
    Created on : Dec 4, 2018, 9:23:35 AM
    Author     : domitille
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeequipe" scope="request" class = "java.util.List"> </jsp:useBean>
        <jsp:useBean id="listematch" scope="request" class = "java.util.List"> </jsp:useBean>
        <title>Afficher les matchs à une date donnée</title>
    </head>
    <body>
        <h1>Afficher les matchs à une date donnée</h1>
        <p>
            <a href ="MenuTous.jsp">Menu tous</a>
        </p>
    </body>
</html>
