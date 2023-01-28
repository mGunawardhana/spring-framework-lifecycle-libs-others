package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @PostMapping
    public void saveCustomer() {
        System.out.println("id " + id + " name " + name + " address " + address + " contact " + contact);
        System.out.println("Wade Goda");
    }

}
