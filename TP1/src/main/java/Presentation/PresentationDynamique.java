package Presentation;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PresentationDynamique {
    public static void main(String[] args) {
        IMetier metier ;
        IDao dao ;
        try {

            Scanner sc = new Scanner(new File("config.txt"));

            String daoClassName = sc.next();
            Class cdao = Class.forName(daoClassName);
            dao = (IDao) cdao.newInstance();

            String metierClassName = sc.next();
            Class cmetier = Class.forName(metierClassName);
            metier = (IMetier) cmetier.newInstance();

            Method mth= cmetier.getMethod("setDao",IDao.class);
            mth.invoke(metier,dao);

            System.out.println(metier.calculer());

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
