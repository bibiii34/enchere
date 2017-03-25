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
        <link rel="stylesheet" type="text/css"  href="Public/css/style.css">
        <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,700,300,600,800,400' rel='stylesheet' type='text/css'>
    </head>
    <body>
    <body>
        <!-- Navigation
   ==========================================-->
        <nav id="tf-menu" class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand"><% out.print(((Personne) session.getAttribute("user")).getPrenom() + " " + ((Personne) session.getAttribute("user")).getNom()); %></a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <form action="Controleur" method="get">
                                <input type="hidden" name="action" value="produit">
                                <button type="submit"  class="btn btn-default btn-marin">produits</button>
                            </form>
                        </li>
                        <li>
                            <form action="Controleur" method="get">
                                <input type="hidden" name="action" value="vente">
                                <button type="submit" class="btn btn-default btn-marin">vente aux encheres</button>
                            </form>
                        </li>
                        <li>
                            <form action="Controleur" method="post">
                                <input type="hidden" name="action" value="logout">
                                <button type="submit" class="btn btn-default btn-marin">Se déconnecter</button>
                            </form>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <!-- Home Page
  ==========================================-->
        <div id="tf-home" class="text-center">
            <div class="overlay">
                <div class="content">

                    <div class="container">
                        <div class="row">
                            <form action="Controleur" method="post" >
                                <input type="hidden" name="action" value="ajoutProduit">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label> Nom :</label><input type="text" name="nom" class="form-control">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label> Prix :</label><input type="text" name="prix" class="form-control">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label> Propriétaire :</label>
                                        <select name="proprietaire" class="form-control">
                                            <%
                                                ArrayList<Personne> listePersonne = (ArrayList) request.getAttribute("listePersonne");
                                                for (Personne p : listePersonne) {
                                                    out.print("<option value=" + p.getIdp() + ">" + p.getNom() + "</option>");
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>
                                <input type="submit" value="Ajouter"  class="btn tf-btn btn-default orange">
                            </form>
                        </div>
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
                                        out.print("<tr><td><input type='checkbox' name='id' value='" + p.getId() + "'></td></form><td>" + p.getId() + "</td><td>" + p.getNom() + "</td><td>" + p.getPrix() + "</td><td>" + p.getPhoto() + "</td><td>" + p.getPrenomP() + " " + p.getNomP() + "</td><td>" + p.getNomV() + "</td><td><form action='Controleur' method='post'><input type='hidden' name='action' value='vendre'><input type='hidden' name='idP' value='" + p.getId() + "'><select name='idV'><option name='idV' value='null'>aucune</option>");

                                        for (Vente v : listeVente) {
                                            out.print("<option value='" + v.getIdV() + "'>" + v.getNom() + "</option>");
                                        }

                                        out.print("</select ></td><td><input type='submit' value='Vendre' class='orange btn tf-btn btn-default'></form></td></tr>");

                                    }
                                %>
                                <tr>
                                    <td>
                                        <button type="submit" id="supprimer" class='orange btn btn-default'>SUPPRIMER</button>
                                    </td>

                                </tr>

                            </table>

                            <form action="Controleur">
                                <input type="submit" value="retour au menu" class="btn btn-default btn-marin">
                            </form>          

                    </div>
                </div>
                </div>


            <nav id="footer">
                <div class="container">
                    <div class="pull-left fnav">
                        <p>ALL RIGHTS RESERVED. COPYRIGHT © 2017. Designed by <strong>Antoine Duthen</strong> & <strong>Bryan Torralba</strong></p>
                    </div>
                    <div class="pull-right fnav">
                        <ul class="footer-social">
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                            <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                        </ul>
                    </div>
                </div>
            </nav>
  
  
    </body>
</html>
