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

    @RequestMapping(value="{nom}", method = RequestMethod.GET)
    public @ResponseBody
    CV getResumeInXML(@PathVariable String nom) {
        CV cv = new CV();
        cv.setNom(nom);
        cv.setPrenom("quentin");
        return cv;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    CVList getResumesInXML() {
        List l = new ArrayList();
        CVList cvList = new CVList(l);
        return cvList;
    }
}