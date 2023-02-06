package lk.ijse.controller;

import lk.ijse.dto.CustomerDTO;
import lk.ijse.dto.ItemDTO;
import lk.ijse.dto.OrderDTO;
import lk.ijse.dto.OrderDetailsDTO;
import lk.ijse.entity.Item;
import lk.ijse.entity.OrderDetails;
import lk.ijse.entity.Orders;
import lk.ijse.repo.CustomerRepo;
import lk.ijse.repo.ItemRepo;
import lk.ijse.repo.OrderDetailsRepo;
import lk.ijse.repo.OrderRepo;
import lk.ijse.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@CrossOrigin
@RequestMapping("/place_order")
public class PlaceOrderFormController {





    @GetMapping(path = "/get_all_customers")
    public ResponseUtil getAllCustomersInToTheCombo(@ModelAttribute CustomerDTO customerDTO) {

        return new ResponseUtil("OK", "Successfully Loaded ! ", mapper);
    }

    @GetMapping("/get_all_items")
    public ResponseUtil getAllItemsInToTheCombo() {
        ArrayList<ItemDTO> mapper = modelMapper.map(itemRepo.findAll(), new TypeToken<ArrayList<ItemDTO>>() {
        }.getType());
        return new ResponseUtil("OK", "Successfully Loaded ! ", mapper);
    }


    @GetMapping("/load_all_order_details_table")
    public ResponseUtil getOrderDetails() {
       /* ArrayList<OrderDetailsDTO> mapper = modelMapper.map(orderDetailsRepo.findAll(), new TypeToken<ArrayList<OrderDetailsDTO>>() {
        }.getType());*/
        return new ResponseUtil("OK", "Successfully Loaded ! ", "");
    }

    @GetMapping("/load_all_orders_table")
    public ResponseUtil getOrder() {
        return new ResponseUtil("OK", "Successfully Loaded ! ", "");
    }

    @PostMapping("/get_transaction_details")
    public ResponseUtil getTransActionDetails(@RequestBody OrderDTO orderDTO) {
        Orders orders = modelMapper.map(orderDTO, Orders.class);
        if (orderRepo.existsById(orders.getOrder_id())) {
            throw new RuntimeException("Order Id - " + orders.getOrder_id() + " already exists !");
        }
        orderRepo.save(orders);


        for (OrderDetails od : orders.getFullObj()) {
            Item item = itemRepo.findById(od.getItem_code()).get();
            item.setQty(item.getQty() - od.getItem_qty());
            itemRepo.save(item);
        }

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
