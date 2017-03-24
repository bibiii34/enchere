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
        <!-- Styles + Bootstrap +fonts -->
        <link rel="stylesheet" type="text/css"  href="Public/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="Public/fonts/font-awesome/css/font-awesome.css">
        <link rel="stylesheet" type="text/css"  href="Public/css/style.css">    
        <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,700,300,600,800,400' rel='stylesheet' type='text/css'>
    </head>
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
                    <a class="navbar-brand"><% out.print(((Personne)session.getAttribute("user")).getPrenom()+" "+((Personne)session.getAttribute("user")).getNom()); %></a>
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
                    <h1>Bienvenue sur notre<strong><span class="color"> projet PHP & JSP</span></strong></h1>
                    <p class="lead">Vente aux enchère ne ratez pas <strong> l'occasion</strong></p>
                </div>
                <div class="container">

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
