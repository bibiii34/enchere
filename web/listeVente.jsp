<%-- 
    Document   : listeVente
    Created on : 22 mars 2017, 12:25:52
    Author     : Bryan
--%>

<%@page import="modele.Vente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modele.Produit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Voici la liste des ventes aux encheres</h1>
        
         <table>
            <tr>
                <th>ID</th>
                <th>NOM</th>
                <th>DATE</th>
                <th>HEURE DE DEBUT</th>
                <th>HEURE DE FIN</th>
                <th>RESPONSABLE</th>
            </tr>
            <% 
            ArrayList<Vente> listeVente = (ArrayList) request.getAttribute("listeVente");
            
                for (Vente v : listeVente){
                    out.print("<tr><td>"+v.getIdV()+"</td><td>"+v.getNom()+"</td><td>"+v.getDate()+"</td><td>"+v.getHeureD()+"</td><td>"+v.getHeureF()+"</td><td>"+v.getPrenomP()+" "+v.getNomP()+"</td></tr>");
                    
                }
            %>
        
        </table>
    </body>
</html>
