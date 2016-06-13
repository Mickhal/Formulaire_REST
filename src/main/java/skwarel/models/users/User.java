package skwarel.models.users;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by mickael on 07/06/16.
 */
public class User implements Serializable{
    private String nom;
    private String prenom;
    private String genre;
    private String dateNaissance;
    private String email;
    private long id;

    public User(String nom, String prenom, String genre, String dateNaissance, String email, long id) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
