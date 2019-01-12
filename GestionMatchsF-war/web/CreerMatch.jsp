<%-- 
    Document   : CreerMatch
    Created on : 1 déc. 2018, 18:57:19
    Author     : katia
--%>
<%@page import="entites.Arbitre"%>
<%@page import="entites.Equipe"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="cssfede.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeEquipes" scope="request" class = "java.util.List"> </jsp:useBean>
        <jsp:useBean id="listeEquipess" scope="request" class = "java.util.List"> </jsp:useBean>
        <jsp:useBean id="listeArbitres" scope="request" class = "java.util.List"> </jsp:useBean> 
        <title>Creer un Match</title>
    </head>
    <body>
        <h1>Creer un Match</h1>
        <% List<Equipe> lesEqss = listeEquipess;%>
        <% List<Equipe> lesEqs = listeEquipes;%>
        <% List<Arbitre> LesArbs = listeArbitres;%>
        <form method ="get" action="gestionFed">
           
            <div class="input1">
            </br>   
            <div class ='input2'>
                <label for="dateMatch" class='textinput'> Date du match : </label> 
                <input type="date" placeholder='Date du Match' name="dateMatch" class='input'/>
            </div>
             <div class ='input2'>
                <label for="heure" class='textinput'> Heure du match : </label> 
                <input type ="text" placeholder='Heure du Match'name="heure"  class='input'/>
             </div>
            <div class ='input2'  >          
                <label for="nomEquUn"  class='textinput'> Equipe Une : </label>
                <select name="nomEquUn" class='custom-dropdown__select custom-dropdown__select--white'>
                    <% for (Equipe e : lesEqs ){%>
                    <option value="<%=e.getNomequipe()%>"><%=e.getNomequipe()%> </option>
                    <%}%>
                </select> 
            </div>
                <div class ='input2'   >                      
            <br>
               <label for="nomEquDeux"  class='textinput'>Equipe Deux : </label>
                <select name="nomEquDeux" class='custom-dropdown__select custom-dropdown__select--white'>
                    <% for (Equipe e : lesEqss ){%>
                    <option value="<%=e.getNomequipe()%>"><%=e.getNomequipe()%> </option>
                    <%}%>
                </select> 
            </div>
                <div class ='input2'  >              
               <br>
               <label for="idA" class='textinput'>Arbitre : </label>
               <select name="idA" class='custom-dropdown__select custom-dropdown__select--white'>
                   <% for (Arbitre a : LesArbs){%>
                   <option value="<%=a.getId()%>"><%=a.getNomPersonne()%> <%=a.getPrenomPersonne()%></option>
                   <%}%>
               </select> 
            </div>
               <br>
            
                <input type ="hidden" name="action" value="CreerMa">
        
            </div>
            <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Remise à 0"/>       
            </div>
            </br>
 <div class='retour'>
            <a href ="MenuFederation.jsp"> Retour Menu </a>
            </div>        </form>
    </body>
</html>
