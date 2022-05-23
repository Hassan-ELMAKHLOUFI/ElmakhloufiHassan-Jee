import Traitement.Grains;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ApplicationMain {

    private  String FileName ;
    public ApplicationMain(String FileName){
        this.FileName = FileName ;
    }


    public Object getObjects () throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(Grains.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Grains grains =(Grains) unmarshaller.unmarshal(new File(FileName));
        return grains;
    }
}
