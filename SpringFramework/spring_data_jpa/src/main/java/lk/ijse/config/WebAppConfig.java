package lk.ijse.config;


import lk.ijse.spring.advisor.AppWideExceptionHandler;
import lk.ijse.spring.controller.CustomerController;
import lk.ijse.spring.controller.ItemController;
import lk.ijse.spring.controller.PlaceOrderFormController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {CustomerController.class, ItemController.class, PlaceOrderFormController.class, AppWideExceptionHandler.class})
public class WebAppConfig {
}
