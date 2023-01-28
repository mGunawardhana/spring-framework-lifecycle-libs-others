package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/customers")
@CrossOrigin
public class ControllerThirteen {

    @PutMapping
    public void saveCustomer(@ModelAttribute CustomerDTO customerDTO) {
        System.out.println(customerDTO.toString());
        System.out.println("Wade Goda");
    }

}
