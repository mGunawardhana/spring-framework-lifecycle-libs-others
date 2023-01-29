package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    @PostMapping
    public void saveCustomer(@ModelAttribute CustomerDTO customerDTO){
        System.out.println(customerDTO.toString());
    }

}
