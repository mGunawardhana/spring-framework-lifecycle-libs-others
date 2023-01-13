package lk.ijse.spring;

import lk.ijse.spring.config.AppConfig;
import lk.ijse.spring.pojo.PojoOne;
import lk.ijse.spring.pojo.PojoThree;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        ctx.registerShutdownHook();


        PojoOne po1 = ctx.getBean(PojoOne.class);
        System.out.println(po1);
        PojoOne po2 = ctx.getBean(PojoOne.class);
        System.out.println(po2);
        PojoOne po3 = ctx.getBean(PojoOne.class);
        System.out.println(po3);
    }
}
