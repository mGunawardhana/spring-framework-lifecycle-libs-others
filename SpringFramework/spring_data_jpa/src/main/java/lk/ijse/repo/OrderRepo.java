package lk.ijse.repo;

import lk.ijse.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Customer,String> {
}
