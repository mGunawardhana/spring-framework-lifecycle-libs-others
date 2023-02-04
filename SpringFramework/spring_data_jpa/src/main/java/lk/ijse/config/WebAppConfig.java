package lk.ijse.config;


import lk.ijse.advisor.AppWideExceptionHandler;
import lk.ijse.controller.CustomerController;
import lk.ijse.controller.ItemController;
import lk.ijse.controller.PlaceOrderFormController;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {CustomerController.class, ItemController.class, PlaceOrderFormController.class, AppWideExceptionHandler.class})
public class WebAppConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
