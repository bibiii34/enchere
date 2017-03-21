/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Personne;
import modele.Produit;
/**
 *
 * @author Bryan
 */
public class Controleur extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        String action = request.getParameter("action");
            
            //PAS D'ACTION
            if (action == null) {
                this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response );
            }
            //AJOUT PRODUIT
            else if (action.equals("ajoutProduit")){
                Personne p = new Personne();
                ArrayList<Personne> listePersonne = new ArrayList(p.list());
                
                request.setAttribute( "listePersonne", listePersonne );
                this.getServletContext().getRequestDispatcher( "/ajoutProduit.jsp" ).forward( request, response );
            }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String action = request.getParameter("action");
        
        //AJOUT PRODUIT
        if (action == null){
            
        }
        else if (action.equals("ajoutProduit")){
            
            Produit p = new Produit();
            p.setNom(request.getParameter("nom"));         
            p.setPrix(Double.parseDouble(request.getParameter("prix")));
            p.setCodeProp(Integer.parseInt(request.getParameter("proprietaire")));
            
            p.save();
            
            String message = "Produit Ajouté";
            request.setAttribute( "message", message );
                this.getServletContext().getRequestDispatcher( "/informations.jsp" ).forward( request, response );
            }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
