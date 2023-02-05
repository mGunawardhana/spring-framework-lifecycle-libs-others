package lk.ijse.controller;

import lk.ijse.dto.CustomerDTO;
import lk.ijse.dto.ItemDTO;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Item;
import lk.ijse.repo.ItemRepo;
import lk.ijse.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


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
        if (itemRepo.existsById(itemDTO.getItemId())) {throw new RuntimeException("Customer Already Exist !");
        } else {itemRepo.save(modelMapper.map(itemDTO, Item.class));}
        return new ResponseUtil("OK", "Successfully Registered !", "");
    }

    @DeleteMapping
    public ResponseUtil deleteItem(String itemId) {
        if (itemRepo.existsById(itemId)) {itemRepo.deleteById(itemId);} else
        { throw new RuntimeException("No such a customer !"); }
        return new ResponseUtil("OK", "Successfully Deleted ! " + itemId, null);
    }

    @PutMapping("update")
    public ResponseUtil updateItem(@RequestBody ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getItemId())) {itemRepo.save(modelMapper.map(itemDTO, Item.class));
        } else {throw new RuntimeException("Cannot find these customer id !");}
        return new ResponseUtil("OK", "Successfully updated ! " + itemDTO.getItemId(), "");
    }

    @GetMapping("item")
    public ResponseUtil getAllItem() {
        ArrayList<ItemDTO> mapper = modelMapper.map(itemRepo.findAll(), new TypeToken<ArrayList<ItemDTO>>() {
        }.getType());
        return new ResponseUtil("OK", "Successfully Loaded ! ", mapper);
    }
}
