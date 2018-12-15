<%-- 
    Document   : RechercherEntraineurEq
    Created on : 9 déc. 2018, 17:39:39
    Author     : katia
--%>

<%@page import="entites.Entraineur"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <link href="${pageContext.request.contextPath}/cssMenuTous.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeEnt" scope="request" class = "java.util.List"> </jsp:useBean> <%--attention au nom--%>
        
        <title>Choisir l'entraineur pour afficher Historique de ses eq</title>
    </head>
    <body>
        <div id="entete">Choisir l'entraineur pour afficher l'historique de ses équipes</div>
                <form method ="get" action="GestionTous">  

        
                <% List<Entraineur> lesEnt = listeEnt;%>
                
                <div class="input1">
            </br>   
            <div class ='input2'>
                <label for="ent">Entraineur  : <span class="requis"></span></label>
                <select name="ent">
                    <% for (Entraineur e : lesEnt ){%>
                    <option value="<%=e.getId()%>"><%=e.getNomPersonne() %> <%=e.getPrenomPersonne() %> </option>
                    <%}%><%-- le premier value est ce que tu récupères les 2 autres ce que tu affiches --%>
                </select> 
                
                </br>
                <input type ="hidden" name="action" value="HistoEnt"> <%-- action que tu renvoies à la JSP --%>
         </div></div>
            <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Remise à 0"/>       
            </div>
                </br>
           <TABLE>
                  <tr>
                    <a href="MenuTous.jsp"  class="bouton1"> Retour Menu</a>
                  </tr>
            </TABLE>
    </body>
</html>
