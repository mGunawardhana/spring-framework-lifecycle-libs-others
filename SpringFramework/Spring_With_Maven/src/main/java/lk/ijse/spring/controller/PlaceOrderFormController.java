package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.dto.OrderDTO;
import lk.ijse.spring.dto.OrderDetailsDTO;
import lk.ijse.spring.util.ResponseUtil;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/place_order")
public class PlaceOrderFormController {

    //TODO load all customer details in to the combo box ...
    @GetMapping(path = "/get_all_customers")
    public ResponseUtil getAllCustomersInToTheCombo() {
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        customerDTOS.add(new CustomerDTO("C001", "Maneesha", "US", "071-9065678"));
        customerDTOS.add(new CustomerDTO("C002", "Dinithi", "SL", "071-9048978"));
        return new ResponseUtil("OK", "Successfully Loaded ! ", customerDTOS);
    }

    //TODO load all items details in to the combo box ...
    @GetMapping("/get_all_items")
    public ResponseUtil getAllItemsInToTheCombo() {
        List<ItemDTO> itemDTOS = new ArrayList<>();
        itemDTOS.add(new ItemDTO("I00-001", "Choco", 1000, 1250.00));
        itemDTOS.add(new ItemDTO("I00-002", "Milk", 1000, 1300.00));
        itemDTOS.add(new ItemDTO("I00-003", "Cookie", 1000, 1250.00));
        itemDTOS.add(new ItemDTO("I00-004", "Faludi", 1000, 1300.00));
        return new ResponseUtil("OK", "Successfully Loaded ! ", itemDTOS);
    }


    @GetMapping("/load_all_order_details_table")
    public ResponseUtil getOrderDetails() {
        ArrayList<OrderDetailsDTO> orderDetails = new ArrayList<>();
        orderDetails.add(new OrderDetailsDTO("O00-001", "I00-001", "Chocolate", 120.00, 12, 2000.00));
        orderDetails.add(new OrderDetailsDTO("O00-002", "I00-003", "Vanilla", 120.00, 12, 2000.00));
        orderDetails.add(new OrderDetailsDTO("O00-003", "I00-005", "Mix", 120.00, 12, 2000.00));
        orderDetails.add(new OrderDetailsDTO("O00-004", "I00-004", "Yogurt", 120.00, 12, 2000.00));
        return new ResponseUtil("OK", "Successfully Loaded ! ", orderDetails);
    }

    @GetMapping("/load_all_orders_table")
    public ResponseUtil getOrder(@RequestBody OrderDTO orderDTO) {
        ArrayList<OrderDTO> orders = getTransActionDetails(orderDTO);

        System.out.println(orderDTO.toString());
        orders.add(new OrderDTO(orderDTO.getOrder_id(), orderDTO.getOrder_date(), orderDTO.getCustomer_id(),
                orderDTO.getCustomer_name(), orderDTO.getCustomer_contact(),orderDTO.getFullObj().toString()));
        return new ResponseUtil("OK", "Successfully Loaded ! ", orders);
    }

    @SneakyThrows
    @PostMapping("/get_transaction_details")
    public ArrayList<OrderDTO> getTransActionDetails(@RequestBody OrderDTO orderDTO) {
        ArrayList<OrderDTO> orderDTOS = new ArrayList<OrderDTO>();
        orderDTOS.add(new OrderDTO(orderDTO.getOrder_id(), orderDTO.getOrder_date(), orderDTO.getCustomer_id(),
                orderDTO.getCustomer_name(), orderDTO.getCustomer_contact()));

        return orderDTOS;
    }

}
