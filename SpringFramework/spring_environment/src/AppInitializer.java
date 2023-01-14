import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register();
        ctx.refresh();
        ctx.registerShutdownHook();


        Map<String, String> getenv = System.getenv();
        for (String s:getenv.keySet()) {
            String val = getenv.get(s);
            System.out.println(val);
        }

    }
}
