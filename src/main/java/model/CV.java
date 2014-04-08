package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Quentin on 08/04/14.
 */

@XmlRootElement(name = "cv")
public class CV {
    private String nom;
    private String prenom;


    public CV() {

    }

    public String getNom() {
        return nom;
    }

    @XmlElement
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    @XmlElement
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

}
