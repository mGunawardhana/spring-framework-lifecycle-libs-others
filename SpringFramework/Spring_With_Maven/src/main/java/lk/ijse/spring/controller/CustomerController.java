package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static lk.ijse.spring.db.DB.customerDTO;

@RestController
@CrossOrigin
@RequestMapping("customer")
public class CustomerController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO customerDTO) {
        System.out.println(customerDTO.toString());
        if (customerDTO.getId().equals("C001")) {
            throw new RuntimeException("All ready have this id");
        }
        return new ResponseUtil("OK", "Successfully Registered !", null);
    }

    //TODO delete customer method error message problem detected correct these cases...
    @DeleteMapping(params = {"search_by_id"})
    public ResponseUtil deleteCustomer(@RequestParam String search_by_id) {
        if (search_by_id.equals("C001")) {
            throw new RuntimeException("Wrong id");
        }
        return new ResponseUtil("OK", "Successfully Deleted ! " + search_by_id, null);
    }

    @PutMapping()
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {
        if (customerDTO.getId().equals("C001")) {
            throw new RuntimeException("this id haven't in database");
        }
        return new ResponseUtil("OK", "Successfully updated ! " + customerDTO.getId(), null);
    }

    @GetMapping("customer")
    public ResponseUtil getAllCustomers() {
        customerDTO.add(new CustomerDTO("C001", "Maneesha", "US", "071-9065678"));
        customerDTO.add(new CustomerDTO("C002", "Dinithi", "SL", "071-9048978"));
        return new ResponseUtil("OK", "Successfully Loaded ! ", customerDTO);
    }

}
