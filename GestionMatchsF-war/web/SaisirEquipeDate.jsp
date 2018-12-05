<%-- 
    Document   : CreerAPF
    Created on : 7 nov. 2012, 17:03:00
    Author     : guilaine.talens
--%>

<%@page import="entites.Equipe"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:useBean id="listeequipe" scope="request" class="java.util.List"></jsp:useBean>

    </head>
    <body>
        <h1>Création de Produit Frais</h1>
        <%  List<Equipe> lesFour=listeequipe;%>
                <div>
            <form method="get" action="GestionTous">
                <fieldset>
                    <legend>Saisir Equipe et date</legend>
    
                    <label for="Nomequipe">choisir une équipe <span class="requis">*</span></label>
                    <%--      <input type="text" id="identifiantFournisseur" name="identifiantFournisseur" value="" size="20" maxlength="20" />
                    <br />--%>
                    <select name="NomEquipe">
                        <% for (Equipe f :lesFour) {%>
                        <option value ="<%=f.getId()%>"><%=f.getNomequipe()%></option>
                        <% }%>
                    </select>
                    <br />

                    
                    <label for="datematch">Jour Date match <span class="requis">*</span></label>
                    <input type="date" name="datematch" value="" size="20" maxlength="20" />
                    <br />
                   
                    
                    <input type="hidden" name="action" value="rechercherdateequip">
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>
