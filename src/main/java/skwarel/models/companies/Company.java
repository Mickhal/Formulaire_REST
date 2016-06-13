package skwarel.models.companies;

import java.io.Serializable;

/**
 * Created by mickael on 07/06/16.
 */
public class Company implements Serializable{
    private String nom;
    private String numero;
    private String nbEmploye;

    public Company(String nom, String numero, String nbEmploye, String email, String adresse) {
        this.nom = nom;
        this.numero = numero;
        this.nbEmploye = nbEmploye;
        this.email = email;
        this.adresse = adresse;
    }

    private String email;
    private String adresse;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNbEmploye() {
        return nbEmploye;
    }

    public void setNbEmploye(String nbEmploye) {
        this.nbEmploye = nbEmploye;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
