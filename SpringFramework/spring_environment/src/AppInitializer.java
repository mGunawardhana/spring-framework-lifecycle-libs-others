import lk.ijse.spring.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Properties;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        ctx.registerShutdownHook();


        //getting OS environment variable
        Map<String, String> getenv = System.getenv();
        for (String s : getenv.keySet()) {
            String val = getenv.get(s);
            System.out.println(s + " " + val);
        }

        System.out.println("================================");

        //Java Environment Variable
        Properties properties = System.getProperties();
        for (Object key : properties.keySet()) {
            Object value = properties.get(key);
            System.out.println(key + " " + value);
        }

    }
}
