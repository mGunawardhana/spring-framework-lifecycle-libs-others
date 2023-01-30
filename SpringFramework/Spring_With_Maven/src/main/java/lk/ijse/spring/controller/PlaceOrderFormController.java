package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.dto.OrderDTO;
import lk.ijse.spring.dto.OrderDetailsDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/place_order")
public class PlaceOrderFormController {

    @GetMapping(path = "/get_all_customers")
    public ResponseUtil getAllCustomersInToTheCombo() {
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        customerDTOS.add(new CustomerDTO("C001", "Maneesha", "US", "071-9065678"));
        customerDTOS.add(new CustomerDTO("C002", "Dinithi", "SL", "071-9048978"));
        return new ResponseUtil("OK", "Successfully Loaded ! ", customerDTOS);
    }

    @GetMapping("/get_all_items")
    public ResponseUtil getAllItemsInToTheCombo() {
        List<ItemDTO> itemDTOS = new ArrayList<>();
        itemDTOS.add(new ItemDTO("I00-001", "Choco", 1000, 1250.00));
        itemDTOS.add(new ItemDTO("I00-002", "Milk", 1000, 1300.00));
        return new ResponseUtil("OK", "Successfully Loaded ! ", itemDTOS);
    }

    @GetMapping("/load_all_orders_table")
    public ResponseUtil getOrder() {
        ArrayList<OrderDTO> orders = new ArrayList<>();
        orders.add(new OrderDTO("O00-001","2021/2/12","C00-001","Siva","071-3985521"));
        orders.add(new OrderDTO("O00-002","2021/2/12","C00-004","Lakshmi","071-3983221"));
        return new ResponseUtil("OK", "Successfully Loaded ! ", orders);

    }


    @GetMapping("/load_all_order_details_table")
    public ResponseUtil getOrderDetails() {
        ArrayList<OrderDetailsDTO> orderDetails = new ArrayList<>();
        orderDetails.add(new OrderDetailsDTO("O00-001","I00-001","Chocolate",120.00,12,2000.00));
        orderDetails.add(new OrderDetailsDTO("O00-002","I00-003","Vanilla",120.00,12,2000.00));

        return new ResponseUtil("OK", "Successfully Loaded ! ", orderDetails);
    }


    @PostMapping("/get_transaction_details")
    public void getTransActionDetails(
            @RequestBody OrderDetailsDTO orderDetailsDTO,
            @RequestBody OrderDTO orderDTO) {
        System.out.println(orderDetailsDTO.toString());
        System.out.println(orderDTO.toString());
    }

}
