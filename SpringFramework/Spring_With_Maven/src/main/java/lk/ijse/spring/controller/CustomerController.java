package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static lk.ijse.spring.db.DB.customerList;

@RestController
@CrossOrigin
@RequestMapping("customer")
public class CustomerController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("save_customer")
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO customerDTO) {
        customerList.add(customerDTO);
        /** if (customerDTO.getId().equals("C001")) {
         throw new RuntimeException("All ready have this id");
         }*/
        return new ResponseUtil("OK", "Successfully Registered !", null);
    }

    //TODO delete customer method error message problem detected correct these cases...
    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteCustomer(@RequestParam String id) {
      /*  if (id.equals("C001")) {
            throw new RuntimeException("Wrong id");
        }*/
        return new ResponseUtil("OK", "Successfully Deleted ! " + id, null);
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
        if (customerList.isEmpty()) {
            customerList.add(new CustomerDTO("C001", "Maneesha", "US", "071-9065678"));
            customerList.add(new CustomerDTO("C002", "Dinithi", "SL", "071-9048978"));
            customerList.add(new CustomerDTO("C003", "Ann", "US", "071-9043278"));
            customerList.add(new CustomerDTO("C004", "Stefan", "SL", "071-9041238"));
        }
        return new ResponseUtil("OK", "Successfully Loaded ! ", customerList);
    }

}
