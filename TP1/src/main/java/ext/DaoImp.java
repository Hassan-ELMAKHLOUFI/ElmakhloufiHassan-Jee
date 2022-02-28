package ext;

import dao.IDao;
import org.springframework.stereotype.Component;

@Component("dao1")

public class DaoImp implements IDao {

    public double getValue() {
        System.out.println("version data base");
         return 20;
    }
}
