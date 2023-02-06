package lk.ijse.service.impl;

import lk.ijse.dto.ItemDTO;
import lk.ijse.entity.Item;
import lk.ijse.repo.ItemRepo;
import lk.ijse.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveItem(ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getItemId())) {
            throw new RuntimeException("Customer Already Exist !");
        } else {
            itemRepo.save(modelMapper.map(itemDTO, Item.class));
        }
    }

    @Override
    public void updateItem(ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getItemId())) {
            itemRepo.save(modelMapper.map(itemDTO, Item.class));
        } else {
            throw new RuntimeException("Cannot find these customer id !");
        }
    }

    @Override
    public void deleteItem(String itemId) {
        if (itemRepo.existsById(itemId)) {
            itemRepo.deleteById(itemId);
        } else {
            throw new RuntimeException("No such a customer !");
        }
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() {
        return modelMapper.map(itemRepo.findAll(), new TypeToken<ArrayList<ItemDTO>>() {
        }.getType());
    }
}
