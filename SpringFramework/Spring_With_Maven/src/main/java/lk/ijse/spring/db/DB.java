package lk.ijse.spring.db;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.dto.OrderDTO;
import lk.ijse.spring.dto.OrderDetailsDTO;

import java.util.ArrayList;

public class DB {
    public static ArrayList<CustomerDTO> customerList = new ArrayList<>();

    public static ArrayList<ItemDTO> itemList = new ArrayList<>();

    public static ArrayList<OrderDetailsDTO> order_details_list = new ArrayList<>();

    public static ArrayList<OrderDTO> orderList = new ArrayList<>();

}
