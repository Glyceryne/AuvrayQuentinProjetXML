package model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        cv.formations.add("Licence 3 : Université de Rouen");
        cv.experiences.add("Stage IA-KAR");
        cv.langues.add("Français");
        cv.langues.add("Anglais");
        cv.competences.add("Java");
        cv.interets.add("Metal Celtique");
        cvList.addCV(cv);
    }

    public CVController() {

    }

    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public @ResponseBody CV getCVInXML(@PathVariable int id) {
        return cvList.getCVById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody String putCVInXML(@RequestBody CV cv) {
        cvList.addCV(cv);
        //return cv.getId();
        return "CV ajouté";
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody CVList getCVsInXML() {
        return cvList;
    }
}
