<%-- 
    Document   : ajoutVente
    Created on : 22 mars 2017, 11:22:36
    Author     : Bryan
--%>

<%@page import="modele.Vente"%>
<%@page import="modele.Personne"%>
<%@page import="java.util.ArrayList"%>
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
        <h1>Planifier une vente aux encheres</h1>

        <form action="Controleur" method="post" >
            <input type="hidden" name="action" value="ajoutVente">

            <label> Nom de la vente aux enchere : </label> <input type="text" name="nom">
            <label> Date :</label><input type="text" name="date">

            <label> Heure de début :</label><input type="text" name="heureD">
            <label> Heure de fin :</label><input type="text" name="heureF">
            <label> Responsable :</label><select name="responsable">
                <%
                    ArrayList<Personne> listePersonne = (ArrayList) request.getAttribute("listePersonne");

                    for (Personne p : listePersonne) {
                        out.print("<option value=" + p.getIdp() + ">" + p.getNom() + "</option>");

                    }
                %>
            </select>
            <input type="submit">
        </form>
        <h1>Voici la liste des ventes aux encheres</h1>
        <form action="Controleur" method="post" id="supprimer">
            <input type="hidden" name="action" value="supprimerVente">
            <table>

                <tr>
                    <th>SELECTION</th>
                    <th>ID</th>
                    <th>NOM</th>
                    <th>DATE</th>
                    <th>HEURE DE DEBUT</th>
                    <th>HEURE DE FIN</th>
                    <th>RESPONSABLE</th>
                </tr>
                <%
                    ArrayList<Vente> listeVente = (ArrayList) request.getAttribute("listeVente");

                    for (Vente v : listeVente) {
                        out.print("<tr><td><input type='checkbox' name='id' value='" + v.getIdV() + "'></td></form><td>" + v.getIdV() + "</td><td>" + v.getNom() + "</td><td>" + v.getDate() + "</td><td>" + v.getHeureD() + "</td><td>" + v.getHeureF() + "</td><td>" + v.getPrenomP() + " " + v.getNomP() + "</td><form action='Controleur' method='get'><input type='hidden' name='action' value='venteProduits'><input type='hidden' name='idV' value='" + v.getIdV() + "'><td><input type='submit' value='Voir Produits'></form></td></tr>");

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
                    <td></td>


                </tr>

            </table>

            <form action="Controlleur">
                <input type="submit" value="retour au menu">
            </form>

    </body>
</html>
