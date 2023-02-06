package lk.ijse.repo;

import lk.ijse.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Orders, String> {
}
