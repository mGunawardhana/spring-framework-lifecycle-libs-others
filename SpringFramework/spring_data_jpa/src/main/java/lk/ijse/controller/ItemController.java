package lk.ijse.controller;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import static lk.ijse.spring.db.DB.itemList;

@RestController
@CrossOrigin
@RequestMapping("item")
public class ItemController {

    @PostMapping()
    public ResponseUtil saveItem(@ModelAttribute ItemDTO itemDTO) {
        itemList.add(itemDTO);
        return new ResponseUtil("OK", "Successfully Registered !", "");
    }

    @DeleteMapping
    public ResponseUtil deleteItem(String itemId) {
        System.out.println(itemId);
        ItemDTO ItemDTO = ifExistsItem(itemId);
        if (ItemDTO != null) {
            itemList.remove(ItemDTO);
        } else {
            throw new RuntimeException("Can't find Item");
        }
        return new ResponseUtil("OK", "Successfully Deleted ! " + itemId, null);
    }

    @PutMapping("update")
    public ResponseUtil updateItem(@RequestBody ItemDTO itemDTO) {
        ItemDTO searchItem = ifExistsItem(itemDTO.getItemId());
        if (searchItem != null) {
            searchItem.setItemName(itemDTO.getItemName());
            searchItem.setUnitPrice(itemDTO.getUnitPrice());
            searchItem.setQty(itemDTO.getQty());
        } else {
            throw new RuntimeException("Cannot update item");
        }
        return new ResponseUtil("OK", "Successfully updated ! " + itemDTO.getItemId(), "");
    }

    @GetMapping("item")
    public ResponseUtil getAllItem() {
        if (itemList.isEmpty()) {
            itemList.add(new ItemDTO("I00-001", "Choco", 1000, 1250.00));
            itemList.add(new ItemDTO("I00-002", "Milk", 1000, 1300.00));
        }
        return new ResponseUtil("OK", "Successfully Loaded ! ", itemList);
    }

    public ItemDTO ifExistsItem(String itemId) {
        for (ItemDTO ItemDTO : itemList) {
            if (ItemDTO.getItemId().equals(itemId)) {
                return ItemDTO;
            }
        }
        return null;
    }


}
