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
        <!-- Bootstrap -->
        <link rel="stylesheet" type="text/css"  href="Public/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="Public/fonts/font-awesome/css/font-awesome.css">
        <link rel="stylesheet" type="text/css"  href="Public/css/style.css">
        <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,700,300,600,800,400' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <div id="tf-contact" class="text-center">
            <div class="container">

                <div class="row">
                    <div class="col-md-8 col-md-offset-2">

                        <div class="section-title center">
                            <h2>Connectez-vous</h2>
                            <div class="line">
                                <hr>
                            </div>
                            <div class="clearfix"></div>

                        </div>

                        <form action="Controleur" method="post">
                            <input type="hidden" name="action" value="login">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="pseudo">pseudo</label>
                                        <input type="text" class="form-control" name="login" placeholder="Enter votre pseudo" required>
                                    </div>
                                </div>

                            </div>  
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="mdp">Mot de passe</label>
                                        <input type="password" class="form-control" name="mdp" placeholder="Entrer votre mot de passe" required>
                                                <h3> ${message} </h3>
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="btn tf-btn btn-default">Connexion</button>
                        </form>

                    </div>
                </div>

            </div>
        </div>



</body>
</html>
