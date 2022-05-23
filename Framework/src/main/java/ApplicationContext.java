import Traitement.Grain;
import Traitement.Grains;
import Traitement.Proprietes;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicationContext {
    public static void main(String[] args) {
        try{
//            List<Grain> Grain = new ArrayList<Grain>();
//            Proprietes proprietes;
//            proprietes= new Proprietes("nom","ref");
//            Proprietes.add(new Proprietes("nom1","ref1"));
//            Grain.add(new Grain("1","2",Proprietes));
//            Grains grains = new Grains(Grain);
//            JAXBContext context = JAXBContext.newInstance(Grains.class);
//            Marshaller marcheller= context.createMarshaller();
//            marcheller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
//            marcheller.marshal(grains,new File("config.xml"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
