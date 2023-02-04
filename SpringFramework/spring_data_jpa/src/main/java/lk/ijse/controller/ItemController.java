package lk.ijse.controller;

import lk.ijse.dto.ItemDTO;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Item;
import lk.ijse.repo.ItemRepo;
import lk.ijse.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin
@RequestMapping("item")
public class ItemController {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping()
    public ResponseUtil saveItem(@ModelAttribute ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getItemId())){
            throw new RuntimeException("Customer Already Exist !");
        }else {
            itemRepo.save(modelMapper.map(itemDTO, Item.class));
        }        return new ResponseUtil("OK", "Successfully Registered !", "");
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
