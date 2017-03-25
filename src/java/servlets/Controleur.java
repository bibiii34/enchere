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
import javax.servlet.http.HttpSession;
import modele.Personne;
import modele.Produit;
import modele.Vendre;
import modele.Vente;

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
        HttpSession session = request.getSession(true);
        String action = request.getParameter("action");

        //Si l'utilisateur n'est pas connecté
        if (session.getAttribute("user") == null) {
            this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            //PAS D'ACTION
            if (action == null) {
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            } 
            //ACTION=UTILISATEUR
            else if (action.equals("utilisateur")) {
                if (((Personne) session.getAttribute("user")).getRole() == 0){
                //AJOUT PRODUIT ADMIN
                    Personne p = new Personne();
                    ArrayList<Personne> listePersonne = new ArrayList(p.listAll());
                    request.setAttribute("listePersonne", listePersonne);
                    this.getServletContext().getRequestDispatcher("/Admin/utilisateur.jsp").forward(request, response);
                }
                } 
            //ACTION=PRODUIT
            else if (action.equals("produit")) {
                //AJOUT PRODUIT ADMIN
                if (((Personne) session.getAttribute("user")).getRole() == 0) {
                    Produit pr = new Produit();
                    Personne p = new Personne();
                    Vente v = new Vente();
                    ArrayList<Personne> listePersonne = new ArrayList(p.listProprietaire());
                    ArrayList<Produit> listeProduit = new ArrayList(pr.list());
                    ArrayList<Vente> listeVente = new ArrayList(v.listDate());

                    request.setAttribute("listePersonne", listePersonne);
                    request.setAttribute("listeProduit", listeProduit);
                    request.setAttribute("listeVente", listeVente);
                    this.getServletContext().getRequestDispatcher("/Admin/produit.jsp").forward(request, response);
                } //LISTE PRODUIT USER
                else {
                    Produit pr = new Produit();
                    ArrayList<Produit> listeProduit = new ArrayList(pr.list());

                    request.setAttribute("listeProduit", listeProduit);
                    this.getServletContext().getRequestDispatcher("/produit.jsp").forward(request, response);
                }
            } //ACTION=VENTE
            else if (action.equals("vente")) {
                //AJOUT VENTE ADMIN
                if (((Personne) session.getAttribute("user")).getRole() == 0) {
                    Personne p = new Personne();
                    Vente v = new Vente();
                    ArrayList<Personne> listePersonne = new ArrayList(p.listResponsable());
                    ArrayList<Vente> listeVente = new ArrayList(v.listAll());

                    request.setAttribute("listePersonne", listePersonne);
                    request.setAttribute("listeVente", listeVente);
                    this.getServletContext().getRequestDispatcher("/Admin/vente.jsp").forward(request, response);
                } //LISTE VENTE USER
                else {
                    Vente v = new Vente();
                    ArrayList<Vente> listeVente = new ArrayList(v.listAll());
                    request.setAttribute("listeVente", listeVente);
                    this.getServletContext().getRequestDispatcher("/vente.jsp").forward(request, response);
                }
                //ACTION = VENTEPRODUITS
            } else if (action.equals("venteProduits")) {
                Produit p = new Produit();
                ArrayList<Produit> produits = new ArrayList(p.produitsVente(request.getParameter("idV")));

                if (produits.size() == 0) {
                    String message = "Aucun produit n'est associé a cette vente !";
                    request.setAttribute("message", message);
                    this.getServletContext().getRequestDispatcher("/informations.jsp").forward(request, response);
                } else {
                    request.setAttribute("listeProduit", produits);
                    this.getServletContext().getRequestDispatcher("/produitVente.jsp").forward(request, response);
                }
            }
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
        HttpSession session = request.getSession(true);
        String action = request.getParameter("action");

        if (action == null) {
            String message = "Une erreur s'est produite !";
            request.setAttribute("message", message);
            this.getServletContext().getRequestDispatcher("/informations.jsp").forward(request, response);
        } //ACTION = LOGIN
        else if (action.equals("login")) {
            Personne user = new Personne();
            user.login(request.getParameter("login"), request.getParameter("mdp"));

            if (user.getLogin() == null) {
                String message = "Login ou mot de passe incorrect !";
                request.setAttribute("message", message);
                this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                session.setAttribute("user", user);
                response.sendRedirect("Controleur");
            }
        } //ACTION = LOGOUT
        else if (action.equals("logout")) {
            session.removeAttribute("user");
            response.sendRedirect("Controleur");
        } //AJOUT PRODUIT
        else if (action.equals("ajoutProduit")) {
            Vente v = new Vente();
            Produit pr = new Produit();
            Personne p = new Personne();

            pr.setNom(request.getParameter("nom"));
            pr.setPrix(Double.parseDouble(request.getParameter("prix")));
            pr.setIdP(Integer.parseInt(request.getParameter("proprietaire")));

            pr.save();

            ArrayList<Personne> listePersonne = new ArrayList(p.listProprietaire());
            ArrayList<Produit> listeProduit = new ArrayList(pr.list());
            ArrayList<Vente> listeVente = new ArrayList(v.listDate());

            request.setAttribute("listeVente", listeVente);
            request.setAttribute("listePersonne", listePersonne);
            request.setAttribute("listeProduit", listeProduit);
            this.getServletContext().getRequestDispatcher("/Admin/produit.jsp").forward(request, response);
        } //SUPPRIMER PRODUIT
        else if (action.equals("supprimerProduit")) {
            Vente v = new Vente();
            Produit pr = new Produit();
            Personne p = new Personne();

            pr.remove(request.getParameterValues("id"));

            ArrayList<Personne> listePersonne = new ArrayList(p.listProprietaire());
            ArrayList<Produit> listeProduit = new ArrayList(pr.list());
            ArrayList<Vente> listeVente = new ArrayList(v.listDate());

            request.setAttribute("listeVente", listeVente);
            request.setAttribute("listePersonne", listePersonne);
            request.setAttribute("listeProduit", listeProduit);
            this.getServletContext().getRequestDispatcher("/Admin/produit.jsp").forward(request, response);
        } //AJOUT VENTE
        else if (action.equals("ajoutVente")) {

            Vente v = new Vente();
            Personne p = new Personne();

            v.setDate(request.getParameter("date"));
            v.setNom(request.getParameter("nom"));
            v.setHeureD(request.getParameter("heureD"));
            v.setHeureF(request.getParameter("heureF"));
            v.setIdP(Integer.parseInt(request.getParameter("responsable")));

            v.save();

            ArrayList<Personne> listePersonne = new ArrayList(p.listResponsable());
            ArrayList<Vente> listeVente = new ArrayList(v.listAll());

            request.setAttribute("listePersonne", listePersonne);
            request.setAttribute("listeVente", listeVente);
            this.getServletContext().getRequestDispatcher("/Admin/vente.jsp").forward(request, response);
        } 
        //SUPPRIMER VENTE
        else if (action.equals("supprimerVente")) {
            Vente v = new Vente();
            v.remove(request.getParameterValues("id"));

            Personne p = new Personne();
            ArrayList<Personne> listePersonne = new ArrayList(p.listResponsable());
            ArrayList<Vente> listeVente = new ArrayList(v.listAll());

            request.setAttribute("listePersonne", listePersonne);
            request.setAttribute("listeVente", listeVente);
            this.getServletContext().getRequestDispatcher("/Admin/vente.jsp").forward(request, response);
        } //AJOUT SUPPRIMER PRODUIT A VENDRE
        else if (action.equals("vendre")) {
            Vendre ve = new Vendre();
            Produit pr = new Produit();
            Vente v = new Vente();
            Personne p = new Personne();

            if (request.getParameter("idV").equals("null")) {
                ve.remove(request.getParameter("idP"));
                ArrayList<Personne> listePersonne = new ArrayList(p.listProprietaire());
                ArrayList<Vente> listeVente = new ArrayList(v.listAll());
                ArrayList<Produit> listeProduit = new ArrayList(pr.list());

                request.setAttribute("listePersonne", listePersonne);
                request.setAttribute("listeVente", listeVente);
                request.setAttribute("listeProduit", listeProduit);
                this.getServletContext().getRequestDispatcher("/Admin/produit.jsp").forward(request, response);

            } else {

                ve.setIdV(Integer.parseInt(request.getParameter("idV")));
                ve.setIdP(Integer.parseInt(request.getParameter("idP")));
                ve.save();

                ArrayList<Personne> listePersonne = new ArrayList(p.listProprietaire());
                ArrayList<Vente> listeVente = new ArrayList(v.listAll());
                ArrayList<Produit> listeProduit = new ArrayList(pr.list());

                request.setAttribute("listePersonne", listePersonne);
                request.setAttribute("listeVente", listeVente);
                request.setAttribute("listeProduit", listeProduit);
                this.getServletContext().getRequestDispatcher("/Admin/produit.jsp").forward(request, response);
            }
        }
        //ACTION=SUPPRIMERUTILISATEUR
        else if (action.equals("supprimerUtilisateur")) {

            Personne p = new Personne();
            p.remove(request.getParameterValues("id"));
            ArrayList<Personne> listePersonne = new ArrayList(p.listAll());
            request.setAttribute("listePersonne", listePersonne);
            this.getServletContext().getRequestDispatcher("/Admin/utilisateur.jsp").forward(request, response);
        }
        // ACTION=AJOUTUTILISATEUR
        else if (action.equals("ajoutUtilisateur")) {

            Personne p = new Personne();

            p.setNom(request.getParameter("nom"));
            p.setPrenom(request.getParameter("prenom"));
            p.setEmail(request.getParameter("email"));
            p.setLogin(request.getParameter("login"));
            p.setMdp(request.getParameter("mdp"));
            p.setRole(Integer.parseInt(request.getParameter("role")));

            p.save();

            ArrayList<Personne> listePersonne = new ArrayList(p.listAll());
            request.setAttribute("listePersonne", listePersonne);
            this.getServletContext().getRequestDispatcher("/Admin/utilisateur.jsp").forward(request, response);
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
