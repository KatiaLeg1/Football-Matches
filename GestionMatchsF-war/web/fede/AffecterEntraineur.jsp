<%-- 
    Document   : AffecterEntraineur
    Created on : 4 déc. 2018, 21:20:53
    Author     : katia
--%>

<%@page import="entites.Entraineur"%>
<%@page import="java.util.List"%>
<%@page import="entites.Equipe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/fede/cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeEquipes" scope="request" class = "java.util.List"> </jsp:useBean>
        <jsp:useBean id="listeEquipent" scope="request" class = "java.util.List"> </jsp:useBean>

        <title>Affecter Un Entraineur</title>
    </head>
    <body>
        <h1>Affecter un entraineur</h1>
        <% List<Entraineur> lesEnts = listeEquipent;%>
        <% List<Equipe> lesEqs = listeEquipes;%>
        
        <form method ="get" action="${pageContext.request.contextPath}/gestionFed">

            <div class="input1">
            </br>   
            <div class ='input2'>
                <label for="dateDebut" class='textinput' >Date début afectation</label> 
                <input type="date" placeholder='date début affectation' name="dateDebut" class='input'/>
            </div>
            <div class ='input2'>                
                <label for="ent" class='textinput'>Entraineur : </label>
                <select name="ent" class='custom-dropdown__select custom-dropdown__select--white'>
                    <% for (Entraineur ent : lesEnts ){%>
                    <option value="<%=ent.getId()%>"><%=ent.getNomPersonne()%> <%=ent.getPrenomPersonne()%> </option>
                    <%}%>
                </select> 
                </br>
            </div>
                </br>
            <div class ='input2'> 
               <label for="equipe" class='textinput'>Equipe : </label>
                <select name="equipe" class='custom-dropdown__select custom-dropdown__select--white'>
                    <% for (Equipe e : lesEqs ){%>
                    <option value="<%=e.getNomequipe()%>"><%=e.getNomequipe()%> </option>
                    <%}%>
                </select> 
            </div>               
               <br>
            
                <input type ="hidden" name="action" value="AffEnt">
            </div>
        
            <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Remise à 0"/>       
            </div>
            </br>
<div class="retour">
                <a href ="${pageContext.request.contextPath}/fede/MenuFederation.jsp"> Retour Menu </a>
            </div>        </form>
    </body>
</html>