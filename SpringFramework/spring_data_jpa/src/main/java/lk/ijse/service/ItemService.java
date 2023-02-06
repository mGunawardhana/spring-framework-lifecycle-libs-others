package lk.ijse.service;

import lk.ijse.dto.CustomerDTO;
import lk.ijse.dto.ItemDTO;

import java.util.ArrayList;

public interface ItemService {
    public void saveCustomer(ItemDTO itemDTO);
    public void updateCustomer(ItemDTO itemDTO);
    public void deleteCustomer(String id);
    public ArrayList<ItemDTO> getAllCustomers();
}
