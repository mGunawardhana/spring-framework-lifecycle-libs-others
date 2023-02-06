package lk.ijse.controller;

import lk.ijse.dto.ItemDTO;
import lk.ijse.service.ItemService;
import lk.ijse.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("item")
public class ItemController {
    @Autowired
    public ItemService itemService;

    @PostMapping()
    public ResponseUtil saveItem(@ModelAttribute ItemDTO itemDTO) {
        itemService.saveItem(itemDTO);
        return new ResponseUtil("OK", "Successfully Registered !", "");
    }

    @DeleteMapping
    public ResponseUtil deleteItem(String itemId) {
        itemService.deleteItem(itemId);
        return new ResponseUtil("OK", "Successfully Deleted ! " + itemId, null);
    }

    @PutMapping("update")
    public ResponseUtil updateItem(@RequestBody ItemDTO itemDTO) {
        itemService.updateItem(itemDTO);
        return new ResponseUtil("OK", "Successfully updated ! " + itemDTO.getItemId(), "");
    }

    @GetMapping("item")
    public ResponseUtil getAllItem() {
        return new ResponseUtil("OK", "Successfully Loaded ! ", itemService.getAllItems());
    }
}
