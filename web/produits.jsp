<%-- 
    Document   : produits
    Created on : 19 mars 2017, 16:49:47
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
        <h1>Produits</h1>
        <!--récuperer attribut de la requete injecté par la servlet-->
        <% 
            String attribut = (String) request.getAttribute("test");
            out.println( attribut );
        %>
    </body>
</html>
