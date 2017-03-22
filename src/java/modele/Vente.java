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
public class Vente {

    private int idV;
    private String date;
    private String nom;
    private String heureD;
    private String heureF;
    private String nomP;
    private String prenomP;
    private int idP;

    public int getIdV() {
        return idV;
    }

    public void setIdV(int idV) {
        this.idV = idV;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getHeureD() {
        return heureD;
    }

    public void setHeureD(String heureD) {
        this.heureD = heureD;
    }

    public String getHeureF() {
        return heureF;
    }

    public void setHeureF(String heureF) {
        this.heureF = heureF;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public String getPrenomP() {
        return prenomP;
    }

    public void setPrenomP(String prenomP) {
        this.prenomP = prenomP;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public void save() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (java.sql.Connection c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "")) {
                PreparedStatement s = c.prepareStatement("INSERT INTO `vente` (`idV`, `date`, `nom`, `heureD`, `heureF`, `idP`) VALUES (NULL, ?, ?, ?, ?, ?);");

                //String sql = "INSERT INTO `produit` (`id`, `nom`, `photo`, `prixInitial`, `idP`) VALUES (NULL, '"+this.getNom()+"', 'lien', '"+this.getPrix()+"', '1');";
                s.setString(1, this.getDate());
                s.setString(2, this.getNom());
                s.setString(3, this.getHeureD());
                s.setString(4, this.getHeureF());
                s.setInt(5, this.getIdP());

                s.executeUpdate();
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

    public void remove(String[] id) {
        if (id.length > 0) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try (java.sql.Connection c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "")) {
                    PreparedStatement s = c.prepareStatement("DELETE FROM `vente` WHERE idV = ?");

                    for (int i = 0; i < id.length; i++) {
                        s.setString(1, id[i]);
                        s.executeUpdate();
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
    }

    public ArrayList<Vente> listAll() {
        ArrayList<Vente> liste = new ArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (java.sql.Connection c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "")) {
                PreparedStatement s = c.prepareStatement("select idV, vente.nom, date, heureD, heureF, personne.nom as nomP, personne.prenom as prenomP, vente.idP from vente, personne where vente.idP = personne.idp;");
                ResultSet r = s.executeQuery();

                while (r.next()) {
                    Vente v = new Vente();
                    v.setIdV(r.getInt("idV"));
                    v.setNom(r.getString("nom"));
                    v.setDate(r.getString("date"));
                    v.setHeureD(r.getString("heureD"));
                    v.setHeureF(r.getString("heureF"));
                    v.setNomP(r.getString("nomP"));
                    v.setPrenomP(r.getString("prenomP"));
                    v.setIdP(r.getInt("idP"));
                    liste.add(v);
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

    public ArrayList<Vente> listDate() {
        ArrayList<Vente> liste = new ArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (java.sql.Connection c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", ""); 
                PreparedStatement s = c.prepareStatement("select idV, vente.nom, date, heureD, heureF, personne.nom as nomP, personne.prenom as prenomP from vente, personne where vente.idP = personne.idp and DATE(date) >= CURDATE();")) {
                ResultSet r = s.executeQuery();

                while (r.next()) {
                    Vente v = new Vente();
                    v.setIdV(r.getInt("idV"));
                    v.setNom(r.getString("nom"));
                    v.setDate(r.getString("date"));
                    v.setHeureD(r.getString("heureD"));
                    v.setHeureF(r.getString("heureF"));
                    v.setNomP(r.getString("nomP"));
                    v.setPrenomP(r.getString("prenomP"));
                    //v.setIdP(r.getInt("idp"));
                    liste.add(v);
                }

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
