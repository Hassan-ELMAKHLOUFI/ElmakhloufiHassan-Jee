package Presentation;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresentationAnnotation {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("dao","metier","ext");
        IMetier metier =ctx.getBean(IMetier.class);
        System.out.println(metier.calculer());
    }
}
