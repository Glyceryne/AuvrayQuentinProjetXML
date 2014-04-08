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
        cv.setPrenom("quentin");
        cv.setNom("auvray");
        List<CV> list = new ArrayList<CV>();
        list.add(cv);
        cvList.setList(list);
    }

    @RequestMapping(value="{nom}", method = RequestMethod.GET)
    public @ResponseBody
    CV getCVInXML(@PathVariable String nom) {

        return new CV();
    }

    @RequestMapping(value="{cv}", method = RequestMethod.PUT)
    public @ResponseBody void putCVInXML(@PathVariable CV cv) {
        cvList.add(cv);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    CVList getCVsInXML() {
        return cvList;
    }
}
