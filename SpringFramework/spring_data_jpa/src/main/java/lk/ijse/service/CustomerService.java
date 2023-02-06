package lk.ijse.service;

import lk.ijse.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
    public void saveCustomer(CustomerDTO customerDTO);
    public void updateCustomer(CustomerDTO customerDTO);
    public void deleteCustomer(String id);
    public ArrayList<CustomerDTO> getAllCustomers();

}
