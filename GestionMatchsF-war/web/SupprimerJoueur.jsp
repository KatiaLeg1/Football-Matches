<%-- 
    Document   : SupprimerJoueur
    Created on : 27 déc. 2018, 11:02:50
    Author     : Utilisateur
--%>

<%@page import="entites.HistoriqueJoueur"%>
<%@page import="java.util.List"%>
<%@page import="entites.Joueur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recherche d'un joueur</title>
        <jsp:useBean id="listejoueurs" scope="request" class="java.util.List"></jsp:useBean>
    </head>
    <body>
    <h1>Supprimer un joueur </h1>
<% List <HistoriqueJoueur> lesJoueurs = listejoueurs;%>  
<form method="get" action="gestionEntraineur">
        <div class="input1">
            </br>   
            <div class ='input2'>     
                <label for="Joueurs"  class='textinput'> Joueur à supprimer : </label>                
                <select name="Joueurs"  class='custom-dropdown__select custom-dropdown__select--white'>
                    <%  for(HistoriqueJoueur j : lesJoueurs){%>
                    <option value="<%=j.getJoueur().getId() %>"><%=j.getJoueur().getPrenomPersonne() %> <%=j.getJoueur().getNomPersonne()%></option>
                    <%}%>
                </select>   
            </br>
            </div>
            <input type ="hidden" name="action" value="supprimerJ"/>
        <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>   
        </div>
        </br>    
        <div class='retour'>
            <a href ="${pageContext.request.contextPath}/MenuEntraineur.jsp"> Retour Menu </a>
            </div>  
    </form>
    </body>
</html>
