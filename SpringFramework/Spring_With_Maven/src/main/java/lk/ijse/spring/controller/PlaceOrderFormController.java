package lk.ijse.spring.controller;

import lk.ijse.spring.dto.OrderDTO;
import lk.ijse.spring.dto.OrderDetailsDTO;
import lk.ijse.spring.util.ResponseUtil;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static lk.ijse.spring.db.DB.*;

@RestController
@CrossOrigin
@RequestMapping("/place_order")
public class PlaceOrderFormController {

    @GetMapping(path = "/get_all_customers")
    public ResponseUtil getAllCustomersInToTheCombo() {
        return new ResponseUtil("OK", "Successfully Loaded ! ", customerList);
    }

    @GetMapping("/get_all_items")
    public ResponseUtil getAllItemsInToTheCombo() {
        return new ResponseUtil("OK", "Successfully Loaded ! ", itemList);
    }


    @GetMapping("/load_all_order_details_table")
    public ResponseUtil getOrderDetails() {
        return new ResponseUtil("OK", "Successfully Loaded ! ", order_details_list);
    }

/*    @GetMapping("/load_all_orders_table")
    public ResponseUtil getOrder(@RequestBody OrderDTO orderDTO) {

        ArrayList<OrderDTO> order = new ArrayList<OrderDTO>();


        orderList.add(orderDTO);

        return new ResponseUtil("OK", "Successfully Loaded ! ", orderList);
    }*/

    @SneakyThrows
    @PostMapping("/get_transaction_details")
    public ResponseUtil getTransActionDetails(@RequestBody OrderDTO orderDTO) {

        List<OrderDetailsDTO> orderDetailsDTOList = orderDTO.getFullObj();

        for (OrderDetailsDTO orderDetailsDTO : orderDetailsDTOList) {

            order_details_list.add(orderDetailsDTO);
        }
        orderList.add(orderDTO);
        return new ResponseUtil("OK", "Order Confirmed!", orderDTO);
    }

}
