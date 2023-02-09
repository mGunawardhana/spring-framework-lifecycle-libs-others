package lk.ijse.repo;

import lk.ijse.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, String> {
    Customer findCustomerByName(String name);
    Customer findCustomerById(String id);
    @Query(value = "select * from Customer",nativeQuery = true)
    List<Customer> methodName();
}
