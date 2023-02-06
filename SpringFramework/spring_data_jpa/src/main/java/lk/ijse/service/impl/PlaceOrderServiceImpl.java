package lk.ijse.service.impl;

import lk.ijse.dto.CustomerDTO;
import lk.ijse.dto.ItemDTO;
import lk.ijse.dto.OrderDTO;
import lk.ijse.dto.OrderDetailsDTO;
import lk.ijse.entity.Item;
import lk.ijse.entity.OrderDetails;
import lk.ijse.entity.Orders;
import lk.ijse.repo.CustomerRepo;
import lk.ijse.repo.ItemRepo;
import lk.ijse.repo.OrderDetailsRepo;
import lk.ijse.repo.OrderRepo;
import lk.ijse.service.PlaceOrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class PlaceOrderServiceImpl implements PlaceOrderService {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Override
    public ArrayList<CustomerDTO> loadAllCustomersInTheCombo() {
        return modelMapper.map(customerRepo.findAll(), new TypeToken<ArrayList<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public ArrayList<ItemDTO> loadAllItemsInTheCombo() {
        return modelMapper.map(itemRepo.findAll(), new TypeToken<ArrayList<ItemDTO>>() {
        }.getType());
    }

    @Override
    public ArrayList<OrderDetailsDTO> getAllOrderDetails() {
        return null;
    }

    @Override
    public ArrayList<OrderDTO> getAllOrders() {
        return null;
    }

    @Override
    public void manageTransAction(OrderDTO orderDTO) {
        Orders orders = modelMapper.map(orderDTO, Orders.class);
        if (orderRepo.existsById(orders.getOrder_id())) {
            throw new RuntimeException("Order Id - " + orders.getOrder_id() + " already exists !");
        }
        orderRepo.save(orders);
        for (OrderDetails od : orders.getFullObj()) {
            Item item = itemRepo.findById(od.getItem_code()).get();
            item.setQty(item.getQty() - od.getItem_qty());
            itemRepo.save(item);
        }
    }
}
