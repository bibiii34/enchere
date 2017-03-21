<%-- 
    Document   : ajoutProduit
    Created on : 19 mars 2017, 19:48:00
    Author     : Bryan
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modele.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Ajouter un produit</h1>
        
        <form action="Controleur" method="post" >
            <input type="hidden" name="action" value="ajoutProduit">
            
            <label> nom :</label><input type="text" name="nom">
            <label> prix :</label><input type="text" name="prix">
            <label> propriétaire :</label>
            <select name="proprietaire">
            <% 
            ArrayList<Personne> listePersonne = (ArrayList) request.getAttribute("listePersonne");
            
                for (Personne p : listePersonne){
                    out.print("<option value="+p.getIdp()+">"+p.getNom()+"</option>");
                    
                }
            %>
            </select>
            <input type="submit">
        </form>
    </body>
</html>
