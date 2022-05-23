package Traitement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Proprietes {

    @XmlAttribute
    String nom ;

    @XmlAttribute
    String ref ;

    @XmlAttribute
    String value ;
    public Proprietes(String nom, String ref) {
        this.nom = nom;
        this.ref = ref;
    }

    public Proprietes(String nom, String value,int i) {
        this.nom = nom;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Proprietes() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    @Override
    public String toString() {
        return "Proprietes{" +
                "nom='" + nom + '\'' +
                ", ref='" + ref + '\'' +
                '}';
    }
}
