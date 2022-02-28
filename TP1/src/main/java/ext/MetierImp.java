package ext;

import dao.IDao;
import metier.IMetier;

public class MetierImp implements IMetier {
    private IDao dao;

    public double calculer(){
        return  dao.getValue()*5/Math.sin(15);
    }
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
