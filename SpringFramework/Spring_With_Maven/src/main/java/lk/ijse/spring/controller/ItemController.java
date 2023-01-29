package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemController {

    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO customerDTO) {
        System.out.println(customerDTO.toString());
        return new ResponseUtil("OK", "Success fully Registered !", null);
    }

    @DeleteMapping(params = "id")
    public ResponseUtil deleteCustomer(@RequestParam String id) {
        return new ResponseUtil("OK", "Success fully Deleted ! " + id, null);
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {
        return new ResponseUtil("OK", "Success fully updated ! " + customerDTO.getId(), null);
    }

    @GetMapping
    public ResponseUtil getAllCustomers() {
        List<CustomerDTO> list = new ArrayList<>();
        list.add(new CustomerDTO("C001", "Maneesha", "US", "071-9065678"));
        list.add(new CustomerDTO("C002", "Dinithi", "SL", "071-9048978"));
        list.add(new CustomerDTO("C003", "Ann", "AUS", "071-9067578"));
        list.add(new CustomerDTO("C004", "Helena", "France", "071-9067578"));
        list.add(new CustomerDTO("C005", "Stefan", "SL", "071-9045765"));

        return new ResponseUtil("OK", "Successfully Loaded ! ", list);
    }

}
