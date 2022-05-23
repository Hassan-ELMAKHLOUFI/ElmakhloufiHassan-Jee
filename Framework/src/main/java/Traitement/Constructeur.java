package Traitement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Constructeur {
    @XmlAttribute
    String ref ;
    @XmlAttribute
    String name ;

    public Constructeur(String ref, String name) {
        this.ref = ref;
        this.name = name;
    }

    public Constructeur() {

    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
