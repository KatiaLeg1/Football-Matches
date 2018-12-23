<%-- 
    Document   : CreerFRecherche
    Created on : 16 déc. 2018, 07:41:33
    Author     : katia
--%>

<%@page import="java.util.List"%>
<%@page import="entites.Matchs"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <jsp:useBean id="listeMatchs" scope="request" class = "java.util.List"> </jsp:useBean>

        <title>créer Faute</title>
    </head>
    <body>
        <h1>Sélectionner le match</h1>
                <% List<Matchs> leMat = listeMatchs;%>
           <form method ="get" action="gestionArb">  
<div class="input1">
            </br>   
            <div class ='input2'>
               
               <label for="Match" class='input1' >Choisir Match: <span class="requis"></span></label>
                <select name="Match" class='custom-dropdown__select custom-dropdown__select--white'>
                    <% for (Matchs m : leMat ){%>
                    <option value="<%=m.getId()%>"><%=m.getEquipeUn().getNomequipe() %> VS <%=m.getEquipeDeux().getNomequipe()%> </option>
                    <%}%>
                </select> 
               <input type ="hidden" name="action" value="CreerF">
            </div>
</div>
              
        <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Remise à 0"/>       
        </div>
        <div class='retour'>
            <a href ="/MenuArbitre.jsp"> Retour Menu </a>
            </div>                    
    </body>
</html>
