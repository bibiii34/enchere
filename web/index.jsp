<%-- 
    Document   : index
    Created on : 21 mars 2017, 13:53:47
    Author     : Bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenue sur l'application Enchere-max !</h1>
        
        <form action="Controleur" method="get">
            <input type="hidden" name="action" value="ajoutProduit">
            <button type="submit">Ajouter un produit</button>
        </form>
    </body>
</html>
