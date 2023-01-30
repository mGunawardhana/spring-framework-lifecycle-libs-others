package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("item")
public class ItemController {

    @PostMapping
    public ResponseUtil saveItem(@ModelAttribute ItemDTO itemDTO) {
        return new ResponseUtil("OK", "Successfully Registered !", null);
    }

    @DeleteMapping(params = {"itemId"})
    public ResponseUtil deleteItem(@RequestParam String itemId) {
        return new ResponseUtil("OK", "Successfully Deleted ! " + itemId, null);
    }

    @PutMapping
    public ResponseUtil updateItem(@RequestBody ItemDTO itemDTO) {
        return new ResponseUtil("OK", "Successfully updated ! " + itemDTO.getItemId(), null);
    }

    @GetMapping("item")
    public ResponseUtil getAllItem() {
        List<ItemDTO> list = new ArrayList<>();
        list.add(new ItemDTO("I00-001","Choco",1000,1250.00));
        list.add(new ItemDTO("I00-002","Milk",1000,1300.00));
        list.add(new ItemDTO("I00-003","Vanilla",1000,1200.00));
        list.add(new ItemDTO("I00-004","Strawberry",1000,1500.00));
        list.add(new ItemDTO("I00-005","MixFruit",1000,1750.00));
        return new ResponseUtil("OK", "Successfully Loaded ! ", list);
    }

}
