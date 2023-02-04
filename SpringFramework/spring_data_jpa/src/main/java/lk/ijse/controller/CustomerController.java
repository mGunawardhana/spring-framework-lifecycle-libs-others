package lk.ijse.controller;

import lk.ijse.db.DB;
import lk.ijse.dto.CustomerDTO;
import lk.ijse.dto.ItemDTO;
import lk.ijse.entity.Customer;
import lk.ijse.repo.CustomerRepo;
import lk.ijse.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("save_customer")
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getId())){
            throw new RuntimeException("Customer Already Exist !");
        }else {
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
        }
        return new ResponseUtil("OK", "Successfully Registered !", "");
    }



    @PutMapping("update_customer")
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getId())){
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
        }else {
            throw new RuntimeException("Cannot find these customer id !");
        }
        return new ResponseUtil("OK", "Successfully updated ! " + customerDTO.getId(), "");
    }

    @GetMapping("customer")
    public ResponseUtil getAllCustomers() {
        ArrayList<CustomerDTO> mapper= modelMapper.map(
                customerRepo.findAll(), new TypeToken<ArrayList<CustomerDTO>>() {}.getType());
        return new ResponseUtil("OK", "Successfully Loaded ! ",mapper);
    }

    @DeleteMapping
    public ResponseUtil deleteCustomer(String code) {
        if (customerRepo.existsById(code)){
            customerRepo.deleteById(code);
        }else{
            throw new RuntimeException("No such a customer !");
        }
        return new ResponseUtil("OK", "Successfully Deleted ! " + code, null);
    }
}
