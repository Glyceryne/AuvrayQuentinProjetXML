package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Quentin on 08/04/14.
 */

@XmlRootElement(name = "cv")
public class CV {
    private int id;
    private String nom;
    private String prenom;
    private int age;
    private String adresse;
    private List<String> formations;
    private List<String> experiences;
    private List<String> langues;
    private List<String> competences;
    private List<String> interets;

    public CV() {

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

    public List<String> getFormations() {
        return formations;
    }

    public void setFormations(List<String> formations) {
        this.formations = formations;
    }

    public List<String> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<String> experiences) {
        this.experiences = experiences;
    }

    public List<String> getLangues() {
        return langues;
    }

    public void setLangues(List<String> langues) {
        this.langues = langues;
    }

    public List<String> getCompetences() {
        return competences;
    }

    public void setCompetences(List<String> competences) {
        this.competences = competences;
    }

    public List<String> getInterets() {
        return interets;
    }

    public void setInterets(List<String> interets) {
        this.interets = interets;
    }

}
