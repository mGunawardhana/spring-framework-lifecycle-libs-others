package lk.ijse.service;

import lk.ijse.dto.ItemDTO;

import java.util.ArrayList;

public interface ItemService {
    public void saveItem(ItemDTO itemDTO);
    public void updateItem(ItemDTO itemDTO);
    public void deleteItem(String id);
    public ArrayList<ItemDTO> getAllItems();
}
