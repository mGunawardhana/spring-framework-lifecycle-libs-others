package lk.ijse.entity;

import lk.ijse.dto.OrderDetailsDTO;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Orders {
    @Id
    private String order_id;
    private String order_date;
    private String customer_id;
    private String customer_name;
    private String customer_contact;
    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL)
    private List<OrderDetails> fullObj;
}

