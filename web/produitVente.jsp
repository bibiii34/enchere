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
        <!-- Bootstrap -->
        <link rel="stylesheet" type="text/css"  href="Public/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="Public/fonts/font-awesome/css/font-awesome.css">
        <link rel="stylesheet" type="text/css"  href="Public/css/style.css">
        <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,700,300,600,800,400' rel='stylesheet' type='text/css'>
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

                for (Produit p : listeProduit) {
                    out.print("<tr><td>" + p.getId() + "</td><td>" + p.getNom() + "</td><td>" + p.getPhoto() + "</td><td>" + p.getPrix() + "</td></tr>");
                }
            %>
        </table>
    </body>
</html>
