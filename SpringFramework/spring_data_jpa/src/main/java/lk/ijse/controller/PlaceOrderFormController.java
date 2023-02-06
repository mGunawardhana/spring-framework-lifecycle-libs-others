package lk.ijse.controller;

import lk.ijse.dto.CustomerDTO;
import lk.ijse.dto.ItemDTO;
import lk.ijse.dto.OrderDTO;
import lk.ijse.entity.Orders;
import lk.ijse.repo.CustomerRepo;
import lk.ijse.repo.ItemRepo;
import lk.ijse.repo.OrderRepo;
import lk.ijse.util.ResponseUtil;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@CrossOrigin
@RequestMapping("/place_order")
public class PlaceOrderFormController {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private OrderRepo orderRepo;


    @GetMapping(path = "/get_all_customers")
    public ResponseUtil getAllCustomersInToTheCombo(@ModelAttribute CustomerDTO customerDTO) {
        ArrayList<CustomerDTO> mapper = modelMapper.map(
                customerRepo.findAll(), new TypeToken<ArrayList<CustomerDTO>>() {
                }.getType());
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
        return new ResponseUtil("OK", "Successfully Loaded ! ", "");
    }

    @GetMapping("/load_all_orders_table")
    public ResponseUtil getOrder() {
        return new ResponseUtil("OK", "Successfully Loaded ! ", "");
    }

    @PostMapping("/get_transaction_details")
    public ResponseUtil getTransActionDetails(@RequestBody OrderDTO orderDTO) {
        Orders save = orderRepo.save(modelMapper.map(orderDTO, Orders.class));
        System.out.println(save.toString());
        return new ResponseUtil("OK", "Order Confirmed!", save);
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
