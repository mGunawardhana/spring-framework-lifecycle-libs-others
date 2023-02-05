package lk.ijse.repo;

import lk.ijse.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepo extends JpaRepository<Customer,String> {
}
