package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin on 08/04/14.
 */

@XmlRootElement(name = "cv")
@XmlType(propOrder = {"id", "nom", "prenom", "age", "adresse",
        "formations", "experiences", "langues", "competences", "interets"})
public class CV {
    private int id;
    private String nom;
    private String prenom;
    private int age;
    private String adresse;

    @XmlElementWrapper(name = "formations")
    @XmlElement(name = "formation")
    protected List<String> formations;

    @XmlElementWrapper(name = "experiences")
    @XmlElement(name = "experience")
    protected List<String> experiences;

    @XmlElementWrapper(name = "langues")
    @XmlElement(name = "langue")
    protected List<String> langues;

    @XmlElementWrapper(name = "competences")
    @XmlElement(name = "competence")
    protected List<String> competences;

    @XmlElementWrapper(name = "interets")
    @XmlElement(name = "interet")
    protected List<String> interets;

    public CV() {
        this.nom = "";
        this.prenom = "";
        this.adresse = "";
        this.formations = new ArrayList<String>();
        this.experiences = new ArrayList<String>();
        this.langues = new ArrayList<String>();
        this.competences = new ArrayList<String>();
        this.interets = new ArrayList<String>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
