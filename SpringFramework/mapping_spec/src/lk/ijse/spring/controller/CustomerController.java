package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @PostMapping
    public void saveCustomer(@ModelAttribute CustomerDTO customerDTO) {
        System.out.println(customerDTO.toString());
        System.out.println("Wade Goda");
    }

}
