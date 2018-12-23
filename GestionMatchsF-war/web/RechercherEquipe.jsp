<%-- 
    Document   : RechercherEquipe
    Created on : Dec 11, 2018, 3:18:50 PM
    Author     : domitille
--%>
 <%@page import="java.util.Collection"%>
<%@page import="entites.Equipe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="lesEquipes" scope="request" class = "java.util.List"> </jsp:useBean> <%--attention au nom--%>
         <title>Rechercher une équipe</title>
    </head>
    <body>
        <div id="entete">Rechercher une équipe</div>
                <form method ="get" action="GestionTous"> <% Collection<Equipe> lesEq = lesEquipes;%>
            
            <div class="input1">
            </br>   
            <div class ='input2'>
                     
                <label for="eq" class='textinput'>Equipe : <span class="requis"></span></label>
                <select name="eq" class='custom-dropdown__select custom-dropdown__select--white'>
                    <% for (Equipe e : lesEq ){%>
                        <option value="<%=e.getId()%>"><%=e.getNomequipe() %></option>
                    <%}%>
                </select> 
            <input type ="hidden" name="action" value="AfficherJou"> 
        
            </div></div>
            
           <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Remise à 0"/>       
            </div>      <br>
           
            <a href="MenuTous.jsp"  class="bouton1"> Retour Menu</a>
            
    </body>
</html>