package config;

import controller.CustomerController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses ={CustomerController.class})
public class WebAppConfig {

    public void shutdown(){
        System.out.println("Shut down");
    }
}
