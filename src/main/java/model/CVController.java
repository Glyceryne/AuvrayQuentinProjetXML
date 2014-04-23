package model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin on 08/04/14.
 */
@Controller
@RequestMapping("/cv")
public class CVController {
    private static CVList cvList = new CVList();

    static {
        cvList = new CVList();
        CV cv = new CV();
        cv.setPrenom("Quentin");
        cv.setNom("Auvray");
        cv.setAge(21);
        cv.setAdresse("1 allée des Prunus");
        List<String> formations = new ArrayList<String>();
        formations.add("Licence 3 : Université de Rouen");
        cv.setFormations(formations);
        List<String> experiences = new ArrayList<String>();
        experiences.add("Stage IA-KAR");
        cv.setExperiences(experiences);
        List<String> langues = new ArrayList<String>();
        langues.add("Français");
        langues.add("Anglais");
        cv.setLangues(langues);
        List<String> competences = new ArrayList<String>();
        competences.add("Java");
        cv.setCompetences(competences);
        List<String> interets = new ArrayList<String>();
        interets.add("Metal Celtique");
        cv.setInterets(interets);
        cvList.addCV(cv);
    }

    public CVController() {

    }

    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public @ResponseBody CV getCVInXML(@PathVariable int id) {
        return cvList.getCVById(id);
    }

    @RequestMapping(value="{cv}", method = RequestMethod.PUT)
    public @ResponseBody void putCVInXML(@PathVariable CV cv) {
        cvList.addCV(cv);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody CVList getCVsInXML() {
        return cvList;
    }
}
