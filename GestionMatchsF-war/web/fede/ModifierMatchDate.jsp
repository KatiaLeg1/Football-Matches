<%-- Document   : CreerMatch
    Created on : 1 déc. 2018, 18:57:19
    Author     : katia
--%>
<%@page import="entites.Matchs"%>
<%@page import="entites.Arbitre"%>
<%@page import="entites.Equipe"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/fede/cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>

   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeMatch" scope="request" class = "java.util.List"> </jsp:useBean>

        <title>Modifier un Match</title>
    </head>
    <body>
        <h1>Modifier un Match</h1>
        <% List<Matchs> lesM = listeMatch;%>
        <form method ="get" action="${pageContext.request.contextPath}/gestionFed">
           
                
                
            <div class="input1">   
            <div class ='input2'>
                <label for="idM" class='textinput'>Equipe Une : </label>
                <select name="idM"class='custom-dropdown__select custom-dropdown__select--white'>
                    <% for (Matchs m : lesM ){%>
                    <option value="<%=m.getId()%>">Date : <%= m.getDateMatch().getDay()  %>/<%= m.getDateMatch().getMonth()%>/<%= m.getDateMatch().getYear() %> Equipes :<%=m.getEquipeUn().getNomequipe()  %> VS <%=m.getEquipeDeux().getNomequipe() %>   </option>
                    <%}%>
                </select> 
            </div>
            <div class ='input2'   >  
                <label for="dateM1"  class='textinput'>Date du match à changer</label> 
                <input type="date" placeholder='date à changer' name="dateM1" class='input'/>
                <br>
                <label for="heure">Heure du Match<span class="requis"></span></label> 
                <input type ="text" name="heure"  class='input'/>
                <br>
               <br>
            
                <input type ="hidden" name="action" value="ModifierMa">
        
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à 0"/>               
             <a href ="${pageContext.request.contextPath}/fede/MenuFederation"> Retour Menu </a> 

        </form>
    </body>
</html>
