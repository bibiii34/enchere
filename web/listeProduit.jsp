<%-- 
    Document   : listeProduit
    Created on : 22 mars 2017, 10:36:11
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
        <h1>Voici la liste de tous les produits</h1>
        <form action="Controleur" method="post">
            <input type="hidden" name="action" value="mettreEnVente">
        <table>
            <tr>
                <th>ID</th>
                <th>NOM</th>
                <th>PRIX</th>
                <th>PHOTO</th>
                <th>PROPRIETAIRE</th>
                <th>ATTRIBUER A</th>
            </tr>
            <% 
            ArrayList<Produit> listeProduit = (ArrayList) request.getAttribute("listeProduit");
            
                for (Produit p : listeProduit){
                    out.print("<tr><td>"+p.getId()+"</td><td>"+p.getNom()+"</td><td>"+p.getPrix()+"</td><td>"+p.getPhoto()+"</td><td>"+p.getPrenomP()+" "+p.getNomP()+"</td><td><input type='checkbox' name='id' value='"+p.getId()+"'></td></tr>");
                    
                }
            %>
        
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>
                    <select>
                    <% 
                    ArrayList<Vente> listeVente = (ArrayList) request.getAttribute("listeVente");

                        for (Vente v : listeVente){
                            out.print("<option value="+v.getIdV()+">"+v.getIdV()+" "+v.getNom()+"</option>");

                        }
                    %>
                    </select>
                </td>
                
                
            </tr>
        
        
        </table>    
        <input type="submit" value="Mettre en vente">
        
        </form>
    </body>
</html>
