import Traitement.*;

import javax.sound.sampled.Line;
import javax.xml.bind.JAXBException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class Developer {

    public static void main(String[] args) throws JAXBException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {


        HashMap<InfoObjet,Object> objects = new HashMap<>();
        ApplicationMain app = new ApplicationMain("Config.xml");
        Grains grs =(Grains)app.getObjects();
        Boolean created;

        for (Grain grain:grs.getGrainlist()) {
            created=false ;
            Class gr = Class.forName(grain.getClasse());

            List<Proprietes> p1 = grain.getPropriete();
            Constructeur ctr = grain.getContructeur();

//            if(p1!=null) {
//
//                Object a =  gr.newInstance();
//                objects.put(new InfoObjet(grain.getClasse(),grain.getId()),a);
//                for(Proprietes p:p1)
//                if (p.getValue()==null) {
//                    for (InfoObjet j : (Set<InfoObjet>) objects.keySet()) {
//                        if (p.getRef().equals(j.getId())) {
//                            Class inj = Class.forName(j.getClasse());
//                            Method mth = gr.getMethod("set" + p.getNom(), inj);
//                            mth.invoke(a, objects.get(j));
//                        }
//                    }
//                    created=true;
//                }else{
//                    Method mth = gr.getMethod("set" + p.getNom(),String.class);
//                    mth.invoke(a, p.getValue());
//                        created=true;
//                }
//            }
            if(ctr!=null){
                    InfoObjet tmpKey=null ;
                    Object tmpValue=null ;
                    for (InfoObjet j : (Set<InfoObjet>) objects.keySet()) {
                        if (ctr.getRef().equals(j.getId())) {
                             tmpValue =objects.get(j);
                             tmpKey =j;
                        }
                    }
                System.out.println(tmpKey.getClasse());
                Class inj = Class.forName(tmpKey.getClasse());
                Class<?> cl = Class.forName(grain.getClasse());
                Constructor<?> cons = cl.getConstructor(inj);
                Object o = cons.newInstance(tmpValue);
                objects.put(new InfoObjet(grain.getClasse(),grain.getId()),o);
                created=true;
                }

//            version proprties access without setters
            if(p1!=null) {
                Object a = gr.newInstance();
                objects.put(new InfoObjet(grain.getClasse(), grain.getId()), a);
                for (Proprietes p : p1)
                    if (p.getValue() == null) {
                        for (InfoObjet j : (Set<InfoObjet>) objects.keySet()) {
                            if (p.getRef().equals(j.getId())) {
                                Class inj = Class.forName(j.getClasse());
                                Class<?> c = a.getClass();
                                Field f = c.getDeclaredField(p.getNom());
                                f.setAccessible(true);
                                f.set(a,objects.get(j));
                            }
                        }
                    } else {
                        Class<?> c = a.getClass();
                        Field f = c.getDeclaredField(p.getNom());
                        f.setAccessible(true);
                        f.set(a,p.getValue());
                    }
            created=true;
            }
            if(created==false){
                Object a =  gr.newInstance();
            }
            }
        }

    }

