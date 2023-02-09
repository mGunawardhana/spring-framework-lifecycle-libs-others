package lk.ijse.repo;

import lk.ijse.config.WebRootConfig;
import lk.ijse.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@WebAppConfiguration
@ContextConfiguration(classes = {WebRootConfig.class})
@ExtendWith(SpringExtension.class)
class CustomerRepoTest {

    @Autowired
    CustomerRepo customerRepo;

    @Test
    void findCustomerByName() {
        Customer name = customerRepo.findCustomerByName("maneesha");
        System.out.println(name.toString());
    }
    @Test
    void findCustomerById(){
        Customer customerById = customerRepo.findCustomerById("C00-003");
        System.out.println(customerById.toString());
    }

    @Test
    void getAll(){
        List<Customer> customersList = customerRepo.methodName();
        for (Customer customer : customersList) {
            System.out.println(customer.toString());
        }
    }

}