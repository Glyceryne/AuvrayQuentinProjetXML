package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Quentin on 08/04/14.
 */
@XmlRootElement(name = "cvs")
public class CVList {
    private List<CV> list;

    public CVList() {

    }

    public CVList(List<CV> l) {
        this.list = l;
    }

    public List<CV> getList() {
        return list;
    }

    @XmlElement
    public void setList(List<CV> l) {
        this.list = l;
    }

    public void add(CV r) {
        this.list.add(r);
    }

}
