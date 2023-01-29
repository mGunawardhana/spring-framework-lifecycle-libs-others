package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/place_order")
public class PlaceOrderFormController {

    @GetMapping(path = "customer")
    public ResponseUtil getAllCustomersInToTheCombo() {
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        customerDTOS.add(new CustomerDTO("C001", "Maneesha", "US", "071-9065678"));
        customerDTOS.add(new CustomerDTO("C002", "Dinithi", "SL", "071-9048978"));
        customerDTOS.add(new CustomerDTO("C003", "Ann", "AUS", "071-9067578"));
        customerDTOS.add(new CustomerDTO("C004", "Helena", "France", "071-9067578"));
        customerDTOS.add(new CustomerDTO("C005", "Stefan", "SL", "071-9045765"));
        customerDTOS.add(new CustomerDTO("C006", "Stefan", "SL", "071-9045765"));
        return new ResponseUtil("OK", "Successfully Loaded ! ", customerDTOS);
    }

    @GetMapping("item")
    public ResponseUtil getAllItemsInToTheCombo() {
        List<ItemDTO> itemDTOS = new ArrayList<>();
        itemDTOS.add(new ItemDTO("I00-001", "Choco", 1000, 1250.00));
        itemDTOS.add(new ItemDTO("I00-002", "Milk", 1000, 1300.00));
        itemDTOS.add(new ItemDTO("I00-003", "Vanilla", 1000, 1200.00));
        itemDTOS.add(new ItemDTO("I00-004", "Strawberry", 1000, 1500.00));
        itemDTOS.add(new ItemDTO("I00-005", "MixFruit", 1000, 1750.00));
        return new ResponseUtil("OK", "Successfully Loaded ! ", itemDTOS);
    }


}
