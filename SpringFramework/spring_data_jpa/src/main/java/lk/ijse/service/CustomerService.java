package lk.ijse.service;

import lk.ijse.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    void updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(String id);

    ArrayList<CustomerDTO> getAllCustomers();

    CustomerDTO searchCustomerByName(String name);

}
