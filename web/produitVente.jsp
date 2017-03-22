<%-- 
    Document   : produitVente
    Created on : 22 mars 2017, 18:05:24
    Author     : Bryan
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modele.Produit"%>
<%@page import="modele.Produit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Produit de la vente aux encheres !</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>NOM</th>
                <th>PHOTO</th>
                <th>PRIX</th>

            </tr>
            <% 
            ArrayList<Produit> listeProduit = (ArrayList) request.getAttribute("listeProduit");
            
                for (Produit p : listeProduit){
                    out.print("<tr><td>"+p.getId()+"</td><td>"+p.getNom()+"</td><td>"+p.getPhoto()+"</td><td>"+p.getPrix()+"</td></tr>");
                }
            %>
        </table>
    </body>
</html>
