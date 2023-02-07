package lk.ijse.controller;

import lk.ijse.dto.CustomerDTO;
import lk.ijse.service.CustomerService;
import lk.ijse.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    public CustomerService customerService;

    //TODO test this method after the lec ...
    @GetMapping(path = "{name}")
    public ResponseUtil getCustomerByName(@PathVariable String name){
        return new ResponseUtil("OK", "Successfully Registered !", customerService.searchCustomerByName(name));
    }

    @PostMapping("save_customer")
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO customerDTO) {
        customerService.saveCustomer(customerDTO);
        return new ResponseUtil("OK", "Successfully Registered !", "");
    }

    @PutMapping("update_customer")
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomer(customerDTO);
        return new ResponseUtil("OK", "Successfully updated ! " + customerDTO.getId(), "");
    }

    @GetMapping("customer")
    public ResponseUtil getAllCustomers() {
        return new ResponseUtil("OK", "Successfully Loaded ! ", customerService.getAllCustomers());
    }

    @DeleteMapping
    public ResponseUtil deleteCustomer(String code) {
        customerService.deleteCustomer(code);
        return new ResponseUtil("OK", "Successfully Deleted ! " + code, "");
    }
}
