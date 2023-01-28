package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/customer")
@CrossOrigin
public class ControllerThirteen {

    @PutMapping
    public ArrayList<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        allCustomers.add(new CustomerDTO("C00-001","Maneesha","Galle","071-9076652"));
        allCustomers.add(new CustomerDTO("C00-002","Deumi","Galle","071-9074342"));
        allCustomers.add(new CustomerDTO("C00-003","Savindi","Galle","071-9232652"));
        allCustomers.add(new CustomerDTO("C00-004","Pathumi","Galle","071-9233652"));
        allCustomers.add(new CustomerDTO("C00-005","Ameesha","Galle","071-9065652"));
        allCustomers.add(new CustomerDTO("C00-006","Kasuni","Galle","071-9074352"));
        return allCustomers;
    }

}
