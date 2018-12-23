<%-- Document   : ModifierMatch
    Created on : 1 déc. 2018, 18:57:19
    Author     : katia
--%>
<%@page import="entites.Matchs"%>
<%@page import="entites.Arbitre"%>
<%@page import="entites.Equipe"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html>

   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeMatchs" scope="request" class = "java.util.List"> </jsp:useBean>
        <title>Modifier un Match</title>
    </head>
    <body>
        <h1>Modifier un Match</h1>
        <% List<Matchs> leMat = listeMatchs;%>
        <form method ="get" action="gestionArb">  
           
            <div class="input1">
            </br>   
            <div class ='input2'>  
            <label for="Match" class='textinput'>Choisir Match : </label>
                <select name="Match" class='custom-dropdown__select custom-dropdown__select--white'>
                    <% for (Matchs m : leMat ){%>
                    <option value="<%=m.getId()%>"><%=m.getEquipeUn().getNomequipe() %> VS <%=m.getEquipeDeux().getNomequipe()%> </option>
                    <%}%>
                </select> 
            </div>
            <div class ='input2'>  
                <label for="pteq1">Point équipe 1</label> 
                <input type="text" placeholder='Point équipe 1' name="pteq1" class='input'/>
            </div>
            <div class ='input2'>                   
                <label for="pteq2">Point équipe 2</label> 
                <input type="text" placeholder='Point équipe 2' name="pteq2" class='input'/>
                <br>
                
                <input type ="hidden" name="action" value="ModifierMa">
       
                <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Remise à 0"/>       
        </div>
        <div class='retour'>
            <a href ="/MenuArbitre.jsp"> Retour Menu </a>
            </div>              
        </form>
    </body>
</html>
