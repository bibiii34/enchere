/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan
 */
public class Produit {

    private int id;
    private String nom;
    private String photo;
    private double prix;
    private String nomP;
    private String prenomP;
    private int idP;
    private String nomV;
    private int idV;

    public int getId() {
        return id;
    }

    public void setId(int code) {
        this.id = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
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

    public void setIdP(int codeProp) {
        this.idP = codeProp;
    }

    public String getNomV() {
        return nomV;
    }

    public void setNomV(String nomV) {
        this.nomV = nomV;
    }

    public int getIdV() {
        return idV;
    }

    public void setIdV(int idV) {
        this.idV = idV;
    }

    public void save() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (java.sql.Connection c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "")) {
                PreparedStatement s = c.prepareStatement("INSERT INTO `produit` (`id`, `nom`, `photo`, `prixInitial`, `idP`) VALUES (NULL, ?, 'lien', ?, ?);");

                //String sql = "INSERT INTO `produit` (`id`, `nom`, `photo`, `prixInitial`, `idP`) VALUES (NULL, '"+this.getNom()+"', 'lien', '"+this.getPrix()+"', '1');";
                s.setString(1, this.getNom());
                s.setDouble(2, this.getPrix());
                s.setInt(3, this.getIdP());

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
                    PreparedStatement s = c.prepareStatement("DELETE FROM `produit` WHERE id = ?");

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

    public ArrayList<Produit> list() {
        ArrayList<Produit> liste = new ArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (java.sql.Connection c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "")) {
                PreparedStatement s = c.prepareStatement("select produit.id, produit.nom, produit.photo, produit.prixInitial, produit.idP, personne.nom as nomP, personne.prenom as prenomP, vente_idV as idV, vente.nom as nomV  from produit inner join personne on produit.idP = personne.idp left join vendre on produit.id = vendre.produit_id left join vente on vente.idV = vendre.vente_idV;");
                ResultSet r = s.executeQuery();

                while (r.next()) {
                    Produit p = new Produit();
                    p.setId(r.getInt("id"));
                    p.setNom(r.getString("nom"));
                    p.setPhoto(r.getString("photo"));
                    p.setPrix(Double.parseDouble(r.getString("prixInitial")));
                    p.setNomP(r.getString("nomP"));
                    p.setPrenomP(r.getString("prenomP"));
                    p.setIdP(r.getInt("idP"));
                    p.setIdV(r.getInt("idV"));
                    p.setNomV(r.getString("nomV"));
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
    
     public ArrayList<Produit> produitsVente (String idVente) {
        ArrayList<Produit> liste = new ArrayList();
        
                try {
            Class.forName("com.mysql.jdbc.Driver");
            try (java.sql.Connection c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", ""); 
                    PreparedStatement s = c.prepareStatement("select * from produit, vendre where id=vendre.produit_id and vendre.vente_idV = ?;")) {
               
               
                s.setString(1, idVente);
                ResultSet r = s.executeQuery();
                
                while(r.next()){
                    Produit p = new Produit();
                    p.setId(r.getInt("id"));
                    p.setNom(r.getString("nom"));
                    p.setPhoto(r.getString("photo"));
                    p.setPrix(Double.parseDouble(r.getString("prixInitial")));
                    p.setIdP(r.getInt("idP"));
                    liste.add(p);
                }                
                
            } catch (SQLException ex) {
                Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
            }
                } catch (ClassNotFoundException ex) {
            Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
        }
                return liste;
     }

}
