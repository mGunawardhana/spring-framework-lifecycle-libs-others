package lk.ijse.controller;

import lk.ijse.db.DB;
import lk.ijse.dto.CustomerDTO;
import lk.ijse.dto.ItemDTO;
import lk.ijse.entity.Customer;
import lk.ijse.repo.CustomerRepo;
import lk.ijse.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping("save_customer")
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getId())){
            throw new RuntimeException("Customer Already Exist !");
        }else {
            customerRepo.save(new Customer(
                    customerDTO.getId(),
                    customerDTO.getName(),
                    customerDTO.getAddress(),
                    customerDTO.getContact()));
        }
        return new ResponseUtil("OK", "Successfully Registered !", "");
    }



    @PutMapping("update_customer")
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {

        return new ResponseUtil("OK", "Successfully updated ! " + customerDTO.getId(), "");
    }

    @GetMapping("customer")
    public ResponseUtil getAllCustomers() {
        List<Customer> customerList = customerRepo.findAll();
        return new ResponseUtil("OK", "Successfully Loaded ! ",customerList);
    }

    @DeleteMapping
    public ResponseUtil deleteCustomer(String code) {

        return new ResponseUtil("OK", "Successfully Deleted ! " + code, null);
    }
}
