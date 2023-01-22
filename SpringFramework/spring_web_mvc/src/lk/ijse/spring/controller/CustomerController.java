package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    public CustomerController() {
        System.out.println("CustomerController");
    }

    @GetMapping
    public void callMe(){
        System.out.println("Call me method invoked !");
    }
}
