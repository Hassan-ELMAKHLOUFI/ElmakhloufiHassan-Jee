package Annotation;

import Annotation.ToScan.main;
import Annotation.ToScan.valids;
import org.burningwave.core.assembler.ComponentContainer;
import org.burningwave.core.classes.ClassHunter;
import org.burningwave.core.classes.SearchConfig;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class test {


    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        int i = 0;
        //Hashmap to store beans
        
        HashMap<String, Object> store = new HashMap<>();
        HashMap<Class, Object> fieldStore = new HashMap<>();
        for (Class c : getClasses("Annotation.ToScan", false)) {
            // Field classMemberField = valids.class.getDeclaredField("classMember");
            //prepare the store
            for (Annotation ann : c.getAnnotations()) {
                if (ann instanceof Composant) {   // make sure it's your annotation
                    String s[] = c.getName().split("\\.");
                    if (s.length != 0)
                        store.put(s[s.length - 1], c.newInstance());

                }
            }
            Field[] fields = c.getDeclaredFields();
            for (int j = 0; j < fields.length; j++) {
                Annotation[] annotations = fields[j].getDeclaredAnnotations();
                //checking if the field is annotated

                if (annotations.length != 0) {

                    fieldStore.put(fields[j].getType(), fields[j]);
                }
            }
            System.out.println(fieldStore);
            int k = 0;

            for (int j = 0; j < fieldStore.size(); j++) {

                System.out.println("size" + fieldStore.size());
            }

            for (Map.Entry fi : fieldStore.entrySet()) {
                //System.out.println(fi.getName());
                for (String nom : store.keySet()) {
                    Class cls = Class.forName("Annotation.ToScan." + nom);
                    Class cs = (Class) fi.getKey();
                    if (cs.isAssignableFrom(cls)) {

                        Field f = (Field) fi.getValue();

                        Object ob = f.getDeclaringClass().newInstance();
                        f.setAccessible(true);
                        main m = new main();
                        f.set(ob, m);
                        valids v = (valids) ob;
                        ((valids) ob).getNumero().test();
                        store.put(((Class<?>) fi.getKey()).getName(), ob);
                    }
                }
            }

            //test
            for (Map.Entry fi : store.entrySet()) {
                fi.getValue().toString();
            }

        }

        i++;
    }

    public static Class<?>[] getClasses(String packageName, boolean recursive) throws ClassNotFoundException, IOException {
        ComponentContainer componentConatiner = ComponentContainer.getInstance();
        ClassHunter classHunter = componentConatiner.getClassHunter();
        String packageRelPath = packageName.replace(".", "/");
        SearchConfig config = SearchConfig.forResources(
                packageRelPath
        );
        if (!recursive) {
            config.findInChildren();
        }

        try (ClassHunter.SearchResult result = classHunter.findBy(config)) {
            Collection<Class<?>> classes = result.getClasses();
            return classes.toArray(new Class[classes.size()]);
        }
    }
// testing dependency injection using  constructors
 //testing dependency injnection using setters

}
