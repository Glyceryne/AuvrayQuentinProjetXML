package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin on 08/04/14.
 */
@XmlRootElement(name = "cvs")
public class CVList {
    private int nbCV;
    private List<CV> listCV;

    public CVList() {
        nbCV = 1;
        listCV = new ArrayList<CV>();
    }

    public List<CV> getListCV() {
        return listCV;
    }

    public void addCV(CV cv) {
        cv.setId(nbCV);
        nbCV++;
        this.listCV.add(cv);
    }

    public CV getCVById(int id) {
        for (CV cv : listCV) {
            if (cv.getId() == id) {
                return cv;
            }
        }
        return null;
    }
}
