package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO customerDTO) {
        System.out.println(customerDTO.toString());
        return new ResponseUtil("OK", "Success fully Registered !", null);
    }

    @DeleteMapping(params = "id")
    public ResponseUtil deleteCustomer(@RequestParam String id) {
        return new ResponseUtil("OK", "Success fully Deleted ! " + id, null);
    }


}
