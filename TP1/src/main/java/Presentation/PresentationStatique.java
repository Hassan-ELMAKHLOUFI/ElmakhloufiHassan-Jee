package Presentation;

import doa.DaoImp;
import doa.IDao;
import metier.MetierImp;

public class PresentationStatique {
    public static void main(String[] args) {
        // version data base
        IDao dao =new DaoImp();
        MetierImp metier  = new MetierImp();
        metier.setDao(dao);
        System.out.println(metier.calculer());
        System.out.println("-----------------");

        //version capture
        IDao dao1 =new ext.DaoImp();
        ext.MetierImp metier1  = new ext.MetierImp();
        metier1.setDao(dao1);
        System.out.println(metier1.calculer());
    }
}
