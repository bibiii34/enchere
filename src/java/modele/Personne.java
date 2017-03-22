/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan
 */
public class Personne {
    private int idp;
    private String nom;
    private String prenom;
    private String email;
    private String login;
    private String mdp;
    private int role;

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
    public void login(String login, String mdp) {
        //Personne user = new Personne();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (java.sql.Connection c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "")) {
                PreparedStatement s = c.prepareStatement("SELECT * FROM personne where login = ? and mdp = ?");
                
                
                s.setString(1,login);
                s.setString(2,mdp);
                ResultSet r = s.executeQuery();
                 
                while (r.next()) {
                    Personne p = new Personne();
                    this.setIdp(r.getInt("idP"));
                    this.setNom(r.getString("nom"));
                    this.setPrenom(r.getString("prenom"));
                    this.setEmail(r.getString("email"));
                    this.setLogin(r.getString("login"));
                    this.setRole(r.getInt("role"));
                }

                s.close();

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("erreur de chargement de la lib");
        } catch (SQLException ex) {
            Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("erreur sql");
        }
        
    }
    
    public ArrayList<Personne> listAll() {
        ArrayList<Personne> liste = new ArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (java.sql.Connection c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "")) {
                PreparedStatement s = c.prepareStatement("SELECT * FROM personne");
                ResultSet r = s.executeQuery();

                while (r.next()) {
                    Personne p = new Personne();
                    p.setIdp(r.getInt("idP"));
                    p.setNom(r.getString("nom"));
                    p.setPrenom(r.getString("prenom"));
                    p.setEmail(r.getString("email"));
                    p.setLogin(r.getString("login"));
                    p.setRole(r.getInt("role"));
                    liste.add(p);
                }

                s.close();

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("erreur de chargement de la lib");
        } catch (SQLException ex) {
            Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("erreur sql");
        }
        return liste;
    }
    
    public ArrayList<Personne> listAdmin() {
        ArrayList<Personne> liste = new ArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (java.sql.Connection c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "")) {
                PreparedStatement s = c.prepareStatement("SELECT * FROM personne where role = 0");
                ResultSet r = s.executeQuery();

                while (r.next()) {
                    Personne p = new Personne();
                    p.setIdp(r.getInt("idP"));
                    p.setNom(r.getString("nom"));
                    p.setPrenom(r.getString("prenom"));
                    p.setEmail(r.getString("email"));
                    p.setLogin(r.getString("login"));
                    p.setRole(r.getInt("role"));
                    liste.add(p);
                }

                s.close();

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("erreur de chargement de la lib");
        } catch (SQLException ex) {
            Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("erreur sql");
        }
        return liste;
    }
    
     public ArrayList<Personne> listResponsable() {
        ArrayList<Personne> liste = new ArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (java.sql.Connection c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "")) {
                PreparedStatement s = c.prepareStatement("SELECT * FROM personne where role = 1");
                ResultSet r = s.executeQuery();

                while (r.next()) {
                    Personne p = new Personne();
                    p.setIdp(r.getInt("idP"));
                    p.setNom(r.getString("nom"));
                    p.setPrenom(r.getString("prenom"));
                    p.setEmail(r.getString("email"));
                    p.setLogin(r.getString("login"));
                    p.setRole(r.getInt("role"));
                    liste.add(p);
                }

                s.close();

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("erreur de chargement de la lib");
        } catch (SQLException ex) {
            Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("erreur sql");
        }
        return liste;
    }
    
     public ArrayList<Personne> listProprietaire() {
        ArrayList<Personne> liste = new ArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (java.sql.Connection c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "")) {
                PreparedStatement s = c.prepareStatement("SELECT * FROM personne where role = 2");
                ResultSet r = s.executeQuery();

                while (r.next()) {
                    Personne p = new Personne();
                    p.setIdp(r.getInt("idP"));
                    p.setNom(r.getString("nom"));
                    p.setPrenom(r.getString("prenom"));
                    p.setEmail(r.getString("email"));
                    p.setLogin(r.getString("login"));
                    p.setRole(r.getInt("role"));
                    liste.add(p);
                }

                s.close();

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("erreur de chargement de la lib");
        } catch (SQLException ex) {
            Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("erreur sql");
        }
        return liste;
    }
    
     public ArrayList<Personne> listParticipant() {
        ArrayList<Personne> liste = new ArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (java.sql.Connection c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "")) {
                PreparedStatement s = c.prepareStatement("SELECT * FROM personne where role = 3");
                ResultSet r = s.executeQuery();

                while (r.next()) {
                    Personne p = new Personne();
                    p.setIdp(r.getInt("idP"));
                    p.setNom(r.getString("nom"));
                    p.setPrenom(r.getString("prenom"));
                    p.setEmail(r.getString("email"));
                    p.setLogin(r.getString("login"));
                    p.setRole(r.getInt("role"));
                    liste.add(p);
                }

                s.close();

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("erreur de chargement de la lib");
        } catch (SQLException ex) {
            Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("erreur sql");
        }
        return liste;
    }
     
}
