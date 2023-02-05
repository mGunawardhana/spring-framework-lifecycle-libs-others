package lk.ijse.controller;

import lk.ijse.dto.CustomerDTO;
import lk.ijse.dto.ItemDTO;
import lk.ijse.dto.OrderDTO;
import lk.ijse.dto.OrderDetailsDTO;
import lk.ijse.repo.CustomerRepo;
import lk.ijse.util.ResponseUtil;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static lk.ijse.db.DB.*;

@RestController
@CrossOrigin
@RequestMapping("/place_order")
public class PlaceOrderFormController {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(path = "/get_all_customers")
    public ResponseUtil getAllCustomersInToTheCombo(@ModelAttribute CustomerDTO customerDTO) {
        ArrayList<CustomerDTO> mapper= modelMapper.map(
                customerRepo.findAll(), new TypeToken<ArrayList<CustomerDTO>>() {}.getType());
        return new ResponseUtil("OK", "Successfully Loaded ! ", mapper);
    }

    @GetMapping("/get_all_items")
    public ResponseUtil getAllItemsInToTheCombo() {

        return new ResponseUtil("OK", "Successfully Loaded ! ", "");
    }


    @GetMapping("/load_all_order_details_table")
    public ResponseUtil getOrderDetails() {
        return new ResponseUtil("OK", "Successfully Loaded ! ", order_details_list);
    }

    @GetMapping("/load_all_orders_table")
    public ResponseUtil getOrder() {
        return new ResponseUtil("OK", "Successfully Loaded ! ", orderList);
    }

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
