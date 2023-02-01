package lk.ijse.spring.controller;

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

        System.out.println("itemDTO to String - "+itemDTO.toString());

        System.out.println("itemList to String - "+itemList.toString());


        return new ResponseUtil("OK", "Successfully Registered !", "");
    }

    @DeleteMapping
    public ResponseUtil deleteItem(@RequestParam String itemId) {
        return new ResponseUtil("OK", "Successfully Deleted ! " + itemId, null);
    }

    @PutMapping
    public ResponseUtil updateItem(@RequestBody ItemDTO itemDTO) {
        return new ResponseUtil("OK", "Successfully updated ! " + itemDTO.getItemId(), "");
    }

    @GetMapping("item")
    public ResponseUtil getAllItem() {
        if (itemList.isEmpty()){
            itemList.add(new ItemDTO("I00-001", "Choco", 1000, 1250.00));
            itemList.add(new ItemDTO("I00-002", "Milk", 1000, 1300.00));
            itemList.add(new ItemDTO("I00-003", "Vanilla", 1000, 1200.00));
            itemList.add(new ItemDTO("I00-004", "Strawberry", 1000, 1500.00));
            itemList.add(new ItemDTO("I00-005", "MixFruit", 1000, 1750.00));
        }
        return new ResponseUtil("OK", "Successfully Loaded ! ", itemList);
    }

}
