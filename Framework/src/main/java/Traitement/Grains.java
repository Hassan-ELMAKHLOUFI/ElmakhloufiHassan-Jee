package Traitement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Grains {

    List<Grain> grain;

    public Grains(){

  }
    public Grains(List<Grain> grainlist) {
        this.grain = grainlist;
    }

    public List<Grain> getGrainlist() {
        return grain;
    }

    public void setGrainlist(List<Grain> grainlist) {
        this.grain = grainlist;
    }

    @Override
    public String toString() {
        return "Grains{" +
                "grain=" + grain +
                '}';
    }
}
