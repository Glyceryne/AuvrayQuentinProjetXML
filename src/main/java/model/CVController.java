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
    private CVList cvList;

    public CVController() {
        CVList cvList = new CVList();
        CV cv = new CV();
        cv.setPrenom("quentin");
        cv.setNom("auvray");
        cvList.add(cv);
    }

    @RequestMapping(value="{nom}", method = RequestMethod.GET)
    public @ResponseBody
    CV getResumeInXML(@PathVariable String nom) {

        return new CV();
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    CVList getResumesInXML() {
        return cvList;
    }
}
