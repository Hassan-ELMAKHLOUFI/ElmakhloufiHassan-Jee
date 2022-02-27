import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ApplicationMain {

    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(compte.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        compte compte =(compte) unmarshaller.unmarshal(new File("compte.xml"));
        System.out.println(compte);
    }
}
