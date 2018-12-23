<%-- 
    Document   : RechercherSupp
    Created on : 17 déc. 2018, 01:33:51
    Author     : katia
--%>

<%@page import="entites.Joueur"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listejoueurs" scope="request" class="java.util.List"></jsp:useBean>
        <title>Joueurs</title>
    </head>
    <body>
       <h1>Rechercher joueur A SUPPRIMER</h1>
    <% List<Joueur> lesJoueurs=listejoueurs; %>
    <form method="get" action="gestionEntraineur">
    <div class="input1">
            </br>   
            <div class ='input2'>
                <label for="Joueurs" class='textinput'>Joueur à supprimer : </label>
                <select name="Joueurs" class = 'custom-dropdown__select custom-dropdown__select--white'>
                    <% for(Joueur j:lesJoueurs) {%>
                    <option value="<%=j.getId()%>"><%=j.getPrenomPersonne()%> <%=j.getNomPersonne()%></option>
                    <%}%>
                </select>   
            </div>
    </div>
    <input type ="hidden" name="action" value="SuppJ">

    <input  class='bouton' type="submit" value="Valider"/>
        <input  class='bouton'type="reset" value="Remise à 0"/>       
        </div>
        </br>   
     <div class='retour'>
                <a href ="MenuEntraineur.jsp"> Retour Menu </a>
        </div> 
    </body>

</html>


