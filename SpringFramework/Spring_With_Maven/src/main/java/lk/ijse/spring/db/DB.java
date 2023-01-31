package lk.ijse.spring.db;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.dto.OrderDTO;
import lk.ijse.spring.dto.OrderDetailsDTO;

import java.util.ArrayList;

public class DB {
    public static ArrayList<CustomerDTO> customerDTO = new ArrayList<>();

    public static ArrayList<ItemDTO> itemDTO = new ArrayList<>();

    public static ArrayList<OrderDetailsDTO> orderDetailsDTO = new ArrayList<>();

    public static ArrayList<OrderDTO> orderDTO = new ArrayList<>();

}
