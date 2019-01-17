<%-- 
    Document   : RechercheMAffJ
    Created on : 23 déc. 2018, 20:05:43
    Author     : katia
--%>

<%@page import="entites.HistoriqueJoueur"%>
<%@page import="java.util.List"%>
<%@page import="entites.Matchs"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <jsp:useBean id="listm" scope="request" class = "java.util.List"> </jsp:useBean>
     <jsp:useBean id="listehe" scope="request" class = "java.util.List"> </jsp:useBean>
        <title>Modifier un Match</title>
    </head>
    <body>
        <h1>Composition de l'équipe</h1>
        <% List<Matchs> leMat = listm;
        List <HistoriqueJoueur> He = listehe;%>
        <form method ="get" action="gestionEntraineur">  
           <div class="input1">
            </br>   
            <div class ='input2'>
            <label for="Match" class='textinput'>Choisir Match:</label>
                <select name="Match" class='custom-dropdown__select custom-dropdown__select--white'>
                    <% for (Matchs m : leMat ){%>
                    <option value="<%=m.getId()%>"><%=m.getEquipeUn().getNomequipe() %> VS <%=m.getEquipeDeux().getNomequipe()%>
                    </option>
                    <%}%>
                </select> 
            </div>
                </br>
                <div claqq='input2'>
            <label for="compo" class='textinput'> Composition de l'équipe :</label>
            <div style="overflow-x:auto;">
            <table>
                <tr>
                    <td> Nom </td>
                    <td> Prénom </td>
                    <td> Ajouter </td>                        
                </tr>
                <% for (HistoriqueJoueur h : He ) { %>
                <tr>
                    <td>  <%= h.getJoueur().getNomPersonne()%> </td>
                    <td>  <%= h.getJoueur().getPrenomPersonne()%></td>
                    <td> <input type="checkbox" name="compo" value="<%= h.getJoueur().getId()%>" </td>                        
                </tr>
                <%}%>
            </table>
            </div>
                </div> 
            </div>
           
            <input type ="hidden" name="action" value="affJMatch">            
            
            </br>
                <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Remise à 0"/>       
            </div>      <br>
           
            <div class='retour'>
           
              <a href ="MenuEntraineur.jsp"> Retour Menu </a>
            </div>
        </form>
    </body>
</html>
