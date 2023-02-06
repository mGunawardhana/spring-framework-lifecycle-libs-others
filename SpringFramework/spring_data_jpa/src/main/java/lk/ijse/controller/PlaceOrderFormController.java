package lk.ijse.controller;

import lk.ijse.dto.CustomerDTO;
import lk.ijse.dto.ItemDTO;
import lk.ijse.dto.OrderDTO;
import lk.ijse.entity.Item;
import lk.ijse.entity.OrderDetails;
import lk.ijse.entity.Orders;
import lk.ijse.service.PlaceOrderService;
import lk.ijse.util.ResponseUtil;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@CrossOrigin
@RequestMapping("/place_order")
public class PlaceOrderFormController {

    @Autowired
    public PlaceOrderService placeOrderService;


    @GetMapping(path = "/get_all_customers")
    public ResponseUtil getAllCustomersInToTheCombo(@ModelAttribute CustomerDTO customerDTO) {
        return new ResponseUtil("OK", "Successfully Loaded ! ", placeOrderService.loadAllCustomersInTheCombo());
    }

    @GetMapping("/get_all_items")
    public ResponseUtil getAllItemsInToTheCombo() {
        return new ResponseUtil("OK", "Successfully Loaded ! ", placeOrderService.loadAllItemsInTheCombo());
    }


    @GetMapping("/load_all_order_details_table")
    public ResponseUtil getOrderDetails() {
        return new ResponseUtil("OK", "Successfully Loaded ! ", "");
    }

    @GetMapping("/load_all_orders_table")
    public ResponseUtil getOrder() {
        return new ResponseUtil("OK", "Successfully Loaded ! ", "");
    }

    @PostMapping("/get_transaction_details")
    public ResponseUtil getTransActionDetails(@RequestBody OrderDTO orderDTO) {


        return new ResponseUtil("OK", "Order Confirmed!", "");
    }









/*    public String getOrderId() throws SQLException {
        ResultSet resultSet = orderList.get();
        if (resultSet.next()) {
            int tempId = Integer.parseInt(resultSet.getString(1).split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                return "O-00" + tempId;
            } else if (tempId <= 99) {
                return "O-0" + tempId;
            } else {
                return "O-" + tempId;
            }
        } else {
            return "O-001";
        }
    }*/


}
