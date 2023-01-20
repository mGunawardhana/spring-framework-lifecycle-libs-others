package lk.ijse.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"lk.ijse.spring.pojo","lk.ijse.spring.controller"})


public class WebAppConfig {

    public WebAppConfig() {
        System.out.println("WebAppConfig Instantiated !");
    }
}
