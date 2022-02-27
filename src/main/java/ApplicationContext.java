import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Date;

public class ApplicationContext {
    public static void main(String[] args) {
        try{
            compte cp = new compte(1234, 12.45, new Date(1999, 12, 12));
            JAXBContext context = JAXBContext.newInstance(compte.class);
            Marshaller marcheller= context.createMarshaller();
            marcheller.marshal(cp,new File("compte.xml"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
