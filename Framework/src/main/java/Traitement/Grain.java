package Traitement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Grain {
    @XmlAttribute
    String id ;
    @XmlAttribute
    String  classe;

    List<Proprietes> propriete;
    Constructeur constructeur ;

    public Grain(String id, String classe, List<Proprietes> proprietes) {
        this.id = id;
        this.classe = classe;
        this.propriete = proprietes;
    }

    public Grain(String id, String classe, Constructeur contructeur) {
        this.id = id;
        this.classe = classe;
        this.constructeur = contructeur;
    }

    public Grain() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public List<Proprietes> getPropriete() {
        return propriete;
    }

    public void setPropriete(List<Proprietes> propriete) {
        this.propriete = propriete;
    }

    public Constructeur getContructeur() {
        return constructeur;
    }

    public void setContructeur(Constructeur contructeur) {
        this.constructeur = contructeur;
    }

    @Override
    public String toString() {
        return "Grain{" +
                "id='" + id + '\'' +
                ", classe='" + classe + '\'' +
                ", propriete=" + propriete +
                '}';
    }
}
