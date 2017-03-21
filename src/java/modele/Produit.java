/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan
 */
public class Produit {
    private int code;
    private String nom;
    private String photo;
    double prix;
    private int codeProp;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public int getCodeProp() {
        return codeProp;
    }

    public void setCodeProp(int codeProp) {
        this.codeProp = codeProp;
    }
    
    public void save() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (java.sql.Connection c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "")) {
                PreparedStatement s = c.prepareStatement("INSERT INTO `produit` (`id`, `nom`, `photo`, `prixInitial`, `idP`) VALUES (NULL, ?, 'lien', ?, ?);");
                
                //String sql = "INSERT INTO `produit` (`id`, `nom`, `photo`, `prixInitial`, `idP`) VALUES (NULL, '"+this.getNom()+"', 'lien', '"+this.getPrix()+"', '1');";
                
                
                s.setString(1, this.getNom());
                s.setDouble(2, this.getPrix());
                s.setInt(3, this.getCodeProp());
                
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
    
    
}
