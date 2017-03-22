<%-- 
    Document   : index
    Created on : 21 mars 2017, 13:53:47
    Author     : Bryan
--%>

<%@page import="modele.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enchere-MAX</title>
    </head>
    <body>
        <h1>Bienvenue sur l'application Enchere-max !</h1>
        <%
            
        out.print(((Personne)session.getAttribute("user")).getNom());
        
        %>

        <form action="Controleur" method="get">
            <input type="hidden" name="action" value="produit">
            <button type="submit">Ajouter-Supprimer produits</button>
        </form>
        
      <!--  <form action="Controleur" method="get">
            <input type="hidden" name="action" value="listerProduits">
            <button type="submit">Voir les produits</button>
        </form>-->
        
       <!-- <form action="Controleur" method="get">
            <input type="hidden" name="action" value="listerVente">
            <button type="submit">Voir les ventes aux encheres</button>
        </form>-->

        <form action="Controleur" method="get">
            <input type="hidden" name="action" value="vente">
            <button type="submit">Créer-Supprimer une vente aux encheres</button>
        </form>
        
        

    </body>
</html>
