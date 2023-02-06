package lk.ijse.service;

import lk.ijse.dto.CustomerDTO;
import lk.ijse.dto.ItemDTO;
import lk.ijse.dto.OrderDTO;
import lk.ijse.dto.OrderDetailsDTO;

import java.util.ArrayList;

public interface PlaceOrderService {
    public ArrayList<CustomerDTO> loadAllCustomersInTheCombo();

    public ArrayList<ItemDTO> loadAllItemsInTheCombo();

    public ArrayList<OrderDetailsDTO> getAllOrderDetails();

    public ArrayList<OrderDTO> getAllOrders();

    public void manageTransAction();

}
