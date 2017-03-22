<%-- 
    Document   : login
    Created on : 22 mars 2017, 21:20:57
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
        <h1>Connexion</h1>
        <form action="Controleur" method="post">
            <input type="hidden" name="action" value="login">
            <label>pseudo :</label><input type="text" name="login">
            <label>mdp :</label><input type="password" name="mdp">
            <input type="submit" value="CONNEXION">
        </form>
        
        <h2> ${message} </h2>
        
    </body>
</html>
