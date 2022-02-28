package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MetierImp implements IMetier{
    @Autowired
    @Qualifier("dao")
    IDao dao;

//    public MetierImp(IDao dao) {
//        this.dao = dao;
//    }

    public double calculer(){
        return  dao.getValue()*5/Math.sin(15);
    }
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
