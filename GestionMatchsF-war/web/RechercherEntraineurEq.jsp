<%-- 
    Document   : RechercherEntraineurEq
    Created on : 9 déc. 2018, 17:39:39
    Author     : katia
--%>

<%@page import="entites.Entraineur"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeEnt" scope="request" class = "java.util.List"> </jsp:useBean>
        
        <title>Choisir l'entraineur pour afficher Historique de ses eq</title>
    </head>
    <body>
        <h1>Choisir l'entraineur pour afficher l'historique de ses équipes</h1>
            <form method ="get" action="GestionTous">                  
            <% List<Entraineur> lesEnt = listeEnt;%>

            <div class="input1">
            </br>   
            <div class ='input2'>
                <label for="ent" class='textinput'>Entraineur  : <span class="requis"></span></label>
                <select name="ent" class='custom-dropdown__select custom-dropdown__select--white' >
                    <% for (Entraineur e : lesEnt ){%>
                    <option value="<%=e.getId()%>"><%=e.getNomPersonne() %> <%=e.getPrenomPersonne() %> </option>
                    <%}%><%-- le premier value est ce que tu récupères les 2 autres ce que tu affiches --%>
                </select> 
                
                </br>
                <input type ="hidden" name="action" value="HistoEnt"> 
         </div></div>
            <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Remise à 0"/>       
            </div>
                </br>
           
                    <a href="MenuTous.jsp"  class="bouton1"> Retour Menu</a>
            
    </body>
</html>
