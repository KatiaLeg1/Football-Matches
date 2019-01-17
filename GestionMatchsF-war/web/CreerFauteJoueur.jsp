<%-- 
    Document   : CreerFauteJoueur
    Created on : 4 déc. 2018, 11:12:46
    Author     : Sophie
--%>

<%@page import="entites.Arbitre"%>
<%@page import="entites.Equipe"%>
<%@page import="entites.Faute"%>
<%@page import="entites.Matchs"%>
<%@page import="entites.Joueur"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeJoueurs" scope="request" class = "java.util.List"> </jsp:useBean> 
        <jsp:useBean id="match" scope="request" class = "Matchs"> </jsp:useBean> 

        <title>Créer un faute</title>
    </head>
    <body>
        <h1>Créer une faute : </h1>
        
        <% List<Joueur> LesJoue = listeJoueurs;%>
        <form method ="get" action="gestionArb">  
        <div class="input1">
        </br> 
        
        <input type='hidden' name='ma' value='<%=match.getId()%>'/>
        <div class ='input2'>             

                <label for="nomPersonne" class='textinput'> Selectionner un Joueur : </label>
                <select name="nomPersonne"  class='custom-dropdown__select custom-dropdown__select--white'>
                    <% for (Joueur j : LesJoue ){%>
                    <option value="<%=j.getId()%>"><%=j.getNomPersonne()%><%=j.getPrenomPersonne()%>  </option>
                    <%}%>
                </select> 
            <br>
            <br>
                
            <label for="nomPersonne" class='textinput'>Type de carton:</label>
                <SELECT name="type" class='custom-dropdown__select custom-dropdown__select--white'>
                    <option value="Rouge"> Rouge </option>
                    <option value="Jaune"> Jaune </option>
                </select>
        </div>
        </div>
                </br>
                
            
                <input type ="hidden" name="action" value="CreerFauteJoueur">
        <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Remise à 0"/>       
        </div>
                </br>
        <div class='retour'>
            <a href ="/MenuArbitre.jsp"> Retour Menu </a>
            </div>       
            </form>      
        </form>
    </body>
</html>

