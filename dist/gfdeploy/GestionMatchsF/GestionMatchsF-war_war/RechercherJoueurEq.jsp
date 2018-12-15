<%-- 
    Document   : RechercherJoueurEq
    Created on : Dec 11, 2018, 2:00:47 PM
    Author     : domitille
--%>
 <%@page import="java.util.List"%>
<%@page import="entites.Joueur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <link href="${pageContext.request.contextPath}/cssMenuTous.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <jsp:useBean id="listeJou" scope="request" class = "java.util.List"> </jsp:useBean> 
         <title>Choisir le joueur pour afficher historique de ses equipes</title>
    </head>
    <body>
        <div id="entete">Choisir le joueur pour afficher l'historique de ses équipes</div>
                <form method ="get" action="GestionTous">  
         
                <% List<Joueur> lesJou = listeJou;%>
                
                 <div class="input1">
            </br>   
            <div class ='input2'>
                <label for="jou">Joueur : <span class="requis"></span></label>
                <select name="jou">
                    <% for (Joueur j : lesJou ){%>
                    <option value="<%=j.getId()%>"><%=j.getNomPersonne() %> <%=j.getPrenomPersonne() %> </option>
                    <%}%>
                </select> 
                
                
                <input type ="hidden" name="action" value="HistoJou"> 
        </div></div>
            <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Remise à 0"/>       
            </div>    <br>
            <TABLE>
                  <tr>
                    <a href="MenuTous.jsp"  class="bouton1"> Retour Menu</a>
                  </tr>
            </TABLE>
    </body>
</html>