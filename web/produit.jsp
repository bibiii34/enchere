<%-- 
    Document   : ajoutProduit
    Created on : 19 mars 2017, 19:48:00
    Author     : Bryan
--%>

<%@page import="modele.Vente"%>
<%@page import="modele.Produit"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modele.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css"  href="Public/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome/css/font-awesome.css">
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

                    for (Personne p : listePersonne) {
                        out.print("<option value=" + p.getIdp() + ">" + p.getNom() + "</option>");

                    }
                %>
            </select>
            <input type="submit">
        </form>
        <br><br>

        <h1>Liste des produits</h1>
        <form action="Controleur" method="post" id="supprimer">
            <input type="hidden" name="action" value="supprimerProduit">
            <table class="table table-bordered">
                <tr>
                    <th>SELECTIONNER</th>
                    <th>ID</th>
                    <th>NOM</th>
                    <th>PRIX</th>
                    <th>PHOTO</th>
                    <th>PROPRIETAIRE</th>
                    <th>VENTE</th>
                    <th>CHOIX VENTE</th>
                </tr>
                <%
                    ArrayList<Produit> listeProduit = (ArrayList) request.getAttribute("listeProduit");
                    ArrayList<Vente> listeVente = (ArrayList) request.getAttribute("listeVente");

                    for (Produit p : listeProduit) {
                        out.print("<tr><td><input type='checkbox' name='id' value='" + p.getId() + "'></td></form><td>" + p.getId() + "</td><td>" + p.getNom() + "</td><td>" + p.getPrix() + "</td><td>" + p.getPhoto() + "</td><td>" + p.getPrenomP() + " " + p.getNomP() + "</td><td>" + p.getNomV() + "</td><td><form action='Controleur' method='post'><input type='hidden' name='action' value='vendre'><input type='hidden' name='idP' value='"+p.getId()+"'><select name='idV'><option name='idV' value='null'>aucune</option>");

                        for (Vente v : listeVente) {
                            out.print("<option value='"+v.getIdV()+"'>" + v.getNom() + "</option>");
                        }

                        out.print("</select></td><td><input type='submit' value='attribuer'></form></td></tr>");

                    }
                %>
                <tr>
                    <td>
                        <button type="submit" id="supprimer">SUPPRIMER</button>
                    </td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>


                    <td>

                    </td>

                </tr>

            </table>
        
        <form action="Controlleur">
            <input type="submit" value="retour au menu">
        </form>
    </body>
</html>
