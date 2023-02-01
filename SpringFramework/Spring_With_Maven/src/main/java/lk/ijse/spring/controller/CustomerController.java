package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import static lk.ijse.spring.db.DB.customerList;

@RestController
@CrossOrigin
@RequestMapping("customer")
public class CustomerController {

    @PostMapping("save_customer")
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO customerDTO) {
        customerList.add(customerDTO);
        return new ResponseUtil("OK", "Successfully Registered !", "");
    }

    public CustomerDTO ifExistsCustomer(String code) {
        for (CustomerDTO customerDTO : customerList) {
            if (customerDTO.getId().equals(code)) {
                return customerDTO;
            }
        }
        return null;
    }

    @PutMapping("update_customer")
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO searchCustomer = ifExistsCustomer(customerDTO.getId());
        if (searchCustomer != null) {
            searchCustomer.setName(customerDTO.getName());
            searchCustomer.setAddress(customerDTO.getAddress());
            searchCustomer.setContact(customerDTO.getContact());
        } else {
            throw new RuntimeException("Cannot update item");
        }
        return new ResponseUtil("OK", "Successfully updated ! " + customerDTO.getId(), "");
    }

    @GetMapping("customer")
    public ResponseUtil getAllCustomers() {
        if (customerList.isEmpty()) {
            customerList.add(new CustomerDTO("C001", "Maneesha", "US", "071-9065678"));
            customerList.add(new CustomerDTO("C002", "Dinithi", "SL", "071-9048978"));
        }
        return new ResponseUtil("OK", "Successfully Loaded ! ", customerList);
    }

    @DeleteMapping
    public ResponseUtil deleteCustomer(String code) {
        CustomerDTO customerDTO = ifExistsCustomer(code);
        if (customerDTO != null) {
            customerList.remove(customerDTO);
        } else {
            throw new RuntimeException("Can't find customer");
        }
        return new ResponseUtil("OK", "Successfully Deleted ! " + code, null);
    }
}
